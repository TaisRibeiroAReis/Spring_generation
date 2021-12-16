package br.org.generation.blogpessoal.repository;

import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.org.generation.blogpessoal.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	//JpaRepository<T, T> Generic Type . o t pode ser qualquer objeto

	public List <Postagem> findAllByTituloContainingIgnoreCase(String Titulo);
	//select * from tb_postagens where titulo like "%titulo%";
	//findAllByTituloContainingIgnoreCase - procura o titulo mesmo que esteja com letra maiuscula ou minuscula
	//metodo personalizado
}

