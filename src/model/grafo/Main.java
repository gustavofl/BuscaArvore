package model.grafo;

import model.exceptions.NodeJaExisteException;

public class Main {

	public static void main(String[] args) {
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
			grafo.addVertice("Pitest");
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
			grafo.addArestaDupla("Craiova", "Rimnicu Vilcea", 146);
			grafo.addArestaDupla("Craiova", "Pitesti", 138);
			grafo.addArestaDupla("Craiova", "Dobreta", 120);
			grafo.addArestaDupla("Mehadia", "Dobreta", 75);
			grafo.addArestaDupla("Mehadia", "Lugoj", 70);
			grafo.addArestaDupla("Timisoara", "Lugoj", 111);
			grafo.addArestaDupla("Timisoara", "Arad", 118);
		} catch (NodeJaExisteException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
