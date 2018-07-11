package model.arvore;

public class Fila extends ListaSequencial {

	public Fila() {
		super();
	}
	
	public Fila(Node n) {
		super(n);
	}
	
	public void add(Node n) {
		this.lista.add(n);
	}
	
	public Node getNext() {
		if(getTamanho() == 0)
			return null;
		return this.lista.get(0);
	}
	
	public Node pop() {
		Node last = this.getNext();
		this.lista.remove(0);
		return last;
	}
	
	@Override
	public String toString() {
		return "FILA -> " + super.toString();
	}

}
