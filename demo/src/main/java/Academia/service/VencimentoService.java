package Academia.service;

import org.springframework.web.server.ResponseStatusException;
import Academia.domain.Vencimento;
import Academia.Repository.VencimentoRepository;
import Academia.requests.VencimentoPostRequestBody;
import Academia.requests.VencimentoPutRequestBody;
import lombok.RequiredArgsConstructor;
import Academia.domain.Aluno;
import Academia.domain.Plano;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class VencimentoService {
	Aluno aluno = new Aluno(1L, "Raí", "22222222", "232323232", "4242424242");
	Plano plano = new Plano(1L, "Basico", "50", "Musculacao");
	
	private final VencimentoRepository VencimentoRepository;
	   
	public List<Vencimento> listAll() {
    	return VencimentoRepository.findAll();
    }

	public Vencimento findByIdOrThrowBadRequestException(long id) {
        return VencimentoRepository.findById(id)
        		.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vencimento Não encontrado"));
 	    }
    
	public Vencimento save(VencimentoPostRequestBody vencimentoPostRequestBody) {
    	return VencimentoRepository.save(Vencimento.builder()
    			.Dia(vencimentoPostRequestBody.getDia())
    			.build());
    }

	public void delete(long id) {
		VencimentoRepository.delete(findByIdOrThrowBadRequestException(id));
		
	}

	public void replace(VencimentoPutRequestBody vencimentoPutRequestBody) {
        Vencimento savedvencimento = findByIdOrThrowBadRequestException(vencimentoPutRequestBody.getId());
        Vencimento vencimento = Vencimento.builder()
                .id(savedvencimento.getId())
                .Dia(vencimentoPutRequestBody.getDia())
                .build();

        VencimentoRepository.save(vencimento);
    }
     
	    
}

