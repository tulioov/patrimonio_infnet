package edu.infnet.patrimonio.negocio.modelo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patrimonio {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String descricao;
	
	private String localizacao;
	
	public Patrimonio() {
	}

	public Patrimonio(Integer id) {
		this.id = id;
	}
	
	public Patrimonio(Integer id, String descricao, String localizacao) {
		this.id = id;
		this.descricao = descricao;
		this.localizacao = localizacao;
	}

	public Patrimonio(String descricao, String localizacao) {
		this.descricao = descricao;
		this.localizacao = localizacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	@Override
	public String toString() {
		return "Patrimonio [id=" + id + ", descricao=" + descricao + ", localizacao=" + localizacao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((localizacao == null) ? 0 : localizacao.hashCode());
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
		Patrimonio other = (Patrimonio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (localizacao == null) {
			if (other.localizacao != null)
				return false;
		} else if (!localizacao.equals(other.localizacao))
			return false;
		return true;
	}

	
	
	
}
