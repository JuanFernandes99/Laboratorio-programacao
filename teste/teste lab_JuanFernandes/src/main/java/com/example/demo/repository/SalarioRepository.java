package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Salario;

public interface SalarioRepository extends CrudRepository<Salario, Long> {

}
