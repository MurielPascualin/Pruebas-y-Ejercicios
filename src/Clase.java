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
	enum TIPO{
		FUERZA_MAX, RESISTENCIA, NEURO_MUSCULAR;
		}
	
	private List<Alumno> listaAlumnos;
	private CUPO cupoMax;
	private TIPO tipoClase;

	
	public Clase(CUPO c, TIPO t) throws Exception {
		cupoMax= c;
		tipoClase= t;
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

	public void desinscribir(Alumno alu) throws Exception {
		if (cantidadDeAlumnos()==0) throw new Exception("curso vacio");
		if (!estaInscripto(alu)) throw new Exception("ese alumno no pertenece al curso");
		listaAlumnos.remove(alu);
	}

	public String getTipoClase(){
		return tipoClase.toString();
	}
}
