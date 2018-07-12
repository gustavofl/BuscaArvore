package model.grafo;

import java.util.ArrayList;

import model.exceptions.NodeJaExisteException;

public class Grafo {

	private ArrayList<String> vertices;
	private ArrayList<Aresta> listaAdj;

	public Grafo(ArrayList<String> vertices, ArrayList<Aresta> listaAdj) {
		this.vertices = vertices;
		this.listaAdj = listaAdj;
	}

	public Grafo() {
		this.vertices = new ArrayList<>();
		this.listaAdj = new ArrayList<>();
	}
	
	public void addVertice(String nome) throws NodeJaExisteException {
		if(vertices.contains(nome))
			throw new NodeJaExisteException(nome);
		
		vertices.add(nome);
	}
	
	public void addAresta(String vertice1, String vertice2, int peso) {
		int indiceVertice1 = vertices.indexOf(vertice1);
		
		Aresta aresta = listaAdj.get(indiceVertice1);
		if(aresta == null)
			listaAdj.set(indiceVertice1, new Aresta(vertice2, peso));
		else {
			while(aresta.getNext() != null)
				aresta = aresta.getNext();
			aresta.setNext(new Aresta(vertice2, peso));
		}
	}
	
	public void addArestaDupla(String vertice1, String vertice2, int peso) {
		addAresta(vertice1, vertice2, peso);
		addAresta(vertice2, vertice1, peso);
	}
	
	public ArrayList<String> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<String> vertices) {
		this.vertices = vertices;
	}

	public ArrayList<Aresta> getListaAdj() {
		return listaAdj;
	}

	public void setListaAdj(ArrayList<Aresta> listaAdj) {
		this.listaAdj = listaAdj;
	}

}
