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

import Academia.domain.Plano;
import Academia.requests.PlanoPostRequestBody;
import Academia.requests.PlanoPutRequestBody;
import Academia.service.PlanoService;
import Academia.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/Planos")
public class PlanoController {
	private final DateUtil dateUtil;
    private final PlanoService planoService;
    
    @GetMapping
    public ResponseEntity<List<Plano>> list(){
    	log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(planoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Plano> findById(@PathVariable long id){
        return ResponseEntity.ok(planoService.findByIdOrThrowBadRequestException(id));
    }
    
    @PostMapping
    public ResponseEntity<Plano> save(@RequestBody PlanoPostRequestBody planoPostRequestBody){
        return new ResponseEntity<>(planoService.save(planoPostRequestBody), HttpStatus.CREATED);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
		planoService.delete(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody PlanoPutRequestBody PlanoPutRequestBody){
    	planoService.replace(PlanoPutRequestBody);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}

