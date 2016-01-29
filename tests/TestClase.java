import static org.junit.Assert.*;

import org.junit.Test;


public class TestClase {

	@Test
	public void testCupoInvalido() {
		try{
		Clase curso = new Clase(null, Clase.TIPO.FUERZA_MAX);
		}
		catch (Exception e){
			System.out.println("anduvo");
			return;
		}
		fail("permitio crear clase nula");
	}
	
	@Test
	public void testCupoValido7(){
		try{
			Clase curso= new Clase(Clase.CUPO.CUPO_7, Clase.TIPO.FUERZA_MAX);
		}
		catch(Exception e){
		fail("no permite crear una clase de 7");
	}}
	
	@Test
	public void testCupoValido14(){
		try{
			Clase curso= new Clase(Clase.CUPO.CUPO_14, Clase.TIPO.FUERZA_MAX);
		}
		catch(Exception e){
		fail("no permite crear una clase de 14");
	}}
	
	@Test
	public void testAgregarAlumno() throws Exception{
		Clase curso= new Clase(Clase.CUPO.CUPO_7, Clase.TIPO.FUERZA_MAX);
		int cant= curso.cantidadDeAlumnos();
		Alumno alu= new Alumno(null, null, null, null, cant, cant);
		curso.inscribir(alu);
		assertEquals("no incremento la cantidad",cant+1,curso.cantidadDeAlumnos());
		assertTrue("no se encontro al alumno en la lista de inscriptos",curso.estaInscripto(alu));
		Alumno alu2= new Alumno(null, null, null, null, cant, cant);
		assertFalse("aparece un alumno no inscripto", curso.estaInscripto(alu2));
	}
	
	@Test
	public void testNoPermitirAgregar8() throws Exception{
		Clase curso= new Clase(Clase.CUPO.CUPO_7, Clase.TIPO.FUERZA_MAX);
		for (int i = 0; i < 7; i++) {
			curso.inscribir(new Alumno(null, null, null, null, i, i));
		}
		try {
			curso.inscribir(new Alumno(null, null, null, null, 0, 0));
		} catch (Exception e) {
			return;
		}
		fail("permitio inscribir un 8° alumno");
	}
	
	//de aca es nuevo.
	@Test
	public void testEliminarUltimoAlumno() throws Exception{
		Clase curso= new Clase(Clase.CUPO.CUPO_7, Clase.TIPO.FUERZA_MAX);
		Alumno alu= new Alumno(null, null, null, null, 0, 0);
		curso.inscribir(alu);
		curso.desinscribir(alu);
		assertEquals("no quedo el curso vacio", 0,curso.cantidadDeAlumnos());
	}

	@Test
	public void testEliminarUnAlumno() throws Exception{
		Clase curso= new Clase(Clase.CUPO.CUPO_7, Clase.TIPO.FUERZA_MAX);
		Alumno alu1= new Alumno(null, null, null, null, 0, 0);
		Alumno alu2= new Alumno(null, null, null, null, 0, 0);
		Alumno alu3= new Alumno(null, null, null, null, 0, 0);
		curso.inscribir(alu1);
		curso.inscribir(alu3);
		curso.inscribir(alu2);
		int cant= curso.cantidadDeAlumnos();
		curso.desinscribir(alu3);
		assertEquals("no eliminó nada", cant-1,curso.cantidadDeAlumnos());
		assertFalse("no borró al que debia",curso.estaInscripto(alu3));
		assertTrue("borró uno equivocado",curso.estaInscripto(alu2));
		assertTrue("borró uno equivocado",curso.estaInscripto(alu1));
	}
	
	@Test
	public void testQueClaseEs() throws Exception{
		
		Clase curso1= new Clase(Clase.CUPO.CUPO_7, Clase.TIPO.FUERZA_MAX);
		assertTrue(curso1.getTipoClase()=="FUERZA_MAX");
		
		Clase curso2= new Clase(Clase.CUPO.CUPO_7, Clase.TIPO.RESISTENCIA);
		assertTrue(curso2.getTipoClase()=="RESISTENCIA");
		
		Clase curso3= new Clase(Clase.CUPO.CUPO_7, Clase.TIPO.NEURO_MUSCULAR);
		assertTrue(curso3.getTipoClase()=="NEURO_MUSCULAR");
		
	}
}
