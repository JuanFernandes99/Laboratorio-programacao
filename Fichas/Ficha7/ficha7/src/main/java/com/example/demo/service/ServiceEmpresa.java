package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Empresa;

@Service
public class ServiceEmpresa {
	List<Empresa> empresas = new ArrayList<Empresa>();

	public List<Empresa> addEmpresa(Empresa aEmpresa) {
		System.out.println(aEmpresa);
		empresas.add(aEmpresa);
		return empresas;

	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public String deleteEmpresa(String aId) {
		try {
			Integer id_empresa = Integer.parseInt(aId);
			for (Empresa empresa : empresas) {

				if (empresa.getId() == id_empresa) {
					empresas.remove(empresa);
					return "Sucesso";
				}
			}
			return "Id errado";
		} catch (Exception e) {
			return "Id errado";
		}

	}

	public String getEmpresaByNome(String aNome) {

		try {

			for (Empresa empresa : empresas) {

				if (empresa.getNome().toUpperCase().equals(aNome.toUpperCase())) {
					return empresa.getNome() + " ID: " + empresa.getId();
				}
			}
			return "Nome errado";
		} catch (Exception e) {
			return "Nome errado";
		}

	}

	public String getEmpresaById(String aId) {
		try {
			Integer id_empresa = Integer.parseInt(aId);

			for (Empresa empresa : empresas) {

				if (empresa.getId() == id_empresa) {
					return empresa.getNome() + " ID: " + empresa.getId();
				}
			}
			return "Id errado";
		} catch (Exception e) {
			return "Id errado";
		}

	}

	public String updateEmpresa(Empresa aEmpresa) {

		for (Empresa empresa : empresas) {
			if (empresa.getId() == aEmpresa.getId()) {
				if (aEmpresa.getNome() != null && !aEmpresa.getNome().isBlank()) {
					empresa.setNome(aEmpresa.getNome());
				}

				if (aEmpresa.getMorada() != null && !aEmpresa.getMorada().isBlank()) {
					empresa.setMorada(aEmpresa.getMorada());
				}

				return "Sucesso";
			}
		}

		return "pessoa nao existe";

	}

	public Empresa testeParametros() {
		Empresa e = new Empresa("Juan Empresa", "Funchal", 7);
		return e;
	}

}
