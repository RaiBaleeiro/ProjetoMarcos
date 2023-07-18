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
import org.springframework.web.bind.annotation.RestController;

import Academia.domain.Vencimento;
import Academia.requests.VencimentoPostRequestBody;
import Academia.requests.VencimentoPutRequestBody;
import Academia.service.VencimentoService;
import Academia.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/Vencimentos")
public class VencimentoController {
	private final DateUtil dateUtil;
    private final VencimentoService vencimentoService;
    
    @GetMapping
    public ResponseEntity<List<Vencimento>> list(){
    	log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(vencimentoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Vencimento> findById(@PathVariable long id){
        return ResponseEntity.ok(vencimentoService.findByIdOrThrowBadRequestException(id));
    }
    
    @PostMapping
    public ResponseEntity<Vencimento> save(@RequestBody VencimentoPostRequestBody vencimentoPostRequestBody){
        return new ResponseEntity<>(vencimentoService.save(vencimentoPostRequestBody), HttpStatus.CREATED);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
    	vencimentoService.delete(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody VencimentoPutRequestBody vencimentoPutRequestBody){
    	vencimentoService.replace(vencimentoPutRequestBody);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}

