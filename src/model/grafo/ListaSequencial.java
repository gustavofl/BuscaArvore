package model.grafo;

import java.util.ArrayList;

public abstract class ListaSequencial {
	
	protected ArrayList<Vertice> lista;

	public ListaSequencial() {
		this.lista = new ArrayList<>();
	}
	
	public ListaSequencial(Vertice v) {
		this();
		this.add(v);
	}
	
	public boolean empty(){
		return getTamanho() == 0;
	}
	
	public int getTamanho() {
		return lista.size();
	}
	
	public abstract void add(Vertice v);
	public abstract Vertice getNext();
	public abstract Vertice pop();

	public ArrayList<Vertice> toArrayList() {
		return lista;
	}

	public String toString() {
		String saida = "";
		for (Vertice Vertice : lista) {
			saida += Vertice.getNome() + ", ";
		}
		return saida;
	}

}
