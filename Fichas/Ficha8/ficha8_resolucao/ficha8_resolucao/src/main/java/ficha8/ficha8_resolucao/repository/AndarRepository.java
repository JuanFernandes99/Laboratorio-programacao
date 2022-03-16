package ficha8.ficha8_resolucao.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ficha8.ficha8_resolucao.model.Andar;

@Repository
public interface AndarRepository extends CrudRepository<Andar, Long> {

}