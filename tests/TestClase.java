import static org.junit.Assert.*;

import org.junit.Test;


public class TestClase {

	@Test
	public void testCupoInvalido() {
		try{
		Clase curso = new Clase(null);
		}
		catch (Exception e){
			System.out.println("anduvo");
			return;
		}
		fail("permitio crear clase de 4");
	}
	
	@Test
	public void testCupoValido7(){
		try{
			Clase curso= new Clase(Clase.CUPO.CUPO_7);
		}
		catch(Exception e){
		fail("no permite crear una clase de 7");
	}}
	
	@Test
	public void testCupoValido14(){
		try{
			Clase curso= new Clase(Clase.CUPO.CUPO_14);
		}
		catch(Exception e){
		fail("no permite crear una clase de 14");
	}}
	
	@Test
	public void testAgregarAlumno() throws Exception{
		Clase curso= new Clase(Clase.CUPO.CUPO_7);
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
		Clase curso= new Clase(Clase.CUPO.CUPO_7);
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
	
	@Test
	private void testEliminarAlumno(){
		
	}
}
