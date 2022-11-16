package br.com.planoa.model;

import java.util.Arrays;
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
public class Plano {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlano;

	@Column(nullable = false, length = 50)
	private String nomePlano;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDiciplina", nullable = false)
   	private Diciplina diciplina;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProfessor", nullable = false)
   	private Professor professor;

	@Lob
	private byte[] imagem;

	public Plano() {}
	
	public Plano(Long idPlano, String nomePlano, Diciplina diciplina, Professor professor) {
		super();
		this.idPlano = idPlano;
		this.nomePlano = nomePlano;
		this.diciplina = diciplina;
		this.professor = professor;
	}

	public Long getIdPlano() {
		return idPlano;
	}

	public void setIdPlano(Long idPlano) {
		this.idPlano = idPlano;
	}

	public String getNomePlano() {
		return nomePlano;
	}

	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}

	public Diciplina getDiciplina() {
		return diciplina;
	}

	public void setDiciplina(Diciplina diciplina) {
		this.diciplina = diciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(imagem);
		result = prime * result + Objects.hash(diciplina, idPlano, nomePlano, professor);
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
		Plano other = (Plano) obj;
		return Objects.equals(diciplina, other.diciplina) && Objects.equals(idPlano, other.idPlano)
				&& Arrays.equals(imagem, other.imagem) && Objects.equals(nomePlano, other.nomePlano)
				&& Objects.equals(professor, other.professor);
	}



}