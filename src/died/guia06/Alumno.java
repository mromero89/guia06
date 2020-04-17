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
	
	public Alumno(String nombre, Integer lu) {
		this.nombre = nombre;
		this.nroLibreta = lu;
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

	public boolean aprobar(Curso c) {
		
		
		boolean b = false;
		for(Curso cu : cursando) {
			if (cu.getId().equals(c.getId().intValue())) {				
				aprobados.add(c);
				b = true;
			}

			
		}
		
		if (b == true) {
			cursando.remove(c);
			return true;
		}
		else {
			System.out.println("No se encontraba inscripto al curso");
			return false;
		}
			
		
	
		
	}

	public void inscripcionAceptada(Curso c) {
		if (cursando.size() < 3)
			cursando.add(c);
		else
			System.out.println("Se llego al cupo maximo de materias posibles de cursar");
	}
	
	@Override
	public boolean equals (Object o) {
		
		if ((o instanceof Alumno) && ((((Alumno) o).getNroLibreta()).equals(this.getNroLibreta()) )) 
			
			return true;
		else
		
			return false;
	}

	public int compareTo(Alumno al) {
		return this.nombre.compareTo(al.getNombre());
	}
	

}
