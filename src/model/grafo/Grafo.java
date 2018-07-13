package model.grafo;

import java.util.ArrayList;

import model.exceptions.NodeJaExisteException;
import model.exceptions.NodeNotFoundException;

public class Grafo {

	private ArrayList<Vertice> vertices;
	private ArrayList<Aresta> listaAdj;

	public Grafo(ArrayList<Vertice> vertices, ArrayList<Aresta> listaAdj) {
		this.vertices = vertices;
		this.listaAdj = listaAdj;
	}

	public Grafo() {
		this.vertices = new ArrayList<>();
		this.listaAdj = new ArrayList<>();
	}
	
	public void addVertice(String nome) throws NodeJaExisteException {
		if(vertices.contains(new Vertice(nome)))
			throw new NodeJaExisteException(nome);
		
		vertices.add(new Vertice(nome));
		listaAdj.add(null);
	}
	
	public void addAresta(String vertice1, String vertice2, int peso) throws NodeNotFoundException {
		int indiceVertice1 = vertices.indexOf(new Vertice(vertice1));
		
		if(indiceVertice1 == -1) throw new NodeNotFoundException(vertice1);
		
		Vertice v2 = vertices.get(vertices.indexOf(new Vertice(vertice2)));
		
		Aresta aresta = listaAdj.get(indiceVertice1);
		if(aresta == null)
			listaAdj.set(indiceVertice1, new Aresta(v2, peso));
		else {
			while(aresta.getNext() != null)
				aresta = aresta.getNext();
			aresta.setNext(new Aresta(v2, peso));
		}
	}
	
	public int calcularCustoCaminho(ArrayList<Vertice> caminho) {
		int custo = 0;
		if(vertices != null && caminho.size() > 1) {
			for (int i = 1; i < caminho.size(); i++) {
				int indexVertice = vertices.indexOf(caminho.get(i-1));
				Aresta a = listaAdj.get(indexVertice);
				while(a != null) {
					if(a.getVertice().equals(caminho.get(i))){
						custo += a.getPeso();
						break;
					}
					a = a.getNext();
				}
			}
		}
		return custo;
		
	}
	
	public void addArestaDupla(String vertice1, String vertice2, int peso) throws NodeNotFoundException {
		addAresta(vertice1, vertice2, peso);
		addAresta(vertice2, vertice1, peso);
	}
	
	public Aresta getVizinhos(Vertice v) {
		return listaAdj.get(vertices.indexOf(v));
	}

	public ArrayList<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}

	public ArrayList<Aresta> getListaAdj() {
		return listaAdj;
	}

	public void setListaAdj(ArrayList<Aresta> listaAdj) {
		this.listaAdj = listaAdj;
	}

	public Vertice getVertice(String nomeVertice) {
		return vertices.get(vertices.indexOf(new Vertice(nomeVertice)));
	}

}
