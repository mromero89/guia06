package died.guia06;

import java.io.IOException;

public class RegistroAuditoriaException extends IOException {
	
	public RegistroAuditoriaException(){
		super("Se produjo un error al escribir el archivo de Auditoria");
		
	}
	

}
