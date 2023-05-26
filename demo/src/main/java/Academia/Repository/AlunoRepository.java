package Academia.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import Academia.domain.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {


}

