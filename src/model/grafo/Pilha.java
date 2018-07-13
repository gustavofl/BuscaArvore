package model.grafo;

public class Pilha extends ListaSequencial {
	
	private int tamanho;

	public Pilha() {
		super();
	}
	
	public Pilha(Vertice n) {
		super(n);
	}
	
	public void add(Vertice n) {
		this.lista.add(n);
		tamanho++;
	}
	
	public Vertice getNext() {
		if(tamanho == 0)
			return null;
		return this.lista.get(tamanho-1);
	}
	
	public Vertice pop() {
		Vertice last = this.getNext();
		this.lista.remove(--tamanho);
		return last;
	}
	
	@Override
	public String toString() {
		return "PILHA -> " + super.toString();
	}
}
