
import java.time.LocalDate;

interface Compara <T> {
	boolean mayorQue (T o);
	boolean menorQue (T o);
	boolean igualQue (T o);
}

class Articulo implements Compara<Articulo>{
	private int id;
	private String titulo;
	
	public Articulo (int i, String t){
		this.id = i;
		this.titulo = t;
	}

	// La ordenaci�n implementada ser� por el atributo "id";
	public boolean mayorQue (Articulo a){
		return (this.id > a.id);
	}
	public boolean menorQue (Articulo a){
		return (this.id < a.id);
	}
	public boolean igualQue (Articulo a){
		return (this.id == a.id);
	}
	public String toString (){
		return ("El id del art�culo es " + this.id + "\n El t�tulo del mismo es " + this.titulo);
	}
}

class Usuario implements Compara<Usuario>{

	private String nombre;
	private String apellido;
	public Usuario (String n, String a){
		this.nombre = n;
		this.apellido = a;
	}

	// La ordenaci�n implementada ser� por orden lexicogr�fico primero en el atributo "apellido"
	// y luego (si el apellido coincide) en el atributo "nombre";
	public boolean mayorQue (Usuario u){
		return ((this.apellido.compareTo (u.apellido) > 0)
			 || ((this.apellido.compareTo (u.apellido) == 0) && (this.nombre.compareTo (u.nombre) > 0)));
	}
	public boolean menorQue (Usuario u){
		return ((this.apellido.compareTo (u.apellido) < 0)
			|| ((this.apellido.compareTo (u.apellido) == 0) && (this.nombre.compareTo (u.nombre) < 0)));
	}
	public boolean igualQue (Usuario u){
		return ((this.apellido.compareTo (u.apellido) == 0)
				&& (this.nombre.compareTo (u.nombre) == 0) );
	}
	public String toString (){
		return ("El apellido del usuario es " + this.apellido + "\n El nombre es " + this.nombre);
	}
}

class Prestamo implements Compara<Prestamo>{
	private Articulo ar;
	private Usuario us;
	private LocalDate fp; // atributo representando la fecha de pr�stamo

	public Prestamo (Articulo a, Usuario u, LocalDate f){
		this.ar = a;
		this.us = u;
		this.fp = f;
	}

	// La ordenaci�n implementada ser� por la ordenaci�n del atributo fecha de pr�stamo, "fp";
	// Haremos uso de los m�todos que ofrece la clase "java.util.Date" para comparar fechas
	public boolean mayorQue (Prestamo p){
		return (this.fp.compareTo (p.fp) > 0);
	}
	public boolean menorQue (Prestamo p){
		return (this.fp.compareTo (p.fp) < 0);
	}
	public boolean igualQue (Prestamo p){
		return (this.fp.compareTo (p.fp) == 0);
	}
	public String toString (){
		return ("La fecha del pr�stamo es " + this.fp.toString()
				+ "\n El usuario es " + this.us.toString()
					+ "\n El art�culo es " + this.ar.toString());
	}
}

