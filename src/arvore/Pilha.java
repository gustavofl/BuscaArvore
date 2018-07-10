package arvore;

public class Pilha extends ListaSequencial {
	
	private int tamanho;

	public Pilha() {
		super();
	}
	
	public Pilha(Node n) {
		super(n);
	}
	
	public void add(Node n) {
		this.lista.add(n);
		tamanho++;
	}
	
	public Node getNext() {
		return this.lista.get(tamanho-1);
	}
	
	public Node pop() {
		Node last = this.getNext();
		this.lista.remove(--tamanho);
		return last;
	}
	
	@Override
	public String toString() {
		return "PILHA -> " + super.toString();
	}
}
