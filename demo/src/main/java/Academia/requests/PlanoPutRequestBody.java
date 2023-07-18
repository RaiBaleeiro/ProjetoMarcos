package Academia.requests;

import lombok.Data;

@Data
public class PlanoPutRequestBody {
    private Long id;
	private String Nome;
	private String Valor;
    private String Beneficios;
}