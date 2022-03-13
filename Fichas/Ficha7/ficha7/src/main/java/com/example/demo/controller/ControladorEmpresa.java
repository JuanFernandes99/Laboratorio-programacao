package com.example.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Pessoa> addPessoa(@RequestBody Pessoa aPessoa) {

		if (aPessoa.getIdade() < 0 || aPessoa.getNome() == null || aPessoa.getNome().isBlank()) {

			return Collections.emptyList();
		}
		Empresa empresa = serviceEmpresa.getEmpresaById(aPessoa.getEmpresaId());
		empresa.adicionarPessoa(aPessoa);

		return servicePessoa.addPessoa(aPessoa);
	}

	@PutMapping("/updatePessoa")
	public String updatePessoa(@RequestBody Pessoa aPessoa) {
		if (servicePessoa.updatePessoa(aPessoa)) {
			return "Pessoa updated com sucesso";
		}
		return "Erro a atualizar a pessoa";
	}

	@GetMapping("/getPessoas")
	public List<Pessoa> getPessoas() {
		return servicePessoa.getPessoas();
	}

	@DeleteMapping("/deletePessoa/{id}")
	public String deletePessoa(@PathVariable String aId) {
		return servicePessoa.deletePessoa(aId);
	}

	@GetMapping("/getPessoasByNome/{nome}")
	public String getPessoaByNome(@PathVariable String aNome) {
		return servicePessoa.getPessoaByNome(aNome);
	}

	@GetMapping("/getPessoasById/{id}")
	public String getPessoaById(@PathVariable String aId) {
		return servicePessoa.getPessoaById(aId);
	}
	
	@PostMapping("/addEmpresa")
	public List<Empresa> addEmpresa(@RequestBody Empresa aEmpresa) {

		if (aEmpresa.getNome() == null || aEmpresa.getNome().isBlank()) {

			return Collections.emptyList();
		}
	return serviceEmpresa.addEmpresa(aEmpresa);
	}



	@GetMapping("/getEmpresas")
	public List<Empresa> getEmpresas() {
		return serviceEmpresa.getEmpresas();
	}


	@GetMapping("/getEmpresasById/{id}")
	public Empresa getEmpresaById(@PathVariable int aId) {
		return serviceEmpresa.getEmpresaById(aId);
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
