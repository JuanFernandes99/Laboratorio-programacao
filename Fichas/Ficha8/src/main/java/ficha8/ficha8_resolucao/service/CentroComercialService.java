package ficha8.ficha8_resolucao.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import ficha8.ficha8_resolucao.model.CentroComercial;
import ficha8.ficha8_resolucao.repository.CentroComercialRepository;

@Service
public class CentroComercialService {

	private final CentroComercialRepository centroComercialRepo;

	public CentroComercialService(CentroComercialRepository aCentroComercialRepo) {
		centroComercialRepo = aCentroComercialRepo;

	}

	public boolean addCentroComercial(CentroComercial aCentroComercial) {
//		importa a ordem, normalmente o null vem primeiro que o isBlank

		if (aCentroComercial.getId() == null || aCentroComercial.getAndares().isEmpty()
				|| aCentroComercial.getNumeroMaxAndar() != 0) {

			centroComercialRepo.save(aCentroComercial);

			return true;
		}
		return false;
	}


	public List<CentroComercial> getAllCentroComercial() {
		List<CentroComercial> listaCentros = new ArrayList<>();

		centroComercialRepo.findAll().forEach(listaCentros::add);
		return listaCentros;

	}

	public Optional<CentroComercial> getCentroComercial(String aId) { //Perguntar professor pq o try catch
		try {
			Long id_long = parseLong(aId);
			Optional<CentroComercial> centroComercialOpcional = centroComercialRepo.findById(id_long);
			if (aId == null || id_long == NaN || centroComercialOpcional.isEmpty()) {
				return null;
			}
			return centroComercialOpcional;
		} catch (Exception e) {
			return null;
		}

	}

}
