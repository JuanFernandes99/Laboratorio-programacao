package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SimpleResponse;
import com.example.demo.model.Empresa;
import com.example.demo.service.ServiceEmpresa;

//controlador trata exceçao e chama a funçao do service
@RestController
public class ControladorEmpresa {
	private final ServiceEmpresa serviceEmpresa;

	@Autowired
	public ControladorEmpresa(ServiceEmpresa aServiceEmpresa) {
		serviceEmpresa = aServiceEmpresa;
	}

	@PostMapping("/addEmpresa")
	public ResponseEntity<SimpleResponse> addEmpresa(@RequestBody Empresa aEmpresa) {

		return serviceEmpresa.addEmpresa(aEmpresa);
	}

	@GetMapping("/getEmpresas")
	public List<Empresa> getEmpresas() {
		return serviceEmpresa.getAllEmpresas();
	}

	@GetMapping("/getEmpresasById/{aId}")
	public Empresa getEmpresaById(@PathVariable int aId) {
		return serviceEmpresa.getEmpresaById(aId);
	}

	@DeleteMapping("/deleteEmpresa/{aId}")
	public ResponseEntity<SimpleResponse> deleteEmpresa(@PathVariable int aId) {
		return serviceEmpresa.deleteEmpresaById(aId);
	}

	@GetMapping("/EmpresaTesteParametros")
	public Empresa empresaTesteParametros() {
		return serviceEmpresa.testeParametros();
	}

}
