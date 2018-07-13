package model.grafo;

public class Vertice {

	private String nome;

	public Vertice(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Vertice))
			return false;
		Vertice v = (Vertice) obj;
		return v.getNome().equals(nome);
	}

}
