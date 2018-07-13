package model.arvore;

public class PilhaNode extends ListaSequencial {
	
	private int tamanho;

	public PilhaNode() {
		super();
	}
	
	public PilhaNode(Node n) {
		super(n);
	}
	
	public void add(Node n) {
		this.lista.add(n);
		tamanho++;
	}
	
	public Node getNext() {
		if(tamanho == 0)
			return null;
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
