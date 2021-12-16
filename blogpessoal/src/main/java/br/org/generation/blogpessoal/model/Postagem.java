package br.org.generation.blogpessoal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //create table
@Table(name = "tb_postagens") 
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
	private Long id;//é uma classe que atribui uma serie de metodos a esse objeto
	
	@NotNull(message = "O atributo titulo é obrigatorio!") 
	@Size(min= 5, max=100,message = "O atributo titulo deve ter no minimo 5 e no maximo 100")
	private String titulo;
	
	@NotNull(message = "O atributo texto é obrigatorio!")
	@Size(min= 5, max=1000,message = "O atributo texto deve ter no minimo 5 e no maximo 1000")
	private String texto;
	
	@UpdateTimestamp
	private LocalDate data; 

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;	
	
	public Long getId() { //long tras metodos
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}
