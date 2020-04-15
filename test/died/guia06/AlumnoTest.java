package died.guia06;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlumnoTest {

	@Test
	void testCreditosObtenidos() {
		Alumno al = new Alumno();
		int aux;
		aux = al.creditosObtenidos();
		assertEquals(aux, 0);
		
	}

	@Test
	void testAprobar() {
		Alumno al = new Alumno();
		Curso c1 = new Curso(1);
		Curso c2 = new Curso(2);
		Curso c3 = new Curso(3);
		al.inscripcionAceptada(c1);
		al.inscripcionAceptada(c2);
		
		assertTrue(al.aprobar(c1));
		assertTrue(al.aprobar(c2));
		assertFalse(al.aprobar(c3));
		
	
	}

	@Test
	void testInscripcionAceptada() {
		Curso c = new Curso();
		Alumno al = new Alumno();
		al.inscripcionAceptada(c);
		
	}
	
	@Test
	void testEqualsObject() {
		Alumno al1 = new Alumno("Alumno 1", 1234);
		Alumno al2 = new Alumno("Alumno 2", 1235);
		Alumno al3 = new Alumno("Alumno 3", 1234);
		
		assertFalse(al1.equals(al2));
		assertTrue(al1.equals(al3));
	
	}

	@Test
	void testCompareTo() {
		Alumno al1 = new Alumno("Alberto", 1234);
		Alumno al2 = new Alumno("Hector", 1235);
		Alumno al3 = new Alumno("Jose", 1234);
		
		int r1 = al1.compareTo(al2); //deberia dar negativo
		int r2 = al3.compareTo(al2); //deberia dar positivo
		int r3 = al1.compareTo(al3); //deberia dar negativo
		
		assertTrue(r1<0);
		assertTrue(r2>0);
		assertTrue(r3<0);
		
		
	}

}
