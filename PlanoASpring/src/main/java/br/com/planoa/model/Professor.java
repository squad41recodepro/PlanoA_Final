package br.com.planoa.model;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProfessor;

	@Column(nullable = false, length = 50)
	private String nomeProfessor;

	@Column(nullable = false, length = 11)
	private String cpfProfessor;

	@Column(nullable = false, length = 50)
	private String formacao;

	@Lob
	private byte[] imagem;

	public Professor() {
	}

	public Professor(Long idProfessor, String nomeProfessor, String cpfProfessor, String formacao) {
		this.idProfessor = idProfessor;
		this.nomeProfessor = nomeProfessor;
		this.cpfProfessor = cpfProfessor;
		this.formacao = formacao;
	}

	public Long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getCpfProfessor() {
		return cpfProfessor;
	}

	public void setCpfProfessor(String cpfProfessor) {
		this.cpfProfessor = cpfProfessor;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
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
		result = prime * result + Objects.hash(cpfProfessor, formacao, idProfessor, nomeProfessor);
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
		Professor other = (Professor) obj;
		return Objects.equals(cpfProfessor, other.cpfProfessor) && Objects.equals(formacao, other.formacao)
				&& Objects.equals(idProfessor, other.idProfessor) && Arrays.equals(imagem, other.imagem)
				&& Objects.equals(nomeProfessor, other.nomeProfessor);
	}

}
