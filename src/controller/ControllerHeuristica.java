package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.exceptions.NodeJaExisteException;
import model.exceptions.NodeNotFoundException;
import model.exceptions.VerticeFinalNotFoundException;
import model.grafo.BuscaAEstrela;
import model.grafo.Grafo;
import model.grafo.Vertice;

public class ControllerHeuristica {
	
	private BuscaAEstrela buscaHeuristica;
	private static ControllerHeuristica instance = null;
	
	private ControllerHeuristica() {
		Grafo grafo = construirGrafoDaAula();
		HashMap<String, Integer> heurisitica = construirHeuristicaDaAula();
		buscaHeuristica = new BuscaAEstrela(grafo, heurisitica, grafo.getVertice("Bucharest"));
	}

	public static ControllerHeuristica getInstance() {
		if(instance == null)
			instance = new ControllerHeuristica();
		return instance;
	}
	
	public int busca(String nomeVertice) throws NodeNotFoundException, VerticeFinalNotFoundException {
		return buscaHeuristica.calcularCaminho(nomeVertice).size();
	}
	
	public ArrayList<Vertice> calcularCaminho(String nomeVertice) throws NodeNotFoundException, VerticeFinalNotFoundException {
		return buscaHeuristica.calcularCaminho(nomeVertice);
	}
	
	private Grafo construirGrafoDaAula() {
		Grafo grafo = new Grafo();
		
		try {
			grafo.addVertice("Arad");
			grafo.addVertice("Bucharest");
			grafo.addVertice("Craiova");
			grafo.addVertice("Dobreta");
			grafo.addVertice("Eforie");
			grafo.addVertice("Fagaras");
			grafo.addVertice("Giurgiu");
			grafo.addVertice("Hirsova");
			grafo.addVertice("Iasi");
			grafo.addVertice("Lugoj");
			grafo.addVertice("Mehadia");
			grafo.addVertice("Neamt");
			grafo.addVertice("Oradea");
			grafo.addVertice("Pitesti");
			grafo.addVertice("Rimnicu Vilcea");
			grafo.addVertice("Sibiu");
			grafo.addVertice("Timisoara");
			grafo.addVertice("Urziceni");
			grafo.addVertice("Vaslui");
			grafo.addVertice("Zerind");

			grafo.addArestaDupla("Arad", "Zerind", 75);
			grafo.addArestaDupla("Oradea", "Zerind", 71);
			grafo.addArestaDupla("Oradea", "Sibiu", 151);
			grafo.addArestaDupla("Fagaras", "Sibiu", 99);
			grafo.addArestaDupla("Fagaras", "Bucharest", 211);
			grafo.addArestaDupla("Urziceni", "Bucharest", 85);
			grafo.addArestaDupla("Urziceni", "Vaslui", 142);
			grafo.addArestaDupla("Iasi", "Vaslui", 92);
			grafo.addArestaDupla("Iasi", "Neamt", 92);
			grafo.addArestaDupla("Urziceni", "Hirsova", 98);
			grafo.addArestaDupla("Eforie", "Hirsova", 86);
			grafo.addArestaDupla("Giurgiu", "Bucharest", 90);
			grafo.addArestaDupla("Pitesti", "Bucharest", 101);
			grafo.addArestaDupla("Pitesti", "Rimnicu Vilcea", 97);
			grafo.addArestaDupla("Sibiu", "Rimnicu Vilcea", 80);
			grafo.addArestaDupla("Sibiu", "Arad", 140);
			grafo.addArestaDupla("Craiova", "Rimnicu Vilcea", 146);
			grafo.addArestaDupla("Craiova", "Pitesti", 138);
			grafo.addArestaDupla("Craiova", "Dobreta", 120);
			grafo.addArestaDupla("Mehadia", "Dobreta", 75);
			grafo.addArestaDupla("Mehadia", "Lugoj", 70);
			grafo.addArestaDupla("Timisoara", "Lugoj", 111);
			grafo.addArestaDupla("Timisoara", "Arad", 118);
		} catch (NodeJaExisteException | NodeNotFoundException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return grafo;
	}

	private HashMap<String, Integer> construirHeuristicaDaAula() {
		HashMap<String, Integer> heuristica = new HashMap<>();
		
		heuristica.put("Arad",366);
		heuristica.put("Bucharest",0);
		heuristica.put("Craiova",160);
		heuristica.put("Dobreta",242);
		heuristica.put("Eforie",161);
		heuristica.put("Fagaras",178);
		heuristica.put("Giurgiu",77);
		heuristica.put("Hirsova",151);
		heuristica.put("Iasi",226);
		heuristica.put("Lugoj",244);
		heuristica.put("Mehadia",241);
		heuristica.put("Neamt",234);
		heuristica.put("Oradea",380);
		heuristica.put("Pitesti",98);
		heuristica.put("Rimnicu Vilcea",193);
		heuristica.put("Sibiu",253);
		heuristica.put("Timisoara",329);
		heuristica.put("Urziceni",80);
		heuristica.put("Vaslui",199);
		heuristica.put("Zerind",374);
		
		return heuristica;
	}

}
