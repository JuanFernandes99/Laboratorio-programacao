package ficha8.ficha8_resolucao.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ficha8.ficha8_resolucao.model.Andar;
import ficha8.ficha8_resolucao.model.CentroComercial;
import ficha8.ficha8_resolucao.repository.AndarRepository;
import ficha8.ficha8_resolucao.repository.CentroComercialRepository;

@Service
public class AndarCentroComercialService {

	private final AndarRepository andarRepo;
	private final CentroComercialRepository centroComercialRepo;

	@Autowired
	public AndarCentroComercialService(AndarRepository aAndarRepo, CentroComercialRepository aCentroComercialRepo) {
		andarRepo = aAndarRepo;
		centroComercialRepo = aCentroComercialRepo;
	}

	public boolean addAndarToCentroComercial(Andar aAndar, CentroComercial aCentroComercial) {
		Optional<CentroComercial> centroComercialOptional = centroComercialRepo.findById(aCentroComercial.getId());

		// regular expression
		if (centroComercialOptional.isEmpty() || aAndar.getNumeroAndar() == 0 || aAndar.getNumeroMaxLojas() == 0) {
			return false;
		}
		CentroComercial centroComercialAux = centroComercialOptional.get();

		centroComercialAux.adicionarAndar(aAndar);
		aAndar.setCentroComercial(centroComercialAux);

		centroComercialRepo.save(centroComercialAux);
		andarRepo.save(aAndar);

		return true;
	}

	public String addAndarToCentroComercialByIds(String aAndarId, String aCentroComercialId) {
		Optional<CentroComercial> opcionalCentroComercial = centroComercialRepo
				.findById(Long.parseLong(aCentroComercialId));
		Optional<Andar> opcionalAndar = andarRepo.findById(Long.parseLong(aAndarId));

		if (opcionalCentroComercial.isPresent() && opcionalAndar.isPresent()) {

			CentroComercial centroComercialAux = opcionalCentroComercial.get();

			Andar andarAux = opcionalAndar.get();

			if (centroComercialAux.getNumeroMaxAndar() >= (centroComercialAux.getAndares().size() + 1)) {

				int andarContador = (centroComercialAux.getAndares().size());
				andarContador++;
				andarAux.setNumeroAndar(andarContador);

				centroComercialAux.adicionarAndar(andarAux);
				andarAux.setCentroComercial(centroComercialAux);

				centroComercialRepo.save(centroComercialAux); // save pq estamos a adicionar novos dados
				andarRepo.save(andarAux);

				return "Sucesso";
			} else {
				return "Número maximo de andares atingido";
			}

		}
		return "InSucesso";
	}

}
