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
import com.example.demo.model.Empresa;
import com.example.demo.service.PessoaEmpresaSalarioService;

@RestController
public class EmpresaController {
	private final PessoaEmpresaSalarioService pessoaEmpresaSalarioService;

	@Autowired
	public EmpresaController(PessoaEmpresaSalarioService pessoaEmpresaSalarioService) {
		this.pessoaEmpresaSalarioService = pessoaEmpresaSalarioService;
	}

	@CrossOrigin
	@GetMapping("/getAllEmpresas")
	public List<Empresa> getAllEmpresas() {
		return pessoaEmpresaSalarioService.getListaEmpresas();
	}

	@CrossOrigin
	@PostMapping("/addEmpresa")
	public ResponseEntity<SimpleResponse> addEmpresa(@RequestBody Empresa aEmpresa) {
		SimpleResponse sr = new SimpleResponse();
		if (aEmpresa.getNome() == null || aEmpresa.getNome().isBlank()) {
			sr.setMessage("Nome inválido");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}
		if (aEmpresa.getMorada() == null || aEmpresa.getMorada().isBlank()) {
			sr.setMessage("Morada inválida");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

		if (aEmpresa.getImagem() == null || aEmpresa.getImagem().isBlank()) {
			sr.setMessage("Imagem inválida");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}
		if (pessoaEmpresaSalarioService.addEmpresa(aEmpresa)) {
			sr.setSucess("Sucesso ao inserir a empresa");
			return ResponseEntity.status(HttpStatus.OK).body(sr);
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
	}

	@CrossOrigin
	@DeleteMapping("/deleteEmpresa/{aEmpresa_id}")
	public ResponseEntity<SimpleResponse> deleteEmpresa(@PathVariable String aEmpresa_id) {
		SimpleResponse sr = new SimpleResponse();

		if (pessoaEmpresaSalarioService.deleteEmpresa(aEmpresa_id)) {
			sr.setSucess("Sucesso ao remover a empresa");
			return ResponseEntity.status(HttpStatus.OK).body(sr);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sr);
	}

}
