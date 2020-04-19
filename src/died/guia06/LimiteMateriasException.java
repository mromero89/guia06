package died.guia06;

public class LimiteMateriasException extends Exception {

	public LimiteMateriasException(String a) {
		super("Problema con: "+a+". El alumno ya esta inscripto al maximo de materias.");
	}


}