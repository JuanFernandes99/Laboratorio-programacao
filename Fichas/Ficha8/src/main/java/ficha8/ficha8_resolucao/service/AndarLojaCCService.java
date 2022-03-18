package ficha8.ficha8_resolucao.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ficha8.ficha8_resolucao.model.Andar;
import ficha8.ficha8_resolucao.model.CentroComercial;
import ficha8.ficha8_resolucao.model.Loja;
import ficha8.ficha8_resolucao.repository.AndarRepository;
import ficha8.ficha8_resolucao.repository.CentroComercialRepository;
import ficha8.ficha8_resolucao.repository.LojaRepository;

@RestController
public class AndarLojaCCService {

	private final AndarRepository andarRepo;
	private final CentroComercialRepository centroComercialRepo;
	private final LojaRepository lojaRepo;

	@Autowired
	public AndarLojaCCService(AndarRepository aAndarRepo, CentroComercialRepository aCentroComercialRepo,
			LojaRepository aLojaRepo) {
		andarRepo = aAndarRepo;
		centroComercialRepo = aCentroComercialRepo;
		lojaRepo = aLojaRepo;
	}

	public boolean deleteCentroComercialById(String aId) {

		try { // pq da excepçao se meto uma letrea
			Long id_long = parseLong(aId);
			Optional<CentroComercial> centroComercialOpcional = centroComercialRepo.findById(id_long);
			if (aId == null || id_long == NaN || centroComercialOpcional.isEmpty()) {
				return false;
			}

			if (centroComercialOpcional.isPresent()) {
				for (Andar andares : centroComercialOpcional.get().getAndares()) {
					for (Loja lojas : andares.getLojas()) {

						lojaRepo.delete(lojas);
					}

					andarRepo.delete(andares);
				}
			}
			CentroComercial centroComercial = centroComercialOpcional.get();
			centroComercialRepo.delete(centroComercial);

			return true;

		} catch (Exception e) {
			return false;
		}

	}
}
