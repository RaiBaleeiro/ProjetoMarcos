package Academia.requests;

import lombok.Data;

@Data
public class AlunoPutRequestBody {
    private Long id;
    private String Nome;
    private String Plano;
    private String Valor;  

}
