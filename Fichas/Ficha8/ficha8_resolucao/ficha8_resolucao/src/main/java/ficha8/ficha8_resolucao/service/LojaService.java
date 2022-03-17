package ficha8.ficha8_resolucao.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ficha8.ficha8_resolucao.model.Loja;
import ficha8.ficha8_resolucao.repository.LojaRepository;

@Service

public class LojaService {

	private final LojaRepository lojaRepo;

	public LojaService(LojaRepository aLojaRepo) {

		lojaRepo = aLojaRepo;
	}

	public boolean addLoja(Loja aLoja) {
//		importa a ordem, normalmente o null vem primeiro que o isBlank

		if (aLoja.getId() == null) {

			lojaRepo.save(aLoja);

			return true;
		}
		return false;
	}

	public boolean deleteLojaById(String aId) {

		try { // pq da excepçao se meto uma letrea
			Long id_long = parseLong(aId);
			Optional<Loja> lojaOpcional = lojaRepo.findById(id_long);

			if (aId == null || id_long == NaN || lojaOpcional.isEmpty()) {
				return false;
			}

			Loja loja = lojaOpcional.get();
			lojaRepo.delete(loja);

			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public List<Loja> getAllLojas() {
		List<Loja> listaLojas = new ArrayList<>();

		lojaRepo.findAll().forEach(listaLojas::add);
		return listaLojas;

	}

	public boolean updateLoja(Loja aLoja) {
		if (aLoja.getId() == null || lojaRepo.findById(aLoja.getId()).isEmpty()) {
			return false;
		}

		Loja loja = lojaRepo.findById(aLoja.getId()).get();

		if (loja.getNome() != null || !loja.getNome().isBlank()) {
			loja.setNome(aLoja.getNome());
		}

		if (loja.getNumeroFuncionarios() != 0) {
			loja.setNumeroFuncionarios(aLoja.getNumeroFuncionarios());
		}

		if (loja.getArea() != 0) {
			loja.setArea(aLoja.getArea());
		}

		lojaRepo.save(loja);

		return true;
	}

	public Optional<Loja> getLojaById(String aId) { // Perguntar professor pq o try catch
		try {
			Long id_long = parseLong(aId);
			Optional<Loja> lojaOpcional = lojaRepo.findById(id_long);
			if (aId == null || id_long == NaN || lojaOpcional.isEmpty()) {
				return null;
			}
			return lojaOpcional;
		} catch (Exception e) {
			return null;
		}

	}

}
