package com.example.demo.controller;

import java.util.Collections;
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
import com.example.demo.model.Empresa;
import com.example.demo.model.Pessoa;
import com.example.demo.service.ServiceEmpresa;
import com.example.demo.service.ServicePessoa;

//controlador trata exceçao e chama a funçao do service
@RestController
public class ControladorEmpresa {
	private final ServiceEmpresa serviceEmpresa;
	private final ServicePessoa servicePessoa;

	@Autowired
	public ControladorEmpresa(ServiceEmpresa aServiceEmpresa, ServicePessoa aServicePessoa) {
		serviceEmpresa = aServiceEmpresa;
		servicePessoa = aServicePessoa;
	}

	@PostMapping("/addPessoa")
	public ResponseEntity<SimpleResponse> addPessoa(@RequestBody Pessoa aPessoa) {

		Empresa empresa = serviceEmpresa.getEmpresaById(aPessoa.getEmpresaId());
		empresa.adicionarPessoa(aPessoa);

		return servicePessoa.addPessoa(aPessoa);
	}

	@PutMapping("/updatePessoa")
	public String updatePessoaById(@RequestBody Pessoa aPessoa) {
		if (servicePessoa.updatePessoaById(aPessoa)) {
			return "Pessoa updated com sucesso";
		}
		return "Erro a atualizar a pessoa";
	}

	@GetMapping("/getPessoas")
	public List<Pessoa> getPessoas() {
		return servicePessoa.getAllPessoas();
	}

	@DeleteMapping("/deletePessoa/{id}")
	public ResponseEntity<SimpleResponse> deletePessoa(@PathVariable String aId) {
		return servicePessoa.deletePessoaById(aId);
	}

	@GetMapping("/getPessoasById/{id}")
	public ResponseEntity<SimpleResponse> getPessoaById(@PathVariable String aId) {
		return servicePessoa.getPessoaById(aId);
	}

	@PostMapping("/addEmpresa")
	public ResponseEntity<SimpleResponse> addEmpresa(@RequestBody Empresa aEmpresa) {

		return serviceEmpresa.addEmpresa(aEmpresa);
	}

	@GetMapping("/getEmpresas")
	public List<Empresa> getEmpresas() {
		return serviceEmpresa.getAllEmpresas();
	}

	@GetMapping("/getEmpresasById/{id}")
	public Empresa getEmpresaById(@PathVariable int aId) {
		return serviceEmpresa.getEmpresaById(aId);
	}
	
	@DeleteMapping("/deleteEmpresa/{id}")
	public ResponseEntity<SimpleResponse> deleteEmpresa(@PathVariable int aId) {
		return serviceEmpresa.deleteEmpresaById(aId);
	}
	@GetMapping("/PessoaTesteParametros")
	public Pessoa pessoaTesteParametros() {
		return servicePessoa.testeParametros();
	}

	@GetMapping("/EmpresaTesteParametros")
	public Empresa empresaTesteParametros() {
		return serviceEmpresa.testeParametros();
	}

}
