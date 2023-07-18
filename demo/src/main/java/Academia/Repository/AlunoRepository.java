package Academia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Academia.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

    	List<Aluno> findByNome(String nome);

}
