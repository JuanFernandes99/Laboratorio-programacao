package Ficha8.Ficha8_resolucao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Ficha8.Ficha8_resolucao.model.CentroComercial;

@Repository
public interface CentroComercialRepository extends CrudRepository<CentroComercial, Long> {

}