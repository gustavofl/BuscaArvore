package model.grafo;

public class Fila extends ListaSequencial {

	public Fila() {
		super();
	}
	
	public Fila(Vertice n) {
		super(n);
	}
	
	public void add(Vertice n) {
		this.lista.add(n);
	}
	
	public Vertice getNext() {
		if(getTamanho() == 0)
			return null;
		return this.lista.get(0);
	}
	
	public Vertice pop() {
		Vertice last = this.getNext();
		this.lista.remove(0);
		return last;
	}
	
	@Override
	public String toString() {
		return "FILA -> " + super.toString();
	}

}
