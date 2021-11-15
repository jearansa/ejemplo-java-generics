
public class ListaOrdenada<T extends Compara> extends Lista<T>{

	public ListaOrdenada (){
		super();
	}

	public boolean incluir (T c){
		boolean aux = (this.lon < 500);
		// Cogemos el primer elemento de la lista; podr�a ser null
		T aux2 = (T) this.v[0];
		// Si c no es null busco su posici�n con el while
		// Podemos usar menorQue o mayorQue para ordenarla de distinta forma
		int i = 0;
		while (aux2 != null && c.mayorQue (aux2)){
			i++;
			aux2 = (T) this.v[i];
		}
		// Desde el final del vector hasta la posici�n i muevo los elementos
		// una posici�n m�s arriba
		for (int j = this.lon; j > i; j--)
			this.v [j] = this.v [j - 1];
		// En la posici�n i quedar� "un hueco" para c
		this.v [i] = c;
		// Sumamos uno a lon
		if (aux) {this.lon++;}
		return aux;
	}
}