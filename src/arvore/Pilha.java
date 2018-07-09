package arvore;

import java.util.ArrayList;

public class Pilha {
	
	private ArrayList<Node> pilha;
	int tamanho;

	public Pilha() {
		this.pilha = new ArrayList<>();
		this.tamanho = 0;
	}
	
	public Pilha(Node n) {
		this();
		this.add(n);
	}
	
	public void add(Node n) {
		this.pilha.add(n);
		this.tamanho++;
	}
	
	public Node getLast() {
		return this.pilha.get(--this.tamanho);
	}
	
	public Node pop() {
		Node last = this.getLast();
		this.pilha.remove(this.tamanho);
		return last;
	}

}
