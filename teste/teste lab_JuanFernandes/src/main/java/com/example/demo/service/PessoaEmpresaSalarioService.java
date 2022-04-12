package com.example.demo.service;

import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Empresa;
import com.example.demo.model.Pessoa;
import com.example.demo.model.Salario;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.repository.SalarioRepository;

@Service
public class PessoaEmpresaSalarioService {
	private final EmpresaRepository empresaRepository;
	private final PessoaRepository pessoaRepository;
	private final SalarioRepository salarioRepository;

	@Autowired
	public PessoaEmpresaSalarioService(EmpresaRepository empresaRepository, PessoaRepository pessoaRepository,
			SalarioRepository salarioRepository) {
		this.empresaRepository = empresaRepository;
		this.pessoaRepository = pessoaRepository;
		this.salarioRepository = salarioRepository;
	}

	// mostrar erro que tem de ter a empresa a null
	public boolean addEmpresa(Empresa aEmpresa) {
		if (aEmpresa.getId() == null) {
			empresaRepository.save(aEmpresa);
			return true;
		}
		return false;
	}

	public boolean addPessoa(Pessoa aPessoa) {

		if (aPessoa.getId() == null) {
			pessoaRepository.save(aPessoa);
			return true;
		}
		return false;
	}

	public boolean isValidEmailAddress(String aEmail) {
		String regx = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(aEmail);
		if (matcher.matches()) {
			return true;

		}
		return false;

	}

	public List<Empresa> getListaEmpresas() {
		ArrayList<Empresa> empresas = new ArrayList<>();

		empresaRepository.findAll().forEach(empresas::add);

		return empresas;
	}

	public List<Salario> getListaSalarios() {
		ArrayList<Salario> salarios = new ArrayList<>();

		salarioRepository.findAll().forEach(salarios::add);

		return salarios;
	}

	public List<Pessoa> getListaPessoas() {
		ArrayList<Pessoa> pessoas = new ArrayList<>();

		pessoaRepository.findAll().forEach(pessoas::add);

		return pessoas;
	}

	public boolean addSalario(Salario aSalario) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(aSalario.getPessoa().getId());
		Pessoa pessoaAux = pessoa.get();

		if (aSalario.getId() == null) {
			aSalario.setPessoa(pessoaAux);
			pessoaAux.addSalario(aSalario);
			salarioRepository.save(aSalario);
			pessoaRepository.save(pessoaAux);

			return true;
		}
		return false;
	}

	public boolean verificarSalario(Salario aSalario) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(aSalario.getPessoa().getId());
		Pessoa pessoaAux = pessoa.get();

		Calendar newSalario = Calendar.getInstance();
		newSalario.setTime(aSalario.getData());
		Calendar oldSalario = Calendar.getInstance();

		for (Salario pessoaSalario : pessoaAux.getListaSalarios()) {
			oldSalario.setTime(pessoaSalario.getData());
			if (newSalario.get(Calendar.MONTH) == oldSalario.get(Calendar.MONTH)
					&& newSalario.get(Calendar.YEAR) == oldSalario.get(Calendar.YEAR)) {
				return false;
			}

		}
		return true;
	}

	public Optional<Pessoa> getPessoa(Pessoa pessoa) {
		if (pessoa.getId() != null) {
			ArrayList<Pessoa> pessoaAux = new ArrayList<>();
			pessoaRepository.findAll().forEach(pessoaAux::add);

			for (Pessoa aux : pessoaAux) {
				if (aux.getId().equals(pessoa.getId())) {
					return Optional.of(aux);
				}
			}
		}
		return Optional.empty();
	}

	public boolean deletePessoa(Pessoa pessoa) {
		Optional<Pessoa> pessoaOptional = getPessoa(pessoa);
		if (pessoaOptional.isEmpty()) {
			return false;
		}

		Pessoa p = pessoaOptional.get();
		Empresa emp = p.getEmpresa();

		emp.removePessoa(p);
		empresaRepository.save(emp);
		pessoaRepository.delete(p);

		return true;
	}

	public boolean deleteEmpresa(String aEmpresa_id) {
		Long id_long = parseLong(aEmpresa_id);
		Optional<Empresa> empOptional = empresaRepository.findById(id_long);

		if (empOptional.isEmpty()) {
			return false;
		}

		Empresa empresaToDelete = empOptional.get();

		for (Pessoa pessoaAux : empresaToDelete.getListaPessoas()) {
			for (Salario salarioAux : pessoaAux.getListaSalarios()) {
				salarioRepository.delete(salarioAux);

			}
			pessoaRepository.delete(pessoaAux);
		}

		empresaRepository.delete(empresaToDelete);

		return true;
	}

	public List<Pessoa> getPessoasByEmpresaId(String aEmpresa_id) {
		Long id_long = parseLong(aEmpresa_id);
		Optional<Empresa> empresaOpcional = empresaRepository.findById(id_long);
		return empresaOpcional.get().getListaPessoas();

	}

	public List<Salario> getSalarioByPessoa(String aPessoa_id) {
		Long id_long = parseLong(aPessoa_id);
		Optional<Pessoa> pessoaOpcional = pessoaRepository.findById(id_long);
		return pessoaOpcional.get().getListaSalarios();

	}

	public boolean DeleteEmpresa(Empresa emp) {
		Optional<Empresa> empOptional = empresaRepository.findById(emp.getId());

		if (empOptional.isEmpty()) {
			return false;
		}

		Empresa empresaToDelete = empOptional.get();

		for (Pessoa aux : empresaToDelete.getListaPessoas()) {
			pessoaRepository.delete(aux);
		}

		empresaRepository.delete(empresaToDelete);

		return true;
	}

	public boolean deleteSalario(Salario aSalario) {
		Optional<Salario> salarioOptional = salarioRepository.findById(aSalario.getId());

		if (salarioOptional.isEmpty()) {
			return false;
		}

		Salario salario = salarioOptional.get();

		salarioRepository.delete(salario);

		return true;
	}

}
