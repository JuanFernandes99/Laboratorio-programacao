package ficha8.ficha8_resolucao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ficha8.ficha8_resolucao.model.Andar;
import ficha8.ficha8_resolucao.repository.AndarRepository;

@Service
public class AndarService {

	private final AndarRepository andarRepo;

	public AndarService(AndarRepository aAndarRepo) {

		andarRepo = aAndarRepo;
	}

	public boolean addAndar(Andar aAndar) {

		
		if (aAndar.getId() == null) {
			
			andarRepo.save(aAndar);

			return true;
		}
		return false;
	}

	public List<Andar> getAllAndares() {
		List<Andar> listaAndares = new ArrayList<>();

		andarRepo.findAll().forEach(listaAndares::add);
		return listaAndares;

	}
	


}
