package model;

import java.sql.Date;

public class Plataformas extends ModelGeneric {
	public Integer plataformasId;
	public String nome;
	public Date criacao;
	public Date modificacao;

	public Integer getPlataformasId() {
		return plataformasId;
	}

	public void setPlataformasId(Integer plataformasId) {
		this.plataformasId = plataformasId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public Date getModificacao() {
		return modificacao;
	}

	public void setModificacao(Date modificacao) {
		this.modificacao = modificacao;
	}

}
