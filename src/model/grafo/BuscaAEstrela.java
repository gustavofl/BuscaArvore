package model.grafo;

import java.util.ArrayList;
import java.util.HashMap;

import model.exceptions.NodeNotFoundException;
import model.exceptions.VerticeFinalNotFoundException;

public class BuscaAEstrela {

	private Grafo grafo;
	private Vertice verticeFinal;
	private HashMap<String, Integer> heuristica;

	public BuscaAEstrela(Grafo grafo, HashMap<String, Integer> heuristica, Vertice verticeFinal) {
		this.grafo = grafo;
		this.heuristica = heuristica;
		this.verticeFinal = verticeFinal;
	}

	public BuscaAEstrela() {
		this(new Grafo(), new HashMap<>(), null);
	}
	
	public void addHeuristica(String vertice, int valor) throws NodeNotFoundException {
		if(! grafo.getVertices().contains(new Vertice(vertice)))
			throw new NodeNotFoundException(vertice);
		
		heuristica.put(vertice, valor);
	}
	
	public ArrayList<Vertice> calcularCaminho(String verticeInicio) throws NodeNotFoundException, VerticeFinalNotFoundException {
		if(! grafo.getVertices().contains(new Vertice(verticeInicio)))
			throw new NodeNotFoundException(verticeInicio);
		
		if(verticeFinal == null)
			throw new VerticeFinalNotFoundException();
		
		// Fila vizinhos = new Fila();
		Pilha resultado = new Pilha();
		ArrayList<Vertice> jaVisitados = new ArrayList<>();
		resultado.add(new Vertice(verticeInicio));
		
		buscaLarguraRecursiva(resultado, jaVisitados);
		
		return resultado.toArrayList();
	}

	// copiado de mode.arvore.Arvore
	private void buscaLarguraRecursiva(Pilha resultado, ArrayList<Vertice> jaVisitados) {
		if (resultado.getNext() == null || resultado.getNext().equals(verticeFinal))
			return;
		else {
			Vertice verticeAtual = resultado.getNext();
			jaVisitados.add(verticeAtual);
			int menorHeuristica = 0;
			Vertice nextVerticeHeuristica = null;
			Aresta vizinho = grafo.getVizinhos(verticeAtual);
			
			if(vizinho == null) return;
			
			while(vizinho != null) {
				if(! jaVisitados.contains(vizinho.getVertice()))
					if(nextVerticeHeuristica == null || heuristica.get(vizinho.getVertice().getNome())+vizinho.getPeso() < menorHeuristica){
						menorHeuristica = heuristica.get(vizinho.getVertice().getNome())+vizinho.getPeso();
						nextVerticeHeuristica = vizinho.getVertice();
					}
				
				vizinho = vizinho.getNext();
			}
			
			resultado.add(nextVerticeHeuristica);
			
			buscaLarguraRecursiva(resultado, jaVisitados);
		}
	}

	public Grafo getGrafo() {
		return grafo;
	}

	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}

	public HashMap<String, Integer> getHeuristica() {
		return heuristica;
	}

	public void setHeuristica(HashMap<String, Integer> heuristica) {
		this.heuristica = heuristica;
	}

}
