package com.example.demoAula.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoAula.model.Empresa;
import com.example.demoAula.repository.EmpresaRepository;

@Service
public class EmpresaService {
	private final EmpresaRepository empresaRepo;

	@Autowired
	public EmpresaService(EmpresaRepository aEmpresaRepo) {
		empresaRepo = aEmpresaRepo;
	}

	public boolean addEmpresa(Empresa aEmpresa) {
		if (aEmpresa.getId() == null || aEmpresa.getNumFuncionariosAtual() == 0
				|| aEmpresa.getNumFuncionariosDesdeCriacao() == 0) {
			empresaRepo.save(aEmpresa);
			return true;
		}
		return false;
	}

	public boolean removeEmpresa(Empresa aEmpresa) {
		if (aEmpresa.getId() == null || empresaRepo.findById(aEmpresa.getId()).isEmpty()) {
			return false;
		}
		aEmpresa.setPessoas(null);
		Empresa empresa = empresaRepo.findById(aEmpresa.getId()).get(); // o get é para devolver a empresa
		empresaRepo.delete(empresa);

		return true;
	}


	

	public boolean updateEmpresa(Empresa aEmpresa) {
		if (aEmpresa.getId() == null || empresaRepo.findById(aEmpresa.getId()).isEmpty()) {
			return false;
		}

		Empresa e = empresaRepo.findById(aEmpresa.getId()).get();

		if (e.getNome() != null || !e.getNome().isBlank()) {
			e.setNome(aEmpresa.getNome());
		}

		if (e.getMorada() != null || !e.getMorada().isBlank()) {
			e.setMorada(aEmpresa.getMorada());
		}

		empresaRepo.save(e);

		return true;
	}

	public List<Empresa> getEmpresas() {
		List<Empresa> listaEmpresas = new ArrayList<>();

		empresaRepo.findAll().forEach(listaEmpresas::add);

		return listaEmpresas;
	}

	public Optional<Empresa> getEmpresaById(Long aId) {
		return empresaRepo.findById(aId);
	}

}
