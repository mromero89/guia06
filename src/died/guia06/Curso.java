package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	public Integer getCreditos() {
		return creditos;
	}


	public Integer getId() {
		return id;
	}


	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public Curso(Integer id) {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
		this.id = id;
	}
	
	public Curso(int id, String nombre, int cupo, int creditos, int credReq) {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
		this.id = id;
		this.nombre = nombre;
		this.cupo = cupo;
		this.creditos = creditos;
		this.creditosRequeridos = credReq;
	}
	
	
	

	public void setId(Integer id) {
		this.id = id;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setCicloLectivo(Integer cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}


	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}


	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}


	public void setCreditosRequeridos(Integer creditosRequeridos) {
		this.creditosRequeridos = creditosRequeridos;
	}


	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {
		try {
			//verificar si el alumno cuenta con los creditos requeridos creditosObtenidos()
			if ((a.creditosObtenidos() >= this.creditosRequeridos) && (this.inscriptos.size()<this.cupo) && (a.cantidadCursando()<3)) {
				a.inscripcionAceptada(this);
				inscriptos.add(a);
				log.registrar(this, "inscribir ",a.toString());
				return true;
			}
			else {
				System.out.println("no se pudo inscribir el alumno "+a.getNombre()+" al curso "+this.nombre);
				return false;
			}
				
				
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void inscribirAlumno(Alumno a) throws CreditosRequeridosException, CupoCubiertoException, LimiteMateriasException, RegistroAuditoriaException {
		try {


			if (!(a.creditosObtenidos() >= this.creditosRequeridos))
				throw new CreditosRequeridosException(a.getNombre());
			if (!(this.inscriptos.size()<this.cupo)) 
				throw new CupoCubiertoException(a.getNombre());
			if (!(a.cantidadCursando()<3))
				throw new LimiteMateriasException(a.getNombre());



			a.inscripcionAceptada(this);
			inscriptos.add(a);
			log.registrar(this, "inscribir ",a.toString());



		} catch (IOException e) {

			throw new RegistroAuditoriaException();

		}
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos() {
		try {
			Collections.sort(inscriptos);
			System.out.println("Imprimiendo alumnos inscriptos por orden alfabetico:");
			for (Alumno al : inscriptos) {
				System.out.println("Alumno: "+al.getNombre()+" LU: "+al.getNroLibreta()+" Creditos: "+al.creditosObtenidos());
			}
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * imprime los inscriptos ordenados segun libreta universitaria
	 */
	public void imprimirInscriptosLU() {
		try {
			inscriptos.sort(new ComparaAlumnoLU());
			System.out.println("Imprimiendo alumnos inscriptos por orden de Libreta Universitaria:");
			for (Alumno al : inscriptos) {
				System.out.println("Alumno: "+al.getNombre()+" LU: "+al.getNroLibreta()+" Creditos: "+al.creditosObtenidos());
			}
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * imprime los inscriptos ordenados segun creditos obtenidos
	 */
	public void imprimirInscriptosCreditos() {
		try {
			inscriptos.sort(new ComparaAlumnoCreditos());
			System.out.println("Imprimiendo alumnos inscriptos por orden de Creditos Obtenidos:");
			for (Alumno al : inscriptos) {
				System.out.println("Alumno: "+al.getNombre()+" LU: "+al.getNroLibreta()+" Creditos: "+al.creditosObtenidos());
			}
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void aprobar(Alumno a) {
		inscriptos.remove(a);
	}


}
