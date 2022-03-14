package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Empresa;

public class SimpleResponseEmpresas extends SimpleResponse {
	List<Empresa> empresas;

	public SimpleResponseEmpresas(List<Empresa> aEmpresas) {
		empresas = aEmpresas;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> aEmpresas) {
		empresas = aEmpresas;
	}

}
