

import java.time.LocalDate;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

// Desarrollamos aquí un ejemplo que debería servir de inspiración para la práctica 04.03
// Por medio de la interfaz Comparator<T>, que es distinta de Compare,
// vamos a poder fijar varios criterios de comparación para una misma clase;
// en el ejemplo de debajo, ordenamos personas por sus ojos, edad o nombre,
// dependiendo de qué clase usemos:


enum Ojos {red, blue, green}

class Persona {
	protected String nombre;
	protected int edad;
	protected Ojos ojos;
	public Persona (String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
}

class PersonaPorOjos implements Comparator<Persona> {
	public int compare (Persona p1, Persona p2) {
		return (p1.ojos.compareTo(p2.ojos));
	}
}

class PersonaPorEdad implements Comparator<Persona> {
	public int compare (Persona p1, Persona p2) {
		return (p1.edad - p2.edad);
	}
}

class PersonaPorNombre implements Comparator<Persona> {
	public int compare (Persona p1, Persona p2) {
		return p1.nombre.compareTo (p2.nombre);
	}
}

// Recuperamos ahora las clases que implementan "Compara" para trabajar con listas

public class Principal {
	
	public static void main (String [] args){

		SortedSet<Persona> s1 = new TreeSet<> (new PersonaPorEdad());
		
		Articulo a1 = new Articulo (435, "El libro de la selva");
		Articulo a2 = new Articulo (127, "Una semana en el motor de un autobús");
		Articulo a3 = new Articulo (235, "Batiscafo Katiuskas");
		Articulo a4 = new Articulo (67, "La primera ópera envasada al vacío");
		Articulo a5 = new Articulo (500, "10 milles per veure una bona armadura");

		Usuario u1 = new Usuario ("Antonio", "Font");
		Usuario u2 = new Usuario ("Michael", "River");
		Usuario u3 = new Usuario ("Antonia", "Font");
		Usuario u4 = new Usuario ("Franz", "Kafka");
		Usuario u5 = new Usuario ("Franz", "Ferdinand");

		LocalDate d1 = LocalDate.now ();
		// A partir del momento actual d1, definimos 5 fechas cualesquiera en el pasado:
		LocalDate d2 = d1.plusDays (-7);
		LocalDate d3 = d1.plusDays (-12);
		LocalDate d4 = d1.plusDays (4);
		LocalDate d5 = d1.plusDays (-6);

		// nota que ahora disponemos de varias opciones para declarar nuestros objetos:
		Compara p1 = new Prestamo (a1, u1, d1);
		Compara<Prestamo> p2 = new Prestamo (a2, u2, d2);
		Prestamo p3 = new Prestamo (a3, u3, d3);
		Prestamo p4 = new Prestamo (a4, u4, d4);
		Prestamo p5 = new Prestamo (a5, u5, d5);
		
		// La siguiente orden produce un fallo de compilación; p1 es declarado "Compara", no "Prestamo"
		//p2.mayorQue (p1);

		// La siguiente orden también produce un fallo de compilación, p2 es "Compara<Prestamo>",
		// no "Prestamo"
		//p3.mayorQue (p2);

		// En el siguiente caso los tipos sí estarían bien declarados:
		p3.mayorQue (p4);

		// Ahora procedemos a incluirlos en Listas de cada tipo correspondiente:
		
		// Desde la versión 1.7 de Java, no es necesario 
		// especificar el tipo paramétrico en la construcción
		// Es el conocido como "operador diamante"
		
		Lista<Articulo> l1 = new Lista<>();
		Lista l1s = new Lista ();
		Lista<Articulo> l2 = new ListaOrdenada<> ();
		Lista<Usuario> l3 = new Lista<> ();
		Lista<Usuario> l4 = new ListaOrdenada<> ();
		Lista<Prestamo> l5 = new Lista<> ();
		Lista<Prestamo> l6 = new ListaOrdenada<> ();

		// Añadimos los artículos en una lista no ordenada:
		// La operación es válida tanto si la lista es genérica como si no
		l1.incluir (a1);
		l1s.incluir (a1);
		// Añadimos un Prestamo en una lista no ordenada:
		// La operación no es válida si la lista es genérica 
		// pero si lo es cuando no usamos Generics:
		//l1.incluir (p1);
		l1s.incluir (p1);
		l1.incluir (a2);
		l1.incluir (a3);
		l1.incluir (a4);
		l1.incluir (a5);

		// Añadimos los artículos en una lista ordenada por "id":
		l2.incluir (a1);
		l2.incluir (a2);
		l2.incluir (a3);
		l2.incluir (a4);
		l2.incluir (a5);

		// Añadimos los usuarios en una lista no ordenada:
		l3.incluir (u1);
		l3.incluir (u2);
		l3.incluir (u3);
		l3.incluir (u4);
		l3.incluir (u5);

		// Añadimos los usuarios en una lista ordenada por "apellido - nombre":
		l4.incluir (u1);
		l4.incluir (u2);
		l4.incluir (u3);
		l4.incluir (u4);
		l4.incluir (u5);

		// Añadimos los préstamos en una lista no ordenada;
		// Los primeros debemos "castearlos" porque no fueron declarados del tipo adecuado (Prestamo)
		l5.incluir ((Prestamo) p1);
		l5.incluir ((Prestamo) p2);
		l5.incluir (p3);
		l5.incluir (p4);
		l5.incluir (p5);

		// Añadimos los préstamos en una lista ordenada por fecha de préstamo;
		// Los primeros debemos "castearlos" porque no fueron declarados del tipo adecuado (Prestamo)
		l6.incluir ((Prestamo) p1);
		l6.incluir ((Prestamo) p2);
		l6.incluir (p3);
		l6.incluir (p4);
		l6.incluir (p5);

		System.out.println ("Esta es una lista de Artículos sin orden predefinido "
			+ "(dependerá del método incluir() en la clase Lista<Articulo>)");
		System.out.println (l1);
		System.out.println ("Esta es una lista de Artículos con orden predefinido "
			+ "(dependerá del método mayorQue() en la clase ListaOrdenada<Articulo>)");
		System.out.println (l2);
		System.out.println ("Esta es una lista de Usuarios sin orden predefinido "
			+ "(dependerá del método incluir() en la clase Lista<Usuario>)");
		System.out.println (l3);
		System.out.println ("Esta es una lista de Usuarios con orden predefinido "
			+ "(dependerá del método mayorQue() en la clase ListaOrdenada<Usuario>)");
		System.out.println (l4);
		System.out.println ("Esta es una lista de Prestamos sin orden predefinido "
			+ "(dependerá del método incluir() en la clase Lista<Prestamo>)");
		System.out.println (l5);
		System.out.println ("Esta es una lista de Prestamos con orden predefinido "
			+ "(dependerá del método mayorQue() en la clase ListaOrdenada<Prestamo>)");
		System.out.println (l6);
	}
}
