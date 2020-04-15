package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	
	public Alumno() {
		cursando = new ArrayList<Curso>();
		aprobados = new ArrayList<Curso>();
		
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public int creditosObtenidos() {
		int suma = 0;
		for (Curso c : aprobados) {
			suma += c.getCreditos();
		}
		return suma;
	}

	public void aprobar(Curso c) {
		if (cursando.contains(c)) {
			cursando.remove(c);
			aprobados.add(c);
		}
		else
			System.out.println("No se encontraba inscripto al curso");
		
	}

	public void inscripcionAceptada(Curso c) {
		if (cursando.size() < 3)
			cursando.add(c);
		else
			System.out.println("Se llego al cupo maximo de materias posibles de cursar");
	}
	
	@Override
	public boolean equals (Object o) {
		if (o instanceof Alumno)
			if (((Alumno) o).getNroLibreta() == this.nroLibreta)
				return true;
			else
				return false;
		else
			return false;
	}

	public int compareTo(Alumno al) {
		// TODO Auto-generated method stub
		return this.nombre.compareTo(al.getNombre());
	}
	

}
