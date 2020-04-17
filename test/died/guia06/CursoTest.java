package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CursoTest {

	@Test
	void testInscribir() {
		
		Alumno a1 = new Alumno();
		Curso c1 = new Curso();
		c1.setCreditosRequeridos(0);
		c1.setCupo(2);
		assertTrue(c1.inscribir(a1));
		
		Alumno a2 = new Alumno();
		Alumno a3 = new Alumno();
		c1.inscribir(a2);
		assertFalse(c1.inscribir(a3));
		
		
	}

	@Test
	void testImprimirInscriptos() {
		//testeo orden alfabetico
		Alumno a1 = new Alumno("Jorge", 110);	
		Alumno a2 = new Alumno("Alberto", 111);
		Alumno a3 = new Alumno("Ricardo", 112);
		Curso c1 = new Curso();
		c1.setCreditosRequeridos(0);
		c1.setCupo(3);
		assertTrue(c1.inscribir(a1));
		assertTrue(c1.inscribir(a2));
		assertTrue(c1.inscribir(a3));
		
		c1.imprimirInscriptos();
		

		
	}

	@Test
	void testImprimirInscriptosLU() {
		//testeo orden por libreta universitaria
				Alumno a1 = new Alumno("Jorge", 110);	
				Alumno a2 = new Alumno("Alberto", 111);
				Alumno a3 = new Alumno("Ricardo", 112);
				Curso c1 = new Curso();
				c1.setCreditosRequeridos(0);
				c1.setCupo(3);
				assertTrue(c1.inscribir(a1));
				assertTrue(c1.inscribir(a2));
				assertTrue(c1.inscribir(a3));
				
				c1.imprimirInscriptosLU();
	}

	@Test
	void testImprimirInscriptosCreditos() {
		
		//testeo orden por creditos obtenidos
		Alumno a1 = new Alumno("Jorge", 110);	
		Alumno a2 = new Alumno("Alberto", 111);
		Alumno a3 = new Alumno("Ricardo", 112);
		Curso c1 = new Curso();
		c1.setId(1);
		c1.setCreditosRequeridos(0);
		c1.setCreditos(1);
		c1.setCupo(3);
		assertTrue(c1.inscribir(a1));
		assertTrue(c1.inscribir(a2));
		assertTrue(c1.inscribir(a3));
		
		Curso c2 = new Curso();
		c2.setId(2);
		c2.setCreditosRequeridos(0);
		c2.setCreditos(2);
		c2.setCupo(3);
		
		assertTrue(c2.inscribir(a2));
		
		a1.aprobar(c1);
		a2.aprobar(c2);
		a2.aprobar(c1);
	
		
		c1.imprimirInscriptosCreditos();
	}

}
