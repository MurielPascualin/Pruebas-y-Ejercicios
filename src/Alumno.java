
public class Alumno {

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public void inscribir(Clase curso) throws Exception {
		curso.inscribir(this);		
	}

	public boolean estaInscripto(Clase curso) {
		return curso.estaInscripto(this);
	}
}
