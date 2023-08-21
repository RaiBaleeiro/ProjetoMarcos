package Academia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Academia.domain.Vencimento;

public interface VencimentoRepository extends JpaRepository<Vencimento, Long>{

}
