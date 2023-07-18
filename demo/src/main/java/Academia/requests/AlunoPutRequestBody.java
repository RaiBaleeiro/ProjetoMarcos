package Academia.requests;

import lombok.Data;

@Data
public class AlunoPutRequestBody {
    private Long id;
    private String Nome;
    private String Cpf;
    private String Email;
    private String Contato;

}
