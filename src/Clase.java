import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;


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
	enum DIA{
		lunes,martes,miercoles,jueves,viernes,sabado;
	}
	enum HORA{
		h06,h07,h08,h09,h10,h11,h12,h13,h14,h15,h16,h17,h18,h19,h20,h21,h22,h23
	}
	
	private List<Alumno> listaAlumnos;
	private CUPO cupoMax;
	private TIPO tipoClase;

	
	public Clase(CUPO c, TIPO t) throws Exception {
		cupoMax= c;
		if (t!=null) tipoClase= t;
		else throw new Exception("no puede ser nulo");
		listaAlumnos= new ArrayList<Alumno>(cupoMax.cupo());
	}

	
	public int cantidadDeAlumnos() {
		return listaAlumnos.size();
	}

	void inscribir(Alumno alu) throws Exception {
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
