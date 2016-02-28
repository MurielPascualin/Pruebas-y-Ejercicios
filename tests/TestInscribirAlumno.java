import static org.junit.Assert.*;

import org.junit.Test;


public class TestInscribirAlumno {

	@Test
	public void testCrearNulo() {
		try{
		Alumno alu = new Alumno(null, null, null, null, 0, 0);
		}
		catch (Exception e){
			System.out.println("error1 al crear vacio: bien");
//			return;
		}
		try{
		Alumno alu = new Alumno("jose", null, null, "algo", 0, 0);
		}
		catch (Exception e){
			System.out.println("error2 al crear vacio: bien");
//			return;
		}
		try{
		Alumno alu = new Alumno(null, null, null, null, 0, 57);
		}
		catch (Exception e){
			System.out.println("error3 al crear vacio: bien");
			return;
		}
		fail("permitio crear nulo");
	}
	
	@Test
	public void testInscribirACurso(){ //esto ya lo testea curso		
	}

	@Test
	public void testInscribirEnClasesRepetidas() throws Exception{ //alumno sabe en que clases esta? para esto no se usaba la mierda del doble dispatch?
		Clase clase1=new Clase(Clase.CUPO.CUPO_7,Clase.TIPO.FUERZA_MAX);
		Clase clase2=new Clase(Clase.CUPO.CUPO_7,Clase.TIPO.FUERZA_MAX);
		Alumno alu=new Alumno("leia", "ap", "", "", 1, 2);
		clase1.inscribir(alu);
		clase2.inscribir(alu);
		assertFalse(clase1.estaInscripto(alu) && clase2.estaInscripto(alu)); //y aca me pregunto ¿es responsabilidad de la clase o del alumno? IMPORTA?
	}
	
	//FALTAN las validaciones de datos ¿se testea eso?
}
