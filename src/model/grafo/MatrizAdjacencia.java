package model.grafo;

import java.util.ArrayList;

public class MatrizAdjacencia {

	private ArrayList<String> listaNodes;
	private int[][] matriz;
	private int tamanho;
	
	public MatrizAdjacencia(ArrayList<String> listaNodes) {
		this.listaNodes = listaNodes;
		this.tamanho = listaNodes.size();
		construirMatriz();
	}
	
	private void construirMatriz() {
		for (int i = 0; i < listaNodes.size(); i++) {
			for (int j = 0; j < listaNodes.size(); j++) {
				matriz[i][j] = 0;
			}
		}
	}
	
	public void addAresta(String nodeInicio, String nodeFinal, int peso) {
		int indexInicio = listaNodes.indexOf(nodeInicio);
		int indexFinal = listaNodes.indexOf(nodeFinal);
		matriz[indexInicio][indexFinal] = peso;
	}
	
	public void addArestaDupla(String nodeInicio, String nodeFinal, int peso) {
		addAresta(nodeInicio, nodeFinal, peso);
		addAresta(nodeFinal, nodeInicio, peso);
	}

}
