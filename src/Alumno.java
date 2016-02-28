import java.util.ArrayList;


public class Alumno {
	
	private String nombre;
	private String apellido;
	private String mail;
	private String tel;
	private int fechaNac;
	private int fechaIngreso;
//	private Clase claseDeFuerza=null;
//	private Clase claseDeResistencia=null;
//	private Clase claseDeNeuro=null;
	
	public Alumno(){
		
	}

	public Alumno(String n, String a, String c, String t, int fNac, int fIngreso) throws Exception {
		boolean hayError=true;
		if (n!=null) {
			nombre=n;
			if(a!=null){
				apellido=a;
				if(c!=null){
					mail=c;
					if(t!=null){
						tel=t;
						if(fNac!=0){
							fechaNac=fNac;
							if(fIngreso!=0){
								fechaIngreso=fIngreso;
								hayError=false;
							}
						}
					}
				}
			}
		}
		if(hayError)throw new RuntimeException();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public void inscribir(Clase curso) throws Exception {
		//aca verificar que no esete la clase en el mapa de clases
		curso.inscribir(this);		
	}

	public boolean estaInscripto(Clase curso) {
		return curso.estaInscripto(this);
	}
}
