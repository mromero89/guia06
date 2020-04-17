package died.guia06;

import java.util.Comparator;

public class ComparaAlumnoLU implements Comparator<Alumno> {

	@Override
	public int compare(Alumno a1, Alumno a2) {
		return (a1.getNroLibreta()-a2.getNroLibreta());
	}

}
