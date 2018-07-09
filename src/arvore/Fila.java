package arvore;

import java.util.ArrayList;

public class Fila {
	
	private ArrayList<Node> pilha;

	public Fila() {
		this.pilha = new ArrayList<>();
	}
	
	public Fila(Node n) {
		this();
		this.add(n);
	}
	
	public void add(Node n) {
		this.pilha.add(n);
	}
	
	public Node getLast() {
		return this.pilha.get(0);
	}
	
	public Node pop() {
		Node last = this.getLast();
		this.pilha.remove(0);
		return last;
	}

}
