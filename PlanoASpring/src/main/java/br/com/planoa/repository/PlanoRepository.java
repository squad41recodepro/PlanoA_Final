package br.com.planoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.planoa.model.Plano;

public interface PlanoRepository extends JpaRepository<Plano, Long> {

	// @EntityGraph(attributePaths = { "diciplina", "professor" })
	// List<Plano> findAll();

	// DICIPLINA

	// @Query("select p from plano p where p.diciplina.nomeDiciplina =
	// :diciplinaNome")
//	List<Plano> buscarPorDiciplina(String diciplinaNome);

	// @Query("select p from Plano p where p.diciplina.nomeDiciplina <>
	// :diciplinaNome")
	// List<Plano> buscarPorDiciplinaExceto(String diciplinaNome);

	// List<Plano> findByDiciplinaNome(String diciplinaNome);

	// PROFESSOR

	// @Query("select p from Plano p where p.professor.nomeProfessor =
	// :professorNome")
	// List<Plano> buscarPorProfessor(String professorNome);

	// @Query("select p from Plano p where p.professor.nomeProfessor <>
	// :professorNome")
	// List<Plano> buscarPorProfessorExceto(String professorNome);

	// List<Plano> findByProfessorNome(String professorNome);

}
