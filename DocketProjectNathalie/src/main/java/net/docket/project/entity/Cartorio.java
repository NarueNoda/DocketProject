package net.docket.project.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cartorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartorio_id;
	private String nome;
	private String endereco;
	
	
	public Cartorio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cartorio(String nome, String endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public Long getId() {
		return cartorio_id;
	}
	public void setId(Long id) {
		this.cartorio_id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	

}
