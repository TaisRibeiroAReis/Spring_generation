package br.org.generation.blogpessoal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogpessoal.model.Postagem;
import br.org.generation.blogpessoal.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*") //libera origens externas,e o cabecario"*"da onde vier, em produção coloca o endereço do frontend
public class PostagemController {

	 @Autowired //cria uma depedencia
	 private PostagemRepository postagemRepository; 
	 
	 @GetMapping
	 public ResponseEntity <List<Postagem>> getAll(){ //<>especificacao de tipo
		 //cria uma entidade de resposta 200 e etc,list é uma colection, getall pega tudo
		 return ResponseEntity.ok(postagemRepository.findAll());
		
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity <Postagem> getById(@PathVariable Long id){
		 return postagemRepository.findById(id)
				 .map(resp -> ResponseEntity.ok(resp))//map é um opcional,resposta do metodo map mostra oque ele acho
				 .orElse(ResponseEntity.notFound().build());//ele não achou entao deu a resposta, colocar o build pra dar o erro 404
		 
	 }
	 
	 @GetMapping("/titulo/{titulo}")
	 public ResponseEntity <List<Postagem>> getByTitulo(@PathVariable String titulo){ 
		 return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
		//select * from tb_postagens where titulo like "%titulo%";
		 
		 
	 }
	 
	 @PostMapping
	 public ResponseEntity <Postagem> postPostagem(@Valid @RequestBody Postagem postagem){//pega o objeto postagem que esta no corpo 
		 
		 return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
		 //status(httpStatus.created
	 }
	 /*
	 @PutMapping
	 public ResponseEntity <Postagem> putPostagem(@Valid @RequestBody Postagem postagem){
		 
		 return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
	 }
	 
	 @DeleteMapping("/{id}")
	 public void deletePostagem(@PathVariable Long id) {
		 
		 postagemRepository.deleteById(id);
	 }
	*/
	 //desafio
	 
	 @PutMapping
	 public ResponseEntity <Postagem> putPostagem(@Valid @RequestBody Postagem postagem){
		 return postagemRepository.findById(postagem.getId())
				 .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem)))
				 .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	 }
		 
	 @DeleteMapping(path ={"/{id}"})
			public ResponseEntity<?> delete(@PathVariable long id) {
			   return postagemRepository.findById(id)
			           .map(record -> {
			               postagemRepository.deleteById(id);
			               return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			               })
			           .orElse(ResponseEntity.notFound().build());
	 }
}