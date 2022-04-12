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
import com.example.demo.model.Salario;
import com.example.demo.service.PessoaEmpresaSalarioService;

@RestController
public class SalarioController {
	private final PessoaEmpresaSalarioService pessoaEmpresaSalarioService;

	@Autowired
	public SalarioController(PessoaEmpresaSalarioService pessoaEmpresaSalarioService) {
		this.pessoaEmpresaSalarioService = pessoaEmpresaSalarioService;
	}

	@CrossOrigin
	@PostMapping("/addSalario")
	public ResponseEntity<SimpleResponse> addEmpresa(@RequestBody Salario aSalario) {
		SimpleResponse sr = new SimpleResponse();
		if (aSalario.getData() == null) {
			sr.setMessage("Data inválida");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}
		if (aSalario.getQuantidade() < 0) {
			sr.setMessage("Quantidade inválida");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}
		if (!pessoaEmpresaSalarioService.verificarSalario(aSalario)) {
			sr.setSucess("Já foi inserido um salário neste mês ");
			return ResponseEntity.status(HttpStatus.OK).body(sr);
		}
		if (pessoaEmpresaSalarioService.addSalario(aSalario)) {
			sr.setSucess("Sucesso ao inserir o salario");
			return ResponseEntity.status(HttpStatus.OK).body(sr);
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
	}

	@CrossOrigin
	@GetMapping("/getAllSalarios")
	public List<Salario> getAllSalarios() {
		return pessoaEmpresaSalarioService.getListaSalarios();
	}

	@CrossOrigin
	@DeleteMapping("/deleteSalario")
	public ResponseEntity<SimpleResponse> deleteSalario(@RequestBody Salario salario) {
		SimpleResponse sr = new SimpleResponse();

		if (pessoaEmpresaSalarioService.deleteSalario(salario)) {
			sr.setSucess("Sucesso ao remover o salario");
			return ResponseEntity.status(HttpStatus.OK).body(sr);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sr);
	}

	@CrossOrigin
	@GetMapping("/getSalariosByPessoa/{aPessoa_id}")
	public List<Salario> getSalariosByPessoa(@PathVariable String aPessoa_id) {
		return pessoaEmpresaSalarioService.getSalarioByPessoa(aPessoa_id);
	}
}
