package model.grafo;

public class Aresta {

	private Aresta next;
	private Vertice vertice;
	private int peso;

	public Aresta(Aresta next, Vertice vertice, int peso) {
		this.next = next;
		this.vertice = vertice;
		this.peso = peso;
	}

	public Aresta(Vertice vertice, int peso) {
		this(null, vertice, peso);
	}

	public Aresta getNext() {
		return next;
	}

	public void setNext(Aresta next) {
		this.next = next;
	}

	public Vertice getVertice() {
		return vertice;
	}

	public void setVertice(Vertice vertice) {
		this.vertice = vertice;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}
