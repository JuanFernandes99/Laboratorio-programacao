package ficha8.ficha8_resolucao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ficha8.ficha8_resolucao.dto.SimpleResponse;
import ficha8.ficha8_resolucao.dto.SimpleResponseCentroComercial;
import ficha8.ficha8_resolucao.model.CentroComercial;
import ficha8.ficha8_resolucao.service.CentroComercialService;

@RestController
public class CentroComercialController {

	private final CentroComercialService centroComercialService;

	@Autowired
	public CentroComercialController(CentroComercialService aCentroComercialService) {

		centroComercialService = aCentroComercialService;
	}

	@PostMapping(path = "/addCentroComercial")
	public ResponseEntity<SimpleResponse> addCentroComercial(@RequestBody CentroComercial aCentroComercial) {
		SimpleResponseCentroComercial sr = new SimpleResponseCentroComercial();

		if (aCentroComercial.getNome() == null || aCentroComercial.getNome().isBlank()) {
			sr.setMessage("Nome Invalido");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

		if (aCentroComercial.getMorada() == null || aCentroComercial.getMorada().isBlank()) {
			sr.setMessage("Morada Invalida");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

		if (aCentroComercial.getNumeroMaxAndar() == 0) {
			sr.setMessage("Andar Invalido/Deve indicar a quantidade maxima de andares ");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

		if (centroComercialService.addCentroComercial(aCentroComercial)) {
			sr.setAsSuccess("Centro Comercial Inserido Com Sucesso");
			sr.setCentroComerciales(centroComercialService.getAllCentroComercial());
			return ResponseEntity.status(HttpStatus.OK).body(sr);

		} else {
			sr.setAsError("Erro ao inserir o Centro Comercial");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sr);
		}

	}

	@DeleteMapping("/removeCentroComercial/{aId}")
	public SimpleResponse removeCentroComercialById(@PathVariable String aId) {
		SimpleResponse sr = new SimpleResponse();

		if (centroComercialService.deleteCentroComercialById(aId)) {
			sr.setAsSuccess("Centro Comercial Removido Com Sucesso");
		} else {
			sr.setAsError("Erro ao Remover o centro Comercial");
		}

		return sr;
	}

	@GetMapping("/getAllCentroComercial")
	public List<CentroComercial> getAllCentroComercial() {
		return centroComercialService.getAllCentroComercial();
	}

	@GetMapping("/getCentroComercialById/{aId}")

	public CentroComercial getCentroComercialById(@PathVariable String aId) {
		return centroComercialService.getCentroComercial(aId).get();
	}

}
