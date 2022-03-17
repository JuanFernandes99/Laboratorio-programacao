package ficha8.ficha8_resolucao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ficha8.ficha8_resolucao.dto.SimpleResponse;
import ficha8.ficha8_resolucao.dto.SimpleResponseAndar;
import ficha8.ficha8_resolucao.model.Andar;
import ficha8.ficha8_resolucao.model.CentroComercial;
import ficha8.ficha8_resolucao.service.AndarCentroComercialService;
import ficha8.ficha8_resolucao.service.AndarService;
import ficha8.ficha8_resolucao.utils.WrapperAndarCentroComercial;

@RestController
public class AndarController {

	private final AndarService andarService;

	private final AndarCentroComercialService andarCentroComercialService;

	public AndarController(AndarService aAndarService, AndarCentroComercialService aAndarCentroComercialService) {
		andarService = aAndarService;
		andarCentroComercialService = aAndarCentroComercialService;
	}

	@PostMapping(path = "/addAndar")
	public ResponseEntity<SimpleResponse> addAndar(@RequestBody Andar aAndar) {
		SimpleResponseAndar sr = new SimpleResponseAndar();

		if (aAndar.getNumeroAndar() == 0) {
			sr.setMessage("Numero de Andar Invalido");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

		if (aAndar.getNumeroMaxLojas() == 0) {
			sr.setMessage("numero maximo de lojas invalido");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

		if (andarService.addAndar(aAndar)) {
			sr.setAsSuccess("Andar Inserido Com Sucesso");
			sr.setAndares(andarService.getAllAndares());
			return ResponseEntity.status(HttpStatus.OK).body(sr);

		} else {
			sr.setAsError("Erro ao inserir o Andar");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

	}
	@GetMapping("/getAllAndares")
	public List<Andar> getAllAndares() {
		return andarService.getAllAndares();
	}
	@PostMapping(path = "/addAndarToCentroComercial")
	public ResponseEntity<SimpleResponse> addAndarToCentroComercial(@RequestBody WrapperAndarCentroComercial aWrapper) {
		SimpleResponse sr = new SimpleResponse();
		if (andarCentroComercialService.addAndarToCentroComercial(aWrapper.getAndar(), aWrapper.getCentroComercial())) {
			sr.setAsSuccess("Andar adicionado ao centroComercial");
			return ResponseEntity.status(HttpStatus.OK).body(sr);
		}
		return null;
	}

	@PostMapping("/addAndar/{aAndar_id}/centroComercial/{aCentro_comercial_id}")
	public String addAndarToCentroComercialByIds(@PathVariable String aAndar_id,
			@PathVariable String aCentro_comercial_id) {
		return andarCentroComercialService.addAndarToCentroComercialByIds(aAndar_id, aCentro_comercial_id);
	}
}
