package net.docket.project.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Certidao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long certidao_id;
	private String nome;
	
	@ManyToOne(targetEntity = Cartorio.class)
	private Cartorio cartorio;
	
	public Certidao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Certidao(String nome, Long certidao_id) {
		super();
		this.certidao_id = certidao_id;
		this.nome = nome;
	}
	
	public Long getId() {
		return certidao_id;
	}
	public void setId(Long id) {
		this.certidao_id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cartorio getCartorio() {
		return cartorio;
	}

	public void setCartorio(Cartorio cartorio) {
		this.cartorio = cartorio;
	}

	
}
