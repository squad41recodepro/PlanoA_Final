package br.com.planoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.planoa.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>   {

}
