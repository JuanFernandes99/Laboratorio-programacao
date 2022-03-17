package ficha8.ficha8_resolucao.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ficha8.ficha8_resolucao.model.Andar;
import ficha8.ficha8_resolucao.model.Loja;
import ficha8.ficha8_resolucao.repository.AndarRepository;
import ficha8.ficha8_resolucao.repository.LojaRepository;

@Service
public class LojaAndarService {
	private final AndarRepository andarRepo;
	private final LojaRepository lojaRepo;

	@Autowired
	public LojaAndarService(AndarRepository aAndarRepo, LojaRepository aLojaRepo) {

		andarRepo = aAndarRepo;
		lojaRepo = aLojaRepo;
	}

	public String addLojaToAndarByIds(String aAndar_Id, String aLoja_Id) {
		Optional<Loja> opcionalLoja = lojaRepo.findById(Long.parseLong(aLoja_Id));
		Optional<Andar> opcionalAndar = andarRepo.findById(Long.parseLong(aAndar_Id));

		if (opcionalLoja.isPresent() && opcionalAndar.isPresent()) {

			Loja lojaAux = opcionalLoja.get();

			Andar andarAux = opcionalAndar.get();

			if (andarAux.getNumeroMaxLojas() >= (andarAux.getLojas().size() + 1)) {

				int lojaContador = (andarAux.getLojas().size());
				lojaContador++;
				andarAux.setNumeroAndar(lojaContador);

				andarAux.adicionarLoja(lojaAux);
				lojaAux.setAndares(andarAux);

				andarRepo.save(andarAux); // save pq estamos a adicionar novos dados
				lojaRepo.save(lojaAux);

				return "Sucesso";

			} else {
				return "Número maximo de lojas atingido";
			}

		}
		return "InSucesso";
	}

	public boolean deleteAndarById(String aId) {

		try { // pq da excepçao se meto uma letrea
			Long id_long = parseLong(aId);
			Optional<Andar> andarOpcional = andarRepo.findById(id_long);

			if (aId == null || id_long == NaN || andarOpcional.isEmpty()) {
				return false;
			}

			if (andarOpcional.isPresent()) {
				for (Loja lojas : andarOpcional.get().getLojas()) {
					// lojas.setAndares(null);
					// lojaRepo.save(lojas);
					lojaRepo.delete(lojas);
				}
			}

			Andar andar = andarOpcional.get();
			andarRepo.delete(andar);

			return true;

		} catch (Exception e) {
			return false;
		}

	}
}
