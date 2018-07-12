package model.grafo;

public class Aresta {

	private Aresta next;
	private String vertice;
	private int peso;

	public Aresta(Aresta next, String vertice, int peso) {
		this.next = next;
		this.vertice = vertice;
		this.peso = peso;
	}

	public Aresta(String vertice, int peso) {
		this(null, vertice, peso);
	}

	public Aresta getNext() {
		return next;
	}

	public void setNext(Aresta next) {
		this.next = next;
	}

	public String getVertice() {
		return vertice;
	}

	public void setVertice(String vertice) {
		this.vertice = vertice;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}
