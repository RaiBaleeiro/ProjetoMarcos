package Academia.requests;

import lombok.Data;

@Data
public class AlunoPostRequestBody {
    private String Nome;
    private String Cpf;
    private String Email;
    private String Contato;
}