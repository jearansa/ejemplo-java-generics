
public class StringCompara implements Compara<StringCompara> {
	public String dato;
	public StringCompara (String i){
		super();
		this.dato = i;
	}
	public boolean mayorQue (StringCompara i1){
		return (this.dato.compareTo(i1.dato) > 0);
	}
	public boolean menorQue (StringCompara i1){
		return (this.dato.compareTo(i1.dato) < 0);
	}
	public boolean igualQue (StringCompara i1){
		return (this.dato.compareTo(i1.dato) == 0);
	}
	public String toString(){
		return this.dato.toString();
	}
}


