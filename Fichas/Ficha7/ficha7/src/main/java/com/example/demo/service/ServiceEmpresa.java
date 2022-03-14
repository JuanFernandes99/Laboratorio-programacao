package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SimpleResponse;
import com.example.demo.dto.SimpleResponseEmpresas;
import com.example.demo.model.Empresa;

@Service
public class ServiceEmpresa {

	List<Empresa> empresas = new ArrayList<Empresa>();
	SimpleResponse sr = new SimpleResponse();
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
					sre.setAsSucess("Empresa eliminada com sucesso");
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

	public Empresa getEmpresaById(int aId) { //melhorar
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

}
