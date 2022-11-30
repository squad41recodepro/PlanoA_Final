package br.com.planoa.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table 
public class Disciplina {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDisciplina;
    
    @Column(nullable = false, length = 50)
    private String nomeDisciplina;
    
    @Column(nullable = false, length = 20)
    private String anoDisciplina;

	public Long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getAnoDisciplina() {
		return anoDisciplina;
	}

	public void setAnoDisciplina(String anoDisciplina) {
		this.anoDisciplina = anoDisciplina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoDisciplina, idDisciplina, nomeDisciplina);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return anoDisciplina == other.anoDisciplina && Objects.equals(idDisciplina, other.idDisciplina)
				&& Objects.equals(nomeDisciplina, other.nomeDisciplina);
	}
    
    

}
