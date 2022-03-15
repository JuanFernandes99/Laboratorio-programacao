package com.example.demoAula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoAula.dto.SimpleResponse;
import com.example.demoAula.dto.SimpleResponseEmpresas;
import com.example.demoAula.model.Empresa;
import com.example.demoAula.service.EmpresaService;

@RestController
public class EmpresaController {

	private final EmpresaService empresa_service;

	@Autowired
	public EmpresaController(EmpresaService aEmpresa_service) {

		empresa_service = aEmpresa_service;
	}

	@GetMapping("/getEmpresas")
	public List<Empresa> getEmpresas() {
		return empresa_service.getEmpresas();
	}

	@PostMapping(path = "/addEmpresa")
	public ResponseEntity<SimpleResponse> addEmpresas(@RequestBody Empresa aEmpresa) {
		SimpleResponseEmpresas sr = new SimpleResponseEmpresas();

		if (aEmpresa.getNome() == null || aEmpresa.getNome().isBlank()) {
			sr.setMessage("Nome Invalido");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

		if (aEmpresa.getMorada() == null || aEmpresa.getMorada().isBlank()) {
			sr.setMessage("Morada Invalida");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

		if (empresa_service.addEmpresa(aEmpresa)) {
			sr.setAsSuccess("Empresa Inserida Com Sucesso");
			sr.setEmpresas(empresa_service.getEmpresas());
			return ResponseEntity.status(HttpStatus.OK).body(sr);

		} else {
			sr.setAsError("Erro ao inserir a Empresa");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

	}

	@DeleteMapping("/removeEmpresa/{aId}")
	public SimpleResponse removePessoa2(@PathVariable String aId) {
		SimpleResponse sr = new SimpleResponse();

		if (empresa_service.removeEmpresa2(aId)) {
			sr.setAsSuccess("Empresa Removida Com Sucesso");
		} else {
			sr.setAsError("Erro a Remover a Empresa");
		}

		return sr;
	}

	@DeleteMapping("/removeEmpresa")
	public SimpleResponse removePessoa(@RequestBody Empresa aEmpresa) {
		SimpleResponseEmpresas sr = new SimpleResponseEmpresas();
		sr.setAsSuccess("Sucesso");

		if (empresa_service.removeEmpresa(aEmpresa)) {
			sr.setAsSuccess("Empresa Removida Com Sucesso");
		} else {
			sr.setAsError("Erro a Remover a Empresa");
		}

		return sr;
	}

	@PutMapping("/updateEmpresa")
	public SimpleResponse updatePessoa(@RequestBody Empresa aEmpresa) {
		SimpleResponse sr = new SimpleResponse();

		if (aEmpresa.getId() == null) {
			sr.setAsError("Id invalido");
			return sr;
		}

		if (aEmpresa.getNome() == null || aEmpresa.getNome().isBlank()) {
			sr.setAsError("Nome Invalido");
			return sr;
		}
		if (aEmpresa.getMorada() == null || aEmpresa.getMorada().isBlank()) {
			sr.setMessage("Morada Invalida");
			return sr;
		}

		boolean suc = empresa_service.updateEmpresa(aEmpresa);

		if (suc) {
			sr.setAsSuccess("Empresa atualizada com sucesso");
		} else {
			sr.setAsError("Erro na atualização da empresa " + aEmpresa.getId());
		}
		return sr;

	}

}
