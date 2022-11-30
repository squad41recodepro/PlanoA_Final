package br.com.planoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.planoa.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>   {

}
