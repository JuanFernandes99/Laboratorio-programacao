package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SimpleResponse;
import com.example.demo.model.Pessoa;
import com.example.demo.service.ServiceEmpresa;

@RestController
public class ControladorPessoa {
	private final ServiceEmpresa serviceEmpresa;

	@Autowired
	public ControladorPessoa(ServiceEmpresa aServiceEmpresa) {
		serviceEmpresa = aServiceEmpresa;
	}

	@PostMapping("/addPessoa")
	public ResponseEntity<SimpleResponse> addPessoa(@RequestBody Pessoa aPessoa) {

		return serviceEmpresa.addPessoa(aPessoa);
	}

	@PutMapping("/updatePessoa")
	public String updatePessoaById(@RequestBody Pessoa aPessoa) {
		if (serviceEmpresa.updatePessoaById(aPessoa)) {
			return "Pessoa updated com sucesso";
		}
		return "Erro a atualizar a pessoa";
	}

	@GetMapping("/getPessoas")
	public List<Pessoa> getPessoas() {
		return serviceEmpresa.getAllPessoas();
	}

	@DeleteMapping("/deletePessoa/{aId}")
	public ResponseEntity<SimpleResponse> deletePessoa(@PathVariable String aId) {
		return serviceEmpresa.deletePessoaById(aId);
	}

	@GetMapping("/getPessoasById/{aId}")
	public ResponseEntity<SimpleResponse> getPessoaById(@PathVariable String aId) {
		return serviceEmpresa.getPessoaById(aId);
	}

	@GetMapping("/PessoaTesteParametros")
	public Pessoa empresaTesteParametros() {
		return serviceEmpresa.testeParametrosPessoa();
	}

}
