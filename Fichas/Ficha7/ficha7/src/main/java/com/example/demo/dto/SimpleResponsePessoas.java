package com.example.demo.dto;


import java.util.List;

import com.example.demo.model.Pessoa;

public class SimpleResponsePessoas extends SimpleResponse {

	List<Pessoa> pessoas;

	public SimpleResponsePessoas(List<Pessoa> aPessoas) {
		pessoas = aPessoas;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> aPessoas) {
		pessoas = aPessoas;
	}

}
