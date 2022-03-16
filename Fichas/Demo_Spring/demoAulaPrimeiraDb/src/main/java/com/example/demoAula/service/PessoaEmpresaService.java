package com.example.demoAula.service;

import com.example.demoAula.model.Pessoa;
import com.example.demoAula.repository.EmpresaRepository;
import com.example.demoAula.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demoAula.model.Empresa;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaEmpresaService {
	private final PessoaRepository pessoaRepo;
	private final EmpresaRepository empresaRepo;
	// PessoaRepository é a base de dados

	@Autowired
	public PessoaEmpresaService(PessoaRepository aPessoaRepo, EmpresaRepository aEmpresaRepo) {
		pessoaRepo = aPessoaRepo;
		empresaRepo = aEmpresaRepo;
	}
	public boolean addEmpresa(Empresa aEmpresa) {
		if (aEmpresa.getId() == null || aEmpresa.getNumFuncionariosAtual() == 0 || aEmpresa.getNumFuncionariosDesdeCriacao() == 0) {
			empresaRepo.save(aEmpresa);
			return true;
		}
		return false;
	}

	public boolean removeEmpresa(Empresa aEmpresa) {
		if (aEmpresa.getId() == null || empresaRepo.findById(aEmpresa.getId()).isEmpty()) {
			return false;
		}

		Empresa empresa = empresaRepo.findById(aEmpresa.getId()).get(); // o get é para devolver a empresa
		empresaRepo.delete(empresa);

		return true;
	}

	public boolean removeEmpresa2(String aId) {
		
		try { // pq da excepçao se meto uma letrea
			Long id_long = parseLong(aId);
			 Optional<Empresa> empresaOpcional = empresaRepo.findById(id_long);
			if (aId == null || id_long == NaN || empresaRepo.findById(id_long).isEmpty()) {
				return false;
			}
			
	        if (empresaOpcional.isPresent()){
	            for (Pessoa p: empresaOpcional.get().getPessoas()) {
	                p.setEmpresa(null);
	                pessoaRepo.save(p);
	            }
	            
	        }

			Empresa empresa = empresaOpcional.get();
			empresaRepo.delete(empresa);

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean updateEmpresa(Empresa aEmpresa) {
		if (aEmpresa.getId() == null || empresaRepo.findById(aEmpresa.getId()).isEmpty()) {
			return false;
		}

		Empresa e = empresaRepo.findById(aEmpresa.getId()).get();

		if (e.getNome() != null || !e.getNome().isBlank()) {
			e.setNome(aEmpresa.getNome());
		}

		if (e.getMorada() != null || !e.getMorada().isBlank()) {
			e.setMorada(aEmpresa.getMorada());
		}


		empresaRepo.save(e);

		return true;
	}

	public List<Empresa> getEmpresas() {
		List<Empresa> listaEmpresas = new ArrayList<>();

		empresaRepo.findAll().forEach(listaEmpresas::add);

		return listaEmpresas;
	}

	public Optional<Empresa> getEmpresaById(Long aId) {
		return empresaRepo.findById(aId);
	}
	
	public boolean addPessoaToEmpresa(Pessoa aPessoa, Empresa aEmpresa) {
		Optional<Empresa> empresaOptional = empresaRepo.findById(aEmpresa.getId());

		// regular expression
		if (empresaOptional.isEmpty() || aPessoa.getNome() == null || aPessoa.getNome().isBlank()
				|| aPessoa.getEmail() == null || !aPessoa.getEmail().matches("^(.+)@(\\S+)$")
				|| aPessoa.getIdade() < 1) {
			return false;
		}
		Empresa empresaAux = empresaOptional.get();
		empresaAux.adicionarPessoa(aPessoa);
		aPessoa.setEmpresa(empresaAux);

		pessoaRepo.save(aPessoa);

		return true;
	}
	
	public boolean addPessoa(Pessoa pessoa) {
		if (pessoa.getId() == null) {
			pessoaRepo.save(pessoa);
			return true;
		}
		return false;
	}

	public boolean removePessoa(Pessoa aPessoa) {
		if (aPessoa.getId() == null || pessoaRepo.findById(aPessoa.getId()).isEmpty()) {
			return false;
		}

		Pessoa p = pessoaRepo.findById(aPessoa.getId()).get();
		pessoaRepo.delete(p);

		return true;
	}

	public boolean updatePessoa(Pessoa aPessoa) {
		if (aPessoa.getId() == null || pessoaRepo.findById(aPessoa.getId()).isEmpty()) // se é true é pq existe
		{
			return false;
		}

		Pessoa pessoa = pessoaRepo.findById(aPessoa.getId()).get();

		if (pessoa.getNome() != null || !pessoa.getNome().isBlank()) {
			pessoa.setNome(aPessoa.getNome());
		}

		if (pessoa.getEmail() != null || !pessoa.getEmail().isBlank()) {
			pessoa.setEmail(aPessoa.getEmail());
		}

		if (aPessoa.getIdade() > 0) {
			pessoa.setIdade(aPessoa.getIdade());
		}

		pessoaRepo.save(pessoa);

		return true;
	}

	public List<Pessoa> getPessoas() {
		List<Pessoa> listaPessoas = new ArrayList<>();

		pessoaRepo.findAll().forEach(listaPessoas::add);

		return listaPessoas;
	}

	public Optional<Pessoa> getPessoa(Long id) {
		return pessoaRepo.findById(id);
	}
	

}
