package model.grafo;

import java.util.ArrayList;
import java.util.HashMap;

import model.exceptions.NodeNotFoundException;

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
		if(! grafo.getVertices().contains(vertice))
			throw new NodeNotFoundException(vertice);
		
		heuristica.put(vertice, valor);
	}
	
	public ArrayList<Vertice> calcularCaminho(String verticeInicio) throws NodeNotFoundException, VerticeFinalNotFoundException {
		if(! grafo.getVertices().contains(verticeInicio))
			throw new NodeNotFoundException(verticeInicio);
		
		if(verticeFinal == null)
			throw new VerticeFinalNotFoundException();
		
		// Fila vizinhos = new Fila();
		Pilha resultado = new Pilha();
		ArrayList<Vertice> jaVisitados = new ArrayList<>();
		// vizinhos.add(new Vertice(verticeInicio));
		
		buscaLarguraRecursiva(resultado, jaVisitados);
		
		return resultado.toArrayList();
	}

	// copiado de mode.arvore.Arvore
	private void buscaLarguraRecursiva(Pilha resultado, ArrayList<Vertice> jaVisitados) {
		if (resultado.getNext().equals(verticeFinal))
			return;
		else {
			Vertice verticeAtual = resultado.getNext();
			jaVisitados.add(verticeAtual);
			int menorHeuristica = 0;
			Vertice nextVerticeHeuristica = null;
			Aresta vizinho = grafo.getVizinhos(verticeAtual);
			
			if(vizinho == null) return; //?
			
			while(vizinho != null) {
				if(jaVisitados.contains(vizinho)) continue;
				
				if(nextVerticeHeuristica == null || heuristica.get(vizinho)+vizinho.getPeso() < menorHeuristica){
					menorHeuristica = heuristica.get(vizinho)+vizinho.getPeso();
					nextVerticeHeuristica = vizinho.getVertice();
				}
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
