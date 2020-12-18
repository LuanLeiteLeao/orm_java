package model;
import java.util.Date;


@DBTable(table = "plataforma")
public class Plataformas extends ModelGeneric {
	
	
	@DBField(colummn = "plataformas_id", isPrimaryKey = true, isRequired = false)
	private Integer plataformasId;

	@DBField(colummn = "nome")
	private String nome;
	
	@DBField(colummn = "cricao")
	private Date criacao;
	
	@DBField(colummn = "modificacao")
	private Date modificacao;

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
