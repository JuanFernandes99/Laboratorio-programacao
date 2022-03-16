package Ficha8.Ficha8_resolucao.service;

import Ficha8.Ficha8_resolucao.model.CentroComercial;
import Ficha8.Ficha8_resolucao.repository.AndarRepository;
import Ficha8.Ficha8_resolucao.repository.CentroComercialRepository;

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
