import static org.junit.Assert.*;

import org.junit.Test;


public class TestClase {

	@Test (expected = Exception.class)
	public void testClaseInvalida1() {
		
		Clase curso = new Clase(null, null);
		
		fail("permitio crear clase sin datos");
	}
	
	@Test (expected = Exception.class)
	public void testClaseInvalida2() {
		
		Clase curso = new Clase(Clase.CUPO.CUPO_14, null);
		
		fail("permitio crear clase sin datos");
	}
	
	@Test (expected = Exception.class)
	public void testClaseInvalida3() {
		
		Clase curso = new Clase(null, Clase.TIPO.TIPO_2);
		
		fail("permitio crear clase sin datos");
	}
	
	
	@Test
	public void testCupoValido7(){
		try{
			Clase curso= new Clase(Clase.CUPO.CUPO_7, null);
		}
		catch(Exception e){
		fail("no permite crear una clase de 7");
	}}
	
	@Test
	public void testCupoValido14(){
		try{
			Clase curso= new Clase(Clase.CUPO.CUPO_14, null);
		}
		catch(Exception e){
		fail("no permite crear una clase de 14");
	}}
	
	@Test
	public void testAgregarAlumno() throws Exception{
		Clase curso= new Clase(Clase.CUPO.CUPO_7, null);
		int cant= curso.cantidadDeAlumnos();
		Alumno alu= new Alumno();
		curso.inscribir(alu);
		assertEquals("no incremento la cantidad",cant+1,curso.cantidadDeAlumnos());
		assertTrue("no se encontro al alumno en la lista de inscriptos",curso.estaInscripto(alu));
		Alumno alu2= new Alumno();
		assertFalse("aparece un alumno no inscripto", curso.estaInscripto(alu2));
	}
	
	@Test
	public void testNoPermitirAgregar8() throws Exception{
		Clase curso= new Clase(Clase.CUPO.CUPO_7, null);
		for (int i = 0; i < 7; i++) {
			curso.inscribir(new Alumno());
		}
		try {
			curso.inscribir(new Alumno());
		} catch (Exception e) {
			return;
		}
		fail("permitio inscribir un 8° alumno");
	}
	
	//de aca es nuevo.
	@Test
	public void testEliminarUltimoAlumno() throws Exception{
		Clase curso= new Clase(Clase.CUPO.CUPO_7, null);
		Alumno alu= new Alumno();
		curso.inscribir(alu);
		curso.desinscribir(alu);
		assertEquals("no quedo el curso vacio", 0,curso.cantidadDeAlumnos());
		try {
			curso.desinscribir(alu);
		} catch (Exception e2) {
			return;
		}
		fail("permitio eliminar de un curso vacio");
		
	}

	@Test
	public void testEliminarUnAlumno() throws Exception{
		Clase curso= new Clase(Clase.CUPO.CUPO_7, null);
		Alumno alu1= new Alumno();
		Alumno alu2= new Alumno();
		Alumno alu3= new Alumno();
		curso.inscribir(alu1);
		curso.inscribir(alu3);
		curso.inscribir(alu2);
		int cant= curso.cantidadDeAlumnos();
		curso.desinscribir(alu3);
		assertEquals("no eliminó nada", cant-1,curso.cantidadDeAlumnos());
		assertFalse("no borró al que debia",curso.estaInscripto(alu3));
		assertTrue("borró uno equivocado",curso.estaInscripto(alu2));
		assertTrue("borró uno equivocado",curso.estaInscripto(alu1));
		try {
			curso.desinscribir(new Alumno());
		} catch (Exception e2) {
			return;
		}
		fail("permitio eliminar un alumno que no esta inscripto");
	}
	
	@Test
	public void testTipoDeCursoValido(){
		Clase curso1= new Clase(Clase.CUPO.CUPO_14,Clase.TIPO.TIPO_1);
		assertEquals("no es el tipo correcto", Clase.TIPO.TIPO_1, curso1.verTipo());
		Clase curso2= new Clase(Clase.CUPO.CUPO_14,Clase.TIPO.TIPO_2);
		assertEquals("no es el tipo correcto", Clase.TIPO.TIPO_2, curso2.verTipo());
		Clase curso3= new Clase(Clase.CUPO.CUPO_14,Clase.TIPO.TIPO_3);
		assertEquals("no es el tipo correcto", Clase.TIPO.TIPO_3, curso3.verTipo());
	}
}
