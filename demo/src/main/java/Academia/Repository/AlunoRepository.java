package Academia.Repository;


import org.springframework.data.repository.CrudRepository;

import Academia.domain.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {

}

