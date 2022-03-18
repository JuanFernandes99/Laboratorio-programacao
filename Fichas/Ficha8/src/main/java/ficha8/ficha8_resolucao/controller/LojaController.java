package ficha8.ficha8_resolucao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ficha8.ficha8_resolucao.dto.SimpleResponse;
import ficha8.ficha8_resolucao.dto.SimpleResponseLoja;
import ficha8.ficha8_resolucao.model.Loja;
import ficha8.ficha8_resolucao.service.LojaAndarService;
import ficha8.ficha8_resolucao.service.LojaService;


@RestController
public class LojaController {

	private final LojaService lojaService;
	private final LojaAndarService lojaAndarService;

	@Autowired
	public LojaController(LojaService aLojaService, LojaAndarService aLojaAndarService) {

		lojaService = aLojaService;
		lojaAndarService = aLojaAndarService;
	}

	@PostMapping(path = "/addLoja")
	public ResponseEntity<SimpleResponse> addLoja(@RequestBody Loja aLoja) {
		SimpleResponseLoja sr = new SimpleResponseLoja();

		if (aLoja.getNome() == null || aLoja.getNome().isBlank()) {
			sr.setMessage("Nome Invalido");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

		if (aLoja.getArea() == 0) {
			sr.setMessage("Area Invalida");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

		if (aLoja.getNumeroFuncionarios() == 0) {
			sr.setMessage("numFuncionarios invalido ");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

		if (lojaService.addLoja(aLoja)) {
			sr.setAsSuccess("Loja Inserido Com Sucesso");
			sr.setLojas(lojaService.getAllLojas());
			return ResponseEntity.status(HttpStatus.OK).body(sr);

		} else {
			sr.setAsError("Erro ao inserir a Loja");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

	}
	
	@PostMapping("/addLoja/{aLoja_id}/andar/{aAndar_id}")
	public String addAndarToCentroComercialByIds(@PathVariable String aAndar_id,
			@PathVariable String aLoja_id) {
		return lojaAndarService.addLojaToAndarByIds(aAndar_id, aLoja_id);
	}
	
	@DeleteMapping("/removeLoja/{aId}")
	public SimpleResponse removeLojaById(@PathVariable String aId) {
		SimpleResponse sr = new SimpleResponse();

		if (lojaService.deleteLojaById(aId)) {
			sr.setAsSuccess("Loja Removida Com Sucesso");
		} else {
			sr.setAsError("Erro ao Remover a loja");
		}

		return sr;
	}
	
	@GetMapping("/getAllLoja")
	public List<Loja> getAllLoja() {
		return lojaService.getAllLojas();
	}

	@GetMapping("/getLojaById/{aId}")

	public Loja getLojaById(@PathVariable String aId) {
		return lojaService.getLojaById(aId).get();
	}
	
	@PutMapping("/updateLoja")
	public SimpleResponse updateLoja(@RequestBody Loja aLoja) {
		SimpleResponse sr = new SimpleResponse();

		if (aLoja.getId() == null) {
			sr.setAsError("Id invalido");
			return sr;
		}

		if (aLoja.getNome() == null || aLoja.getNome().isBlank()) {
			sr.setAsError("Nome Invalido");
			return sr;
		}
		if (aLoja.getNumeroFuncionarios() != 0) {
			sr.setMessage("numFuncionarios invalido");
			return sr;
		}
		
		if (aLoja.getArea() != 0) {
			sr.setMessage("Area invalida");
			return sr;
		}

		boolean suc = lojaService.updateLoja(aLoja);

		if (suc) {
			sr.setAsSuccess("Loja atualizada com sucesso");
		} else {
			sr.setAsError("Erro na atualização da Loja " + aLoja.getId());
		}
		return sr;

	}
	

}
