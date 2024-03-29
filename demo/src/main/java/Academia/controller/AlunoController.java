package Academia.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Academia.domain.Aluno;
import Academia.requests.AlunoPostRequestBody;
import Academia.requests.AlunoPutRequestBody;
import Academia.service.AlunoService;
import Academia.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/Alunos")
public class AlunoController {
	private final DateUtil dateUtil;
    private final AlunoService alunoService;
    
    @GetMapping
    public ResponseEntity<List<Aluno>> list(){
    	log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(alunoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable long id){
        return ResponseEntity.ok(alunoService.findByIdOrThrowBadRequestException(id));
    }
    
    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody AlunoPostRequestBody alunoPostRequestBody){
        return new ResponseEntity<>(alunoService.save(alunoPostRequestBody), HttpStatus.CREATED);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
		alunoService.delete(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AlunoPutRequestBody alunoPutRequestBody){
    	alunoService.replace(alunoPutRequestBody);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
       @GetMapping(path = "/find")
    public ResponseEntity<List<Aluno>> findByNome(@RequestParam(name="nome") String nome){
        return ResponseEntity.ok(alunoService.findByNome(nome));
    }

}

