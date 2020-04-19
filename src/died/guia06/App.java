package died.guia06;

public class App {
	
	
	// public Curso(int id, String nombre, int cupo, int creditos, int credReq)

		public static void main(String[] args) throws RegistroAuditoriaException, CreditosRequeridosException, CupoCubiertoException, LimiteMateriasException {
			Curso adm = new Curso(1, "administracion", 5, 10, 0);
			Curso red = new Curso(2, "redes", 3, 5, 1);
			Curso fin = new Curso(3, "finanzas", 2, 8, 0);
			Curso der = new Curso(4, "derecho", 5, 6, 2);
			
		
			
			//public Alumno(String nombre, Integer lu)
			Alumno al1 = new Alumno("Jose", 100);
			Alumno al2 = new Alumno("Maria", 101);
			Alumno al3 = new Alumno("Alberto", 102);
			Alumno al4 = new Alumno("Matias", 103);
			Alumno al5 = new Alumno("Gisela", 104);
			
			System.out.println("Se intenta inscribir a los alumnos Jose, Maria, Alberto");
			System.out.println("Matias y Gisela:");
			
			try {
				adm.inscribirAlumno(al1);
				adm.inscribirAlumno(al2);
				fin.inscribirAlumno(al4);
				red.inscribirAlumno(al3);
				der.inscribirAlumno(al5);
			
			}
			catch (CreditosRequeridosException c) {
				System.out.println(c.getMessage());
			}
			catch (CupoCubiertoException c) {
				System.out.println(c.getMessage());
			}
			catch (LimiteMateriasException c) {
				System.out.println(c.getMessage());
			}
			
			
			System.out.println("\nImprimiendo inscriptos por orden alfabetico");
			System.out.println("\nAdministracion: ");
			adm.imprimirInscriptos();
			System.out.println("\nRedes: ");
			red.imprimirInscriptos();
			System.out.println("\nFinanzas: ");
			fin.imprimirInscriptos();
			System.out.println("\nDerecho: ");
			der.imprimirInscriptos();

			
			System.out.println("\nSe hace aprobar Administracion a Jose y se lo inscribe a redes");
			System.out.println("Se vuelve a inscribir a los alumnos Alberto y Gisela, a la materia finanzas");
			
			try {
			al1.aprobar(adm);
			red.inscribirAlumno(al1);
			fin.inscribirAlumno(al3);
			fin.inscribirAlumno(al5);
			}
			catch (CreditosRequeridosException c) {
				System.out.println(c.getMessage());
			}
			catch (CupoCubiertoException c) {
				System.out.println(c.getMessage());
			}
			catch (LimiteMateriasException c) {
				System.out.println(c.getMessage());
			}
			/*
			System.out.println("\nRedes:");
			red.imprimirInscriptos();*/
			
			System.out.println("\nImprimiendo inscriptos por orden de LU");
			
			System.out.println("\nAdministracion: ");
			adm.imprimirInscriptosLU();
			System.out.println("\nRedes: ");
			red.imprimirInscriptosLU();
			System.out.println("\nFinanzas: ");
			fin.imprimirInscriptosLU();
			System.out.println("\nDerecho: ");
			der.imprimirInscriptosLU();
			
			System.out.println("\nSe inscribe a Gisela en Administracion, se aprueba a Matias en Finanzas");
			System.out.println("y se lo inscribe en Derecho. Se inscribe alumno Ricardo a Administracion");
			
			Alumno al6 = new Alumno("Ricardo", 105);
			try {
			
			adm.inscribirAlumno(al6);
			adm.inscribirAlumno(al5);
			al4.aprobar(fin);
			der.inscribirAlumno(al4);
			}
			catch (CreditosRequeridosException c) {
				System.out.println(c.getMessage());
			}
			catch (CupoCubiertoException c) {
				System.out.println(c.getMessage());
			}
			catch (LimiteMateriasException c) {
				System.out.println(c.getMessage());
			}
			
			
			System.out.println("\nImprimiendo inscriptos por orden de Creditos");
			
			System.out.println("\nAdministracion: ");
			adm.imprimirInscriptosCreditos();
			System.out.println("\nRedes: ");
			red.imprimirInscriptosCreditos();
			System.out.println("\nFinanzas: ");
			fin.imprimirInscriptosCreditos();
			System.out.println("\nDerecho: ");
			der.imprimirInscriptosCreditos();
			
			System.out.println("\nSe aprueba Ricardo de Administracion y se lo inscribe en Derecho");
			
			
			al6.aprobar(adm);
			try {
			der.inscribirAlumno(al6);
			}
			catch (CreditosRequeridosException c) {
				System.out.println(c.getMessage());
			}
			catch (CupoCubiertoException c) {
				System.out.println(c.getMessage());
			}
			catch (LimiteMateriasException c) {
				System.out.println(c.getMessage());
			}
			
			
			System.out.println("\nImprimiendo inscriptos por orden de Creditos");
			
			System.out.println("\nAdministracion: ");
			adm.imprimirInscriptosCreditos();
			System.out.println("\nRedes: ");
			red.imprimirInscriptosCreditos();
			System.out.println("\nFinanzas: ");
			fin.imprimirInscriptosCreditos();
			System.out.println("\nDerecho: ");
			der.imprimirInscriptosCreditos();
			
			System.out.println("\nSe inscribe a Jose a las materias Finanzas, Derecho y Administracion");
			try {
			fin.inscribirAlumno(al1);
			der.inscribirAlumno(al1);
			adm.inscribirAlumno(al1);
			}
			catch (CreditosRequeridosException c) {
				System.out.println(c.getMessage());
			}
			catch (CupoCubiertoException c) {
				System.out.println(c.getMessage());
			}
			catch (LimiteMateriasException c) {
				System.out.println(c.getMessage());
			}
			
			System.out.println("\nImprimiendo inscriptos por orden alfabetico");
			System.out.println("\nAdministracion: ");
			adm.imprimirInscriptos();
			System.out.println("\nRedes: ");
			red.imprimirInscriptos();
			System.out.println("\nFinanzas: ");
			fin.imprimirInscriptos();
			System.out.println("\nDerecho: ");
			der.imprimirInscriptos();
			
			System.out.println("\nSe aprueba a Jose en Finanzas");
			
			al1.aprobar(fin);
			
			System.out.println("\nImprimiendo inscriptos por orden de Creditos");
			
			System.out.println("\nAdministracion: ");
			adm.imprimirInscriptosCreditos();
			System.out.println("\nRedes: ");
			red.imprimirInscriptosCreditos();
			System.out.println("\nFinanzas: ");
			fin.imprimirInscriptosCreditos();
			System.out.println("\nDerecho: ");
			der.imprimirInscriptosCreditos();



			

		}

}
