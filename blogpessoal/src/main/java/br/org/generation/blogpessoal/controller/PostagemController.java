package br.org.generation.blogpessoal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.org.generation.blogpessoal.model.Postagem;
import br.org.generation.blogpessoal.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*") //libera origens externas,e o cabecario"*"da onde vier, em produção coloca o endereço do frontend
public class PostagemController {

	 @Autowired
	 private PostagemRepository postagemRepository; //cria uma depedencia
	 
	 @GetMapping
	 public ResponseEntity <List<Postagem>> getAll(){ //<>especificacao de tipo
		 //cria uma entidade de resposta 200 e etc,list é uma colection, getall pega tudo
		 return ResponseEntity.ok(postagemRepository.findAll());
		 
		 //seletc * from tb_postagens; findall trtas todos os metodos das minhas postagens
	 }
	 
}
