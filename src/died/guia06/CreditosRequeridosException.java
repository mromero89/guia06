package died.guia06;

public class CreditosRequeridosException extends Exception {
	
	public CreditosRequeridosException() {
		
		super("No se poseen los créditos requeridos para este curso.");
	}

}
