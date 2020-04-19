package died.guia06;

public class CreditosRequeridosException extends Exception {

	public CreditosRequeridosException(String a) {

		super("Problema con: "+a+". No se poseen los créditos requeridos para este curso.");
	}

}