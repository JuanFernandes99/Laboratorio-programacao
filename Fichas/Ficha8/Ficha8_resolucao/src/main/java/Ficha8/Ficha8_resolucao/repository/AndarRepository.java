package Ficha8.Ficha8_resolucao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Ficha8.Ficha8_resolucao.model.Andar;

@Repository
public interface AndarRepository extends CrudRepository<Andar, Long> {

}
