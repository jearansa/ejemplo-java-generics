


public class Lista <T extends Compara> {
	protected int lon;
	protected Compara [] v;

	public Lista(){
		this.lon = 0;
		this.v = new Compara [500];
	}
	public boolean incluir (T c){
		boolean aux = (this.lon < 500);
		if (aux) {
			this.v [this.lon] = c;
			this.lon++;
		}
		return aux;
	}
	public T elementoEn (int i){
		T c = null;
		if (0 <= i && i < this.lon)
			c = (T) this.v [i];
		return c;
	}
	public boolean eliminar (T c){
		boolean aux = false;
		// Primero buscamos el elemento
		int i;
		for (i = 0; i < this.lon && !aux; i++){
			aux = this.v [i].igualQue (c);
		}
		// Uso el valor de i al salir, muevo todos los elementos uno para atrás
		for (int j = i; j < this.lon; j++){
			this.v [j-1] = this.v [j];
		}
		// Si lo hemos encontrado, reducimos en uno la longitud de la lista:
		if (aux) {this.lon--;}
		return aux;
	}
	public String toString (){
		StringBuilder n = new StringBuilder ("La longitud de la lista es " + this.lon + "\n");
		for (int i = 0; i < this.lon; i++){
			n.append (this.v [i] + "\n");
		}
		return n.toString();
	}
}
