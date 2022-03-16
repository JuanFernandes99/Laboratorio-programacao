package ficha8.ficha8_resolucao.service;

import ficha8.ficha8_resolucao.model.CentroComercial;
import ficha8.ficha8_resolucao.repository.AndarRepository;
import ficha8.ficha8_resolucao.repository.CentroComercialRepository;

public class CentroComercialService {
	
	private final CentroComercialRepository centroComercialRepo;
	private final AndarRepository andarRepo;

	public CentroComercialService(CentroComercialRepository aCentroComercialRepo, AndarRepository aAndarRepo) {
		centroComercialRepo = aCentroComercialRepo;
		andarRepo = aAndarRepo;
	}

	public boolean addCentroComercial(CentroComercial aCentroComercial) {
		if (aCentroComercial.getId() != null || aCentroComercial.getMorada() != null
				|| !aCentroComercial.getMorada().isBlank() || aCentroComercial.getNome() != null
				|| !aCentroComercial.getNome().isBlank() || aCentroComercial.getNumeroMaxAndar() == 0
				|| !aCentroComercial.getAndares().isEmpty()) {
			return false;
		}
		centroComercialRepo.save(aCentroComercial);
		return true;

	}
}
