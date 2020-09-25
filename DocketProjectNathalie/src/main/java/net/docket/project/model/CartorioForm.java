package net.docket.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import net.docket.project.entity.Cartorio;
import net.docket.project.entity.Certidao;

//model to class to hold cartorio form data
public class CartorioForm {

	@NotBlank
	private String nome;
	private String endereco;
	private String casamento;
	private String nascimento;
	private String obito;

	
	
	public CartorioForm(@NotBlank String nome, String endereco, String casamento, String nascimento, String obito) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.casamento = casamento;
		this.nascimento = nascimento;
		this.obito = obito;
	}

	public CartorioForm() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public String getCasamento() {
		return casamento;
	}

	public void setCasamento(String casamento) {
		this.casamento = casamento;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getObito() {
		return obito;
	}

	public void setObito(String obito) {
		this.obito = obito;
	}
	
	public Cartorio toCartorio(){
		Cartorio cartorio = new Cartorio();
		cartorio.setNome(nome);
		cartorio.setEndereco(endereco);
		
		
		return cartorio;
	}
	
	public Certidao toCasamentoCertidao(Cartorio cartorio){
		Certidao certidao = new Certidao();
		if(this.casamento != null) {
			certidao.setNome(this.casamento);
			certidao.setCartorio(cartorio);
		}
		return certidao;
	}
	
	public Certidao toNascimentoCertidao(Cartorio cartorio){
		Certidao certidao = new Certidao();
		if(this.casamento != null) {
			certidao.setNome(this.nascimento);
			certidao.setCartorio(cartorio);
		}
		return certidao;
	}
	
	public Certidao toObitoCertidao(Cartorio cartorio){
		Certidao certidao = new Certidao();
		if(this.casamento != null) {
			certidao.setNome(this.obito);
			certidao.setCartorio(cartorio);
		}
		return certidao;
	}
	
}

