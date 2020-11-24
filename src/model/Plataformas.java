package model;

import java.util.Date;
import java.util.Hashtable;

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

	@Override
	protected Hashtable<String, String> objectNameAndFieldNameTable() {
		Hashtable<String, String> hashtable = new Hashtable<String, String>();

		hashtable.put("nome", "nome");
		hashtable.put("criacao", "criacao");
		hashtable.put("modificacao", "modificacao");
		return hashtable;
	}

	@Override
	public PrimaryKey getPrimaryKey() {
		return new PrimaryKey("plataformas_id","plataformasId",false);
	}


}
