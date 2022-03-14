package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SimpleResponse;
import com.example.demo.dto.SimpleResponsePessoas;
import com.example.demo.model.Pessoa;

@Service
public class ServicePessoa {

	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	SimpleResponse sr = new SimpleResponse();
	SimpleResponsePessoas srp = new SimpleResponsePessoas();
	


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

	public Pessoa testeParametros() {
		Pessoa p = new Pessoa("David", 7, 1, "juan@gmail.com");
		return p;
	}

}
