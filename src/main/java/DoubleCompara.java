
public class DoubleCompara implements Compara<DoubleCompara> {

	public Double dato;

	public DoubleCompara (double d){
		super();
		this.dato = Double.valueOf (d);
	}
	public boolean mayorQue (DoubleCompara i1){
		return (this.dato > i1.dato);
	}
	public boolean menorQue (DoubleCompara i1){
		return (this.dato < i1.dato);
	}
	public boolean igualQue (DoubleCompara i1){
		return (this.dato == i1.dato);
	}
	public String toString(){
		return this.dato.toString();
	}
}
