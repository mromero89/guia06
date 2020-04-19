package died.guia06;

public class CupoCubiertoException extends Exception {

	public CupoCubiertoException(String a) {
		super("Problema con: "+a+". Se encuentra cubierto el cupo en el curso");
	}


}