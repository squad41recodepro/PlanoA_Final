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
public class Diciplina {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiciplina;
    
    @Column(nullable = false, length = 50)
    private String nomeDiciplina;
    
    @Column(nullable = false, length = 20)
    private String anoDiciplina;

	public Long getIdDiciplina() {
		return idDiciplina;
	}

	public void setIdDiciplina(Long idDiciplina) {
		this.idDiciplina = idDiciplina;
	}

	public String getNomeDiciplina() {
		return nomeDiciplina;
	}

	public void setNomeDiciplina(String nomeDiciplina) {
		this.nomeDiciplina = nomeDiciplina;
	}

	public String getAnoDiciplina() {
		return anoDiciplina;
	}

	public void setAnoDiciplina(String anoDiciplina) {
		this.anoDiciplina = anoDiciplina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoDiciplina, idDiciplina, nomeDiciplina);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diciplina other = (Diciplina) obj;
		return anoDiciplina == other.anoDiciplina && Objects.equals(idDiciplina, other.idDiciplina)
				&& Objects.equals(nomeDiciplina, other.nomeDiciplina);
	}
    
    

}
