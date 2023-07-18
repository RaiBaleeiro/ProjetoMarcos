package Academia.requests;

import lombok.Data;

@Data
public class PlanoPostRequestBody {
	private String Nome;
	private String Valor;
    private String Beneficios;
}