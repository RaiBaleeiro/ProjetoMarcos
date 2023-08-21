package Academia.service;

import org.springframework.web.server.ResponseStatusException;

import Academia.domain.Aluno;
import Academia.Repository.AlunoRepository;
import Academia.requests.AlunoPostRequestBody;
import Academia.requests.AlunoPutRequestBody;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AlunoService {
	private final AlunoRepository AlunoRepository;

	public List<Aluno> listAll() {
    	return AlunoRepository.findAll();
    }
	
	public Aluno findByIdOrThrowBadRequestException(long id) {
        return AlunoRepository.findById(id)
        		.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aluno Não encontrado"));
 	    }
    
	public Aluno save(AlunoPostRequestBody alunoPostRequestBody) {
    	return AlunoRepository.save(Aluno.builder()
    			.Nome(alunoPostRequestBody.getNome())
    			.Cpf(alunoPostRequestBody.getCpf())
                .Email(alunoPostRequestBody.getEmail())
                .Contato(alunoPostRequestBody.getContato())
    			.build());
    }

	public void delete(long id) {
		AlunoRepository.delete(findByIdOrThrowBadRequestException(id));
		
	}

	public void replace(AlunoPutRequestBody alunoPutRequestBody) {
        Aluno savedAluno = findByIdOrThrowBadRequestException(alunoPutRequestBody.getId());
        Aluno aluno = Aluno.builder()
                .id(savedAluno.getId())
                .Nome(alunoPutRequestBody.getNome())
    			.Cpf(alunoPutRequestBody.getCpf())
                .Email(alunoPutRequestBody.getEmail())
                .Contato(alunoPutRequestBody.getContato())      
                .build();

        AlunoRepository.save(aluno);
    }
	     
    public List<Aluno> findByNome(String aluno) {
    	return AlunoRepository.findByNome(aluno);
    }    

}