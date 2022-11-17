package br.com.bibliotecamagica.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private String autor;
	
	@Column(nullable = false)
	private StringBuffer resumo;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genero", nullable = false)
    private Genero Genero;
	
	public Livro() {
		
	}

	public Livro(long id, String titulo, String autor, StringBuffer resumo,
			Genero genero) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.resumo = resumo;
		Genero = genero;
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

	public StringBuffer getResumo() {
		return resumo;
	}

	public void setResumo(StringBuffer resumo) {
		this.resumo = resumo;
	}



	public Genero getGenero() {
		return Genero;
	}

	public void setGenero(Genero genero) {
		Genero = genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Objects.hash(Genero, autor, id, resumo, titulo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(Genero, other.Genero) && Objects.equals(autor, other.autor)
				&& id == other.id && Objects.equals(resumo, other.resumo)
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", resumo=" + resumo + ", Genero=" + Genero + "]";
	}

		
}