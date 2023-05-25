package Academia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Academia.domain.Aluno;

@Service
public class AlunoService {
    public static List<Aluno> alunos;
    
    static {
        alunos = new ArrayList<>(List.of(new Aluno( 0L,"Paulo","50", "Basico"), new Aluno( 1L,"Joao","75", "intermediário"), new Aluno( 2L,"Sam","100", "Completo")));
    }

        public List<Aluno> listAll(){
            return alunos;
        }
        public Aluno findById(long id){
            return alunos.stream()
            .filter(aluno -> aluno.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "ALUNO NÃO ENCONTRADO"));
        }

    public void delete(long id){
        alunos.remove(findById(id));
    }

    public void replace(Aluno aluno){
        delete(aluno.getId());
        alunos.add(aluno);
    }
    public Aluno save(Aluno aluno) {
        aluno.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        aluno.add(aluno);
        return aluno;
    }
}
