package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InscribirAlumnoTest {

	@Test
	void testArrojarCreditosReq() throws RegistroAuditoriaException, CupoCubiertoException, LimiteMateriasException {
		Curso red = new Curso(2, "redes", 3, 5, 1);
		Alumno al1 = new Alumno("Jose", 100);
		try {
			red.inscribirAlumno(al1);
			fail("Se esperaba excepcion CreditosRequeridosException"); // TODO
		}
		catch(CreditosRequeridosException c) {}
		
	}
	
	@Test
	void testCupoCubierto() throws RegistroAuditoriaException, CupoCubiertoException, LimiteMateriasException, CreditosRequeridosException {
		Curso red = new Curso(2, "redes", 0, 5, 0);
		Alumno al1 = new Alumno("Jose", 100);
		try {
			red.inscribirAlumno(al1);
			fail("Se esperaba excepcion CupoCubierto"); // TODO
		}
		catch(CupoCubiertoException c) {}
		
	}
	
	@Test
	void testMaterias() throws RegistroAuditoriaException, CupoCubiertoException, LimiteMateriasException, CreditosRequeridosException {
		Curso red = new Curso(2, "redes", 1, 5, 0);
		Curso mat = new Curso(2, "matematica", 1, 5, 0);
		Curso alg = new Curso(2, "algoritmos", 1, 5, 0);
		Curso fin = new Curso(2, "finanzas", 1, 5, 0);
		Alumno al1 = new Alumno("Jose", 100);
		try {
			red.inscribirAlumno(al1);
			mat.inscribirAlumno(al1);
			alg.inscribirAlumno(al1);
			fin.inscribirAlumno(al1);
			fail("Se esperaba excepcion CupoCubierto"); // TODO
		}
		catch(LimiteMateriasException c) {}
		
	}

	
}
