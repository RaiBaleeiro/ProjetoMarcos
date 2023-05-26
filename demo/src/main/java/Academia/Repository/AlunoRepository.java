package Academia.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import Academia.domain.Aluno;

@Repository
@NoRepositoryBean
public interface AlunoRepository extends JpaRepository<Aluno, Long> {



}

