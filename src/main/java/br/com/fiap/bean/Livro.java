package br.com.fiap.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.glassfish.jersey.process.internal.RequestScoped;

@Entity(name="livros")
@RequestScoped
public class Livro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_livros",unique=true, nullable=false)
	private int id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="autor")
	private String autor;
	
	@Column(name="ano")
	private int ano;
	
	@Column(name="isbn")
	private String isbn;
	
	
	public Livro() {
	}
	
	public Livro(int id, String autor, String titulo, int ano, String isbn) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.isbn = isbn;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
