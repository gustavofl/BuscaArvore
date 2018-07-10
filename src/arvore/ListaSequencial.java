package arvore;

import java.util.ArrayList;

public abstract class ListaSequencial {
	
	protected ArrayList<Node> lista;

	public ListaSequencial() {
		this.lista = new ArrayList<>();
	}
	
	public ListaSequencial(Node n) {
		this();
		this.add(n);
	}
	
	public boolean empty(){
		return getTamanho() == 0;
	}
	
	public int getTamanho() {
		return lista.size();
	}
	
	public abstract void add(Node n);
	public abstract Node getNext();
	public abstract Node pop();

	public ArrayList<Node> toArrayList() {
		return lista;
	}

	public String toString() {
		String saida = "";
		for (Node node : lista) {
			saida += node.getNome() + ", ";
		}
		return saida;
	}

}
