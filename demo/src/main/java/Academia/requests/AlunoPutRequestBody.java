package Academia.requests;

import lombok.Data;

@Data
public class AlunoPutRequestBody {
    private String Valor;
    private String Plano;
    private String Nome;
    private Long id;
}
