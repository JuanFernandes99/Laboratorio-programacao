package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SimpleResponse;
import com.example.demo.model.Pessoa;
import com.example.demo.service.PessoaEmpresaSalarioService;

@RestController
public class PessoaController {
	private final PessoaEmpresaSalarioService pessoaEmpresaSalarioService;

	@Autowired
	public PessoaController(PessoaEmpresaSalarioService pessoaEmpresaSalarioService) {
		this.pessoaEmpresaSalarioService = pessoaEmpresaSalarioService;
	}

	@CrossOrigin
	@PostMapping("/addPessoa")
	public ResponseEntity<SimpleResponse> addPessoa(@RequestBody Pessoa aPessoa) {
		SimpleResponse sr = new SimpleResponse();

		if (aPessoa.getNome() == null || aPessoa.getNome().isBlank()) {
			sr.setMessage("Nome inválido");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}
		if (aPessoa.getIdade() < 0) {
			sr.setMessage("Idade inválida");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

		if (aPessoa.getEmail() == null || aPessoa.getEmail().isBlank()) {
			sr.setMessage("Tem que escrever um email");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}
		if (!pessoaEmpresaSalarioService.isValidEmailAddress(aPessoa.getEmail())) {
			sr.setMessage("E-mail inválido! ");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}
		if (aPessoa.getImagem() == null || aPessoa.getImagem().isBlank()) {
			sr.setMessage("Imagem inválida");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

		if (pessoaEmpresaSalarioService.addPessoa(aPessoa)) {
			sr.setSucess("Pessoa adicionada a empresa");
			return ResponseEntity.status(HttpStatus.OK).body(sr);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

	}

	@CrossOrigin
	@GetMapping("/getAllPessoas")
	public List<Pessoa> getAllPessoas() {
		return pessoaEmpresaSalarioService.getListaPessoas();
	}

	@CrossOrigin
	@DeleteMapping("/deletePessoa")
	public ResponseEntity<SimpleResponse> deletePessoa(@RequestBody Pessoa pessoa) {
		SimpleResponse sr = new SimpleResponse();

		if (pessoaEmpresaSalarioService.deletePessoa(pessoa)) {
			sr.setSucess("Pessoa removida com sucesso");
			return ResponseEntity.status(HttpStatus.OK).body(sr);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}
	}

	@CrossOrigin
	@GetMapping("/getPessoasByEmpresa/{aEmpresa_id}")
	public List<Pessoa> getPessoasByEmpresa(@PathVariable String aEmpresa_id) {
		return pessoaEmpresaSalarioService.getPessoasByEmpresaId(aEmpresa_id);
	}

}
