import static org.junit.Assert.*;

import org.junit.Test;


public class TestAlumno {

	@Test
	public void testInscribirEnClase() throws Exception {
		Clase curso= new Clase(Clase.CUPO.CUPO_7, Clase.TIPO.FUERZA_MAX);
		Alumno alu = new Alumno();
		alu.inscribir(curso);
		assertTrue("no aparece el alumno que se inscribio",curso.estaInscripto(alu));
		assertTrue("no esta inscripto en el curso", alu.estaInscripto(curso));
	}
	
	@Test
	public void testNoInscribirEnClasesDeIgualTipo() throws Exception{
		Alumno alu = new Alumno();
		Clase curso1= new Clase(Clase.CUPO.CUPO_7, Clase.TIPO.FUERZA_MAX);
		Clase curso2= new Clase(Clase.CUPO.CUPO_7, Clase.TIPO.FUERZA_MAX);
		alu.inscribir(curso1);
		try {
			alu.inscribir(curso2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		fail("permitio inscribir en cursos del mismo tipo");
	}
	
	public void testNoInscribirEnClasesDelMismoHorario() throws Exception{
		Alumno alu = new Alumno();
		Clase curso1= new Clase(Clase.CUPO.CUPO_7, null);
		Clase curso2= new Clase(Clase.CUPO.CUPO_7, null);
		alu.inscribir(curso1);
		try {
			alu.inscribir(curso2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		fail("permitio inscribir en cursos con el mismo horario");
	}
}
