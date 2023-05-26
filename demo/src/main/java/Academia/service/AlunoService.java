package Academia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Academia.Repository.AlunoRepository;
import Academia.domain.Aluno;
import Academia.requests.AlunoPostRequestBody;
import Academia.requests.AlunoPutRequestBody;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoService {
  /*  public static List<Aluno> alunos;
    
    static {
         alunos = new ArrayList<>(List.of(new Aluno( 0L,"Paulo","50", "Basico"), new Aluno( 1L,"Joao","75", "intermediário"), new Aluno( 2L,"Sam","100", "Completo")));
    } */

        private final AlunoRepository alunoRepository;

        public List<Aluno> listAll(){
            return alunoRepository.findAll();
        }
        public Aluno findById(long id){
            return alunoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "ALUNO NÃO ENCONTRADO"));
        }

    public void delete(long id){
        alunoRepository.delete(findById(id));
    }

    public void replace(AlunoPutRequestBody alunoPutRequestBody){
        findById(alunoPutRequestBody.getId());
        Aluno aluno = Aluno.builder()
            .id(alunoPutRequestBody.getId())
            .Nome(alunoPutRequestBody.getNome())
            .build();

        alunoRepository.save(aluno);

    }

    public Aluno save(AlunoPostRequestBody alunoPostRequestBody) {
        return alunoRepository.save(Aluno.builder().Nome(alunoPostRequestBody.getNome()).build());
    }
}
