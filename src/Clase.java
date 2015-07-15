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
		TIPO_1(1),TIPO_2(2),TIPO_3(3);
		private int tipo;
		public int tipo() {
			return tipo;
		}
		private TIPO(int i) {
			tipo=i;
		}
	}
	private List<Alumno> listaAlumnos;
	private CUPO cupoMax;
	private TIPO tipoCurso;

	public Clase(CUPO c, TIPO t) {
		If 
		cupoMax= c;
		listaAlumnos= new ArrayList<Alumno>(cupoMax.cupo());
		tipoCurso=t;
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


	public TIPO verTipo() {
		return tipoCurso;
	}

}
