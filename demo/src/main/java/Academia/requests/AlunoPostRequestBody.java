package Academia.requests;

import lombok.Data;

@Data
public class AlunoPostRequestBody {
    private String Nome;
    private String Plano;
    private String Valor;
}