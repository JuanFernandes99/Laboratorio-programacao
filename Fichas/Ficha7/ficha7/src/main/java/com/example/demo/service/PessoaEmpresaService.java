package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.demo.model.Empresa;
import com.example.demo.model.Pessoa;

@Service
public class PessoaEmpresaService {

	// é feito isto para usar as duas listas
	private List<Pessoa> listaPessoas;
	private List<Empresa> listaEmpresas;

	public PessoaEmpresaService() {
		listaEmpresas = new ArrayList<>();
		listaPessoas = new ArrayList<>();
	}

	public boolean addEmpresa(Empresa aEmpresa) {
		if (aEmpresa.getMorada() == null || aEmpresa.getMorada().isBlank() || aEmpresa.getNome() == null
				|| aEmpresa.getNome().isBlank()) {
			return false;
		}

		listaEmpresas.add(aEmpresa);
		return true;
	}

	public Boolean updateEmpresaById(Empresa aEmpresa) {

		for (Empresa empresa : listaEmpresas) {

			if (empresa.getId() == aEmpresa.getId()) {

				if (aEmpresa.getNome() != null && !aEmpresa.getNome().isBlank()) {

					empresa.setNome(aEmpresa.getNome());
				}

				if (aEmpresa.getMorada() != null && !aEmpresa.getMorada().isBlank()) {
					empresa.setMorada(aEmpresa.getMorada());
				}

				return true;
			}
		}

		return false;

	}

	public boolean deleteEmpresa(Empresa aEmpresa) {
		Optional<Empresa> empOptional = getEmpresaById(aEmpresa);

		if (empOptional.isEmpty()) {
			return false;
		}

		Empresa empresaToDelete = empOptional.get();

		for (Pessoa aux : empresaToDelete.getListaPessoas()) {
			listaPessoas.remove(aux);
		}

		listaEmpresas.remove(empresaToDelete);

		return true;
	}

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public Optional<Empresa> getEmpresaById(Empresa aEmpresa) { // testar
		if (aEmpresa.getId() != null) {
			for (Empresa aux : listaEmpresas) {
				if (aux.getId().equals(aEmpresa.getId())) {
					return Optional.of(aux);
				}
			}
		}

		return Optional.empty();

	}

	public Empresa testeParametros() {
		Empresa e = new Empresa("Juan Empresa", "Funchal");
		return e;
	}

	public boolean addPessoaToEmpresa(Pessoa aPessoa, Empresa aEmpresa) {
		Optional<Empresa> empresaOptional = getEmpresaById(aEmpresa);

		// regular expression
		if (empresaOptional.isEmpty() || aPessoa.getNome() == null || aPessoa.getNome().isBlank()
				|| aPessoa.getEmail() == null || !aPessoa.getEmail().matches("^(.+)@(\\S+)$")
				|| aPessoa.getIdade() < 1) {
			return false;
		}
		Empresa empresaAux = empresaOptional.get();
		empresaAux.adicionarPessoa(aPessoa);
		aPessoa.setEmpresa(empresaAux);

		listaPessoas.add(aPessoa);

		return true;
	}

	public boolean updatePessoa(Pessoa aPessoa) {
		Optional<Pessoa> pessoaOptional = getPessoaById(aPessoa);
		if (pessoaOptional.isEmpty()) {
			return false;
		}

		Pessoa pessoaToUpdate = pessoaOptional.get();

		if (aPessoa.getNome() != null && !aPessoa.getNome().isBlank()) {
			pessoaToUpdate.setNome(aPessoa.getNome());
		}

		if (aPessoa.getIdade() > 0) {
			pessoaToUpdate.setIdade(aPessoa.getIdade());
		}

		if (aPessoa.getEmail() != null && aPessoa.getEmail().matches("^(.+)@(\\S+)$")) {
			pessoaToUpdate.setEmail(aPessoa.getEmail());
		}

		return true;
	}

	public boolean deletePessoaById(Pessoa aPessoa) {
		Optional<Pessoa> pessoaOptional = getPessoaById(aPessoa);
		if (pessoaOptional.isEmpty()) {
			return false;
		}

		Pessoa pessoa = pessoaOptional.get();
		Empresa empresa = pessoa.getEmpresa();

		empresa.removerPessoa(pessoa);
		listaPessoas.remove(pessoa);

		return true;
	}

	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public Optional<Pessoa> getPessoaById(Pessoa aPessoa) {
		if (aPessoa.getId() != null) {
			for (Pessoa aux : listaPessoas) {
				if (aux.getId().equals(aPessoa.getId())) {
					return Optional.of(aux);
				}
			}
		}
		return Optional.empty();
	}

	public Pessoa testeParametrosPessoa() {
		Pessoa p = new Pessoa("David", 7, "juan@gmail.com");
		return p;
	}

}
