package minhaprimeiraaplicacao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aplicacão1")
public class MinhaprimeiraAplicacao {

	
	@GetMapping
	public String aplicacaoshow() {
		return "Minhas habilidades e mentalidades para realizar esta atividade para essa semana "
				+ "<br/> Persistencia"
				+ "<br/> Trabalho em Equipe"
				+ "<br/> Comunicação";
 }
}

