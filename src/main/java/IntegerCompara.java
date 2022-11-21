
public class IntegerCompara implements Compara<IntegerCompara>{
	public Integer dato;
	public IntegerCompara (int i){
		super();
		this.dato = Integer.valueOf (i);
	}
	public Integer getValor (){
		return this.dato;
	}

	public boolean mayorQue (IntegerCompara i1){
		return (this.dato > i1.dato);
	}
	public boolean menorQue (IntegerCompara i1){
		return (this.dato < i1.dato);
	}
	public boolean igualQue (IntegerCompara i1){
		return (this.dato == i1.dato);
	}
	public String toString(){
		return this.dato.toString();
	}
}
