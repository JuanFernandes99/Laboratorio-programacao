package com.example.demoAula.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demoAula.model.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

}
