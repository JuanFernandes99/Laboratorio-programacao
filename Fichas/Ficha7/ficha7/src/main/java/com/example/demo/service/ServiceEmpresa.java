package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SimpleResponse;
import com.example.demo.dto.SimpleResponseEmpresas;
import com.example.demo.dto.SimpleResponsePessoas;
import com.example.demo.model.Empresa;
import com.example.demo.model.Pessoa;

@Service
public class ServiceEmpresa {

	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	List<Empresa> empresas = new ArrayList<Empresa>();
	SimpleResponse sr = new SimpleResponse();
	SimpleResponsePessoas srp = new SimpleResponsePessoas(pessoas);
	SimpleResponseEmpresas sre = new SimpleResponseEmpresas(empresas);

	public ResponseEntity<SimpleResponse> addEmpresa(Empresa aEmpresa) {
		if (aEmpresa.getMorada().isBlank() || aEmpresa.getMorada() == null) {

			sre.setMessage("Morada invalida");

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sr);
		}

		if (aEmpresa.getNome().isBlank() || aEmpresa.getNome() == null) {

			sr.setMessage("Nome invalido");

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sr);
		}

		sre.setAsSucess("Empresa adicionada com sucesso");
		System.out.println(aEmpresa);
		empresas.add(aEmpresa);

		return ResponseEntity.status(HttpStatus.OK).body(sre);

	}

	public Boolean updateEmpresaById(Empresa aEmpresa) {

		for (Empresa empresa : empresas) {

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

	public ResponseEntity<SimpleResponse> deleteEmpresaById(int aId) {
		try {

			for (Empresa empresa : empresas) {

				if (empresa.getId() == aId) {
					empresas.remove(empresa);
					for (Pessoa pessoa : pessoas) {
						if (pessoa.getEmpresaId() == aId) {
							pessoas.remove(pessoa);

						}

					}
					sre.setAsSucess("Empresas e pessoas da empresa eliminadas com sucesso");
					return ResponseEntity.status(HttpStatus.OK).body(sre);
				}

			}

			sr.setMessage("Id não existe ");

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sr);
		} catch (Exception e) {
			sr.setMessage("Id Invalido");

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sr);
		}

	}

	public List<Empresa> getAllEmpresas() {
		return empresas;
	}

	public Empresa getEmpresaById(int aId) { // melhorar
		try {
			for (Empresa empresa : empresas) {

				if (empresa.getId() == aId) {
					return empresa;
				}
			}
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	public Empresa testeParametros() {
		Empresa e = new Empresa("Juan Empresa", "Funchal");
		return e;
	}

	public ResponseEntity<SimpleResponse> addPessoa(Pessoa aPessoa) {

		if (0 >= aPessoa.getIdade()) {

			sr.setMessage("Idade tem que ser superior a 0");

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sr);
		}

		if (aPessoa.getEmail().isBlank() || aPessoa.getEmail() == null) {

			sr.setMessage("Email invalido");

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sr);
		}

		if (aPessoa.getNome().isBlank() || aPessoa.getNome() == null) {

			sr.setMessage("Nome invalido");

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sr);
		}

		Empresa empresa = getEmpresaById(aPessoa.getEmpresaId());
		empresa.adicionarPessoa(aPessoa);

		srp.setAsSucess("Pessoa adicionada com sucesso");
		System.out.println(aPessoa);
		pessoas.add(aPessoa);

		return ResponseEntity.status(HttpStatus.OK).body(srp);

		// HttpStatus é a resposta do servidor
		// o sr por default é false por isso quando faço setAsSucess é true.

	}

	public Boolean updatePessoaById(Pessoa aPessoa) {
		for (Pessoa pessoaAux : pessoas) {
			if (pessoaAux.getId() == aPessoa.getId()) {

				if (aPessoa.getIdade() > 0) {
					pessoaAux.setIdade(aPessoa.getIdade());
				}

				if (aPessoa.getNome() != null && aPessoa.getNome().isBlank()) {
					pessoaAux.setNome(aPessoa.getNome());
				}

				if (aPessoa.getEmail().isBlank() || aPessoa.getEmail() == null) {

					pessoaAux.setEmail(aPessoa.getEmail());
				}

				return true;
			}
		}

		return false;
	}

	public ResponseEntity<SimpleResponse> deletePessoaById(String aId) {
		try {
			Long id_pessoa = Long.parseLong(aId);

			for (Pessoa pessoaAux : pessoas) {
				if (pessoaAux.getId() == id_pessoa) {
					pessoas.remove(pessoaAux);
					srp.setAsSucess("Pessoa eliminada com sucesso");
					return ResponseEntity.status(HttpStatus.OK).body(srp);
				}
			}
			sr.setMessage("Id não existe ");

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sr);
		} catch (Exception e) {
			sr.setMessage("Id Invalido");

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sr);
		}
	}

	public List<Pessoa> getAllPessoas() {
		return pessoas;
	}

	public ResponseEntity<SimpleResponse> getPessoaById(String aId) {
		try {
			Integer id_pessoa = Integer.parseInt(aId);

			for (Pessoa pessoa : pessoas) {

				if (pessoa.getId() == id_pessoa) {
					sr.setAsSucess("Pessoa com id solicitado: " + pessoa);
					return ResponseEntity.status(HttpStatus.OK).body(sr);
				}
			}
			sr.setMessage("Id não existe ");

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sr);
		} catch (Exception e) {
			sr.setMessage("Id Invalido");

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sr);
		}

	}

	public Pessoa testeParametrosPessoa() {
		Pessoa p = new Pessoa("David", 7, 1, "juan@gmail.com");
		return p;
	}

}
