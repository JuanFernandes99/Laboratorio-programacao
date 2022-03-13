package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Pessoa;

@Service
public class ServicePessoa {

	List<Pessoa> pessoas = new ArrayList<Pessoa>();

	public List<Pessoa> addPessoa(Pessoa aPessoa) {
		System.out.println(aPessoa);
		pessoas.add(aPessoa);
		return pessoas;

	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public String deletePessoa(String aId) {
		try {
			Long id_pessoa = Long.parseLong(aId);

			for (Pessoa pessoaAux : pessoas) {
				if (pessoaAux.getId() == id_pessoa) {
					pessoas.remove(pessoaAux);
					return "Sucesso";
				}
			}
			return "Id não existe";
		} catch (Exception e) {
			return "Id invalido";
		}
	}

	public String getPessoaByNome(String aNome) {

		try {

			for (Pessoa pessoa : pessoas) {

				if (pessoa.getNome().toUpperCase().equals(aNome.toUpperCase())) {
					return pessoa.getNome() + " ID: " + pessoa.getId();
				}
			}
			return "Nome errado";
		} catch (Exception e) {
			return "Nome invalido";
		}

	}

	public String getPessoaById(String aId) {
		try {
			Integer id_pessoa = Integer.parseInt(aId);

			for (Pessoa pessoa : pessoas) {

				if (pessoa.getId() == id_pessoa) {
					return pessoa.getNome() + " ID: " + pessoa.getId();
				}
			}
			return "Id errado";
		} catch (Exception e) {
			return "Id invalido";
		}

	}

	public Boolean updatePessoa(Pessoa aPessoa) {
		for (Pessoa pessoaAux : pessoas) {
			if (pessoaAux.getId() == aPessoa.getId()) {
				if (aPessoa.getIdade() > 0) {
					pessoaAux.setIdade(aPessoa.getIdade());
				}

				if (aPessoa.getNome() != null && aPessoa.getNome().isBlank()) {
					pessoaAux.setNome(aPessoa.getNome());
				}

				return true;
			}
		}

		return false;
	}

	public Pessoa testeParametros() {
		Pessoa p = new Pessoa("David", 7, 1);
		return p;
	}

}
