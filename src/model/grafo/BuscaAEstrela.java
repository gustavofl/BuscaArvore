package model.grafo;

import java.util.HashMap;

import model.arvore.Fila;
import model.arvore.Node;
import model.arvore.Pilha;
import model.exceptions.NodeNotFoundException;

public class BuscaAEstrela {

	private Grafo grafo;
	private HashMap<String, Integer> heuristica;

	public BuscaAEstrela(Grafo grafo, HashMap<String, Integer> heuristica) {
		this.grafo = grafo;
		this.heuristica = heuristica;
	}

	public BuscaAEstrela() {
		this(new Grafo(), new HashMap<>());
	}
	
	public void addHeuristica(String vertice, int valor) throws NodeNotFoundException {
		if(! grafo.getVertices().contains(vertice))
			throw new NodeNotFoundException(vertice);
		
		heuristica.put(vertice, valor);
	}
	
	public void calcularCaminho(String vertice) throws NodeNotFoundException {
		if(! grafo.getVertices().contains(vertice))
			throw new NodeNotFoundException(vertice);
		
		// e agora? chama buscaLarguraRecursiva?
	}

	// copiado de mode.arvore.Arvore
	private void buscaLarguraRecursiva(String nome, Pilha resultado, Fila fila) {
		if (fila.empty())
			return;
		else {
			Node n = fila.pop();
			resultado.add(n);

			if (nome != null && n.getNome().equals(nome))
				return;

			for (Node f : n.getFilhos()) {
				fila.add(f);
			}
			buscaLarguraRecursiva(nome, resultado, fila);
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
