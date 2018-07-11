package model.grafo;

public class Vertice {

	private String nomeVertice;
	private Vertice adjacencia;

	public Vertice(String nomeVertice) {
		this.nomeVertice = nomeVertice;
	}

	public String getNomeVertice() {
		return nomeVertice;
	}

	public void setNomeVertice(String nomeVertice) {
		this.nomeVertice = nomeVertice;
	}

	public Vertice getAdjacencia() {
		return adjacencia;
	}

	public void setAdjacencia(Vertice adjacencia) {
		this.adjacencia = adjacencia;
	}

}
