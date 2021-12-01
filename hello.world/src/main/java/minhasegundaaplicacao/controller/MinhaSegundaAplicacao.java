package minhasegundaaplicacao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aplicacão2")
public class MinhaSegundaAplicacao {

	@GetMapping
	public String aplicacaoshow() {
		return "Minhas metas para essa semana <br/> Aprender Spring";
			
		
	}
}
