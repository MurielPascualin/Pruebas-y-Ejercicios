import java.util.ArrayList;
import java.util.List;


public class Clase {
	enum CUPO{
		CUPO_7(7), CUPO_14(14);
		private int cupo;
		public int cupo() {
			return cupo;
		}
		private CUPO(int c) {
			cupo=c;
		}
	}
	private List<Alumno> listaAlumnos;
	private CUPO cupoMax;

	public Clase(CUPO c) throws Exception {
		cupoMax= c;
		listaAlumnos= new ArrayList<Alumno>(cupoMax.cupo());
	}

	public int cantidadDeAlumnos() {
		return listaAlumnos.size();
	}

	public void inscribir(Alumno alu) throws Exception {
		if (cantidadDeAlumnos()==cupoMax.cupo()) throw new Exception("la clase esta llena");
		listaAlumnos.add(alu);
	}

	public boolean estaInscripto(Alumno alu) {
		return listaAlumnos.contains(alu);
	}

}
