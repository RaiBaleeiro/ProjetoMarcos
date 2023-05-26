package Academia.domain;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Aluno {
    private Long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Nome;
    private String Valor;
    private String Plano;

    

    public Aluno save(Aluno aluno) {
        return null;
    }



    public void add(Aluno aluno) {
    }



 

  
}
