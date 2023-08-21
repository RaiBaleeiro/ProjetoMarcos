package Academia.service;

import org.springframework.web.server.ResponseStatusException;
import Academia.domain.Plano;
import Academia.Repository.PlanoRepository;
import Academia.requests.PlanoPostRequestBody;
import Academia.requests.PlanoPutRequestBody;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlanoService {
	

	private final PlanoRepository planoRepository;
    
    public List<Plano> listAll() {
    	return planoRepository.findAll();
    }
    
    
    public Plano findByIdOrThrowBadRequestException(long id) {
        return planoRepository.findById(id)
        		.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Camisa Não encontrada"));
 	    }
    
    @Transactional
    public Plano save(PlanoPostRequestBody planoPostRequestBody) {
    	return planoRepository.save(Plano.builder()
    			.Nome(planoPostRequestBody.getNome())
    			.Valor(planoPostRequestBody.getValor())
                .Beneficios(planoPostRequestBody.getBeneficios())
    			.build());
    }

	public void delete(long id) {
		planoRepository.delete(findByIdOrThrowBadRequestException(id));
		
	}
	
	public void replace(PlanoPutRequestBody planoPutRequestBody) {
        Plano savedPlano = findByIdOrThrowBadRequestException(planoPutRequestBody.getId());
        Plano plano = Plano.builder()
                .id(savedPlano.getId())
                .Nome(planoPutRequestBody.getNome())
                .Valor(planoPutRequestBody.getValor())
                .Beneficios(planoPutRequestBody.getBeneficios())
                .build();

        planoRepository.save(plano);
    }
	     
	    
}