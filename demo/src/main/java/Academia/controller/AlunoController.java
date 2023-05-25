package Academia.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Academia.domain.Aluno;
import Academia.service.AlunoService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("Alunos")
@RequiredArgsConstructor
public class AlunoController {
    private final AlunoService alunoService;

    @GetMapping(path = "List")
    public ResponseEntity<List<Aluno>> list() {
        return ResponseEntity.ok(alunoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable long id){
        return ResponseEntity.ok(alunoService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody Aluno aluno) {
        return new ResponseEntity<>(alunoService.save(aluno), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        alunoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Aluno aluno ){
        alunoService.replace(aluno);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
