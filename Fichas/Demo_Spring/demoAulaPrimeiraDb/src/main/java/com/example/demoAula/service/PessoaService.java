package com.example.demoAula.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoAula.model.Pessoa;
import com.example.demoAula.repository.PessoaRepository;

@Service
public class PessoaService {
	private final PessoaRepository pessoaRepo;

	@Autowired
	public PessoaService(PessoaRepository aPessoaRepo) {
		pessoaRepo = aPessoaRepo;

	}

	public boolean addPessoa(Pessoa pessoa) {
		if (pessoa.getId() == null) {
			pessoaRepo.save(pessoa);
			return true;
		}
		return false;
	}

	public boolean removePessoa(Pessoa aPessoa) {
		if (aPessoa.getId() == null || pessoaRepo.findById(aPessoa.getId()).isEmpty()) {
			return false;
		}

		Pessoa p = pessoaRepo.findById(aPessoa.getId()).get();
		pessoaRepo.delete(p);

		return true;
	}

	public boolean removePessoa2(String aId) {
		try {
			Long id_long = parseLong(aId);

			if (aId == null || id_long == NaN || pessoaRepo.findById(id_long).isEmpty()) {
				return false;
			}

			Pessoa pessoa = pessoaRepo.findById(id_long).get();
			pessoaRepo.delete(pessoa);

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean updatePessoa(Pessoa aPessoa) {
		if (aPessoa.getId() == null || pessoaRepo.findById(aPessoa.getId()).isEmpty()) // se é true é pq existe
		{
			return false;
		}

		Pessoa pessoa = pessoaRepo.findById(aPessoa.getId()).get();

		if (pessoa.getNome() != null || !pessoa.getNome().isBlank()) {
			pessoa.setNome(aPessoa.getNome());
		}

		if (pessoa.getEmail() != null || !pessoa.getEmail().isBlank()) {
			pessoa.setEmail(aPessoa.getEmail());
		}

		if (aPessoa.getIdade() > 0) {
			pessoa.setIdade(aPessoa.getIdade());
		}

		pessoaRepo.save(pessoa);

		return true;
	}

	public List<Pessoa> getPessoas() {
		List<Pessoa> listaPessoas = new ArrayList<>();

		pessoaRepo.findAll().forEach(listaPessoas::add);

		return listaPessoas;
	}

	public Optional<Pessoa> getPessoa(Long id) {
		return pessoaRepo.findById(id);
	}

}
