package br.com.bibliotecamagica.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String atributo;
	
	public Genero() {
		
	}

	public Genero(long id, String nome, String atributo) {
		super();
		this.id = id;
		this.nome = nome;
		this.atributo = atributo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getAtributo() {
		return nome;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(atributo, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genero other = (Genero) obj;
		return Objects.equals(atributo, other.atributo) && id == other.id && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Genero [id=" + id + ", nome=" + nome + ", atributo=" + atributo + "]";
	}

	
}

