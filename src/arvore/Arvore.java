package arvore;

import java.util.ArrayList;

public class Arvore {
	
	private Node raiz;
	
	public Arvore(String nome) {
		this.raiz = new Node(nome);
	}
	
	public void show() {
	}
	
	public Node getNode(String nome) {
		ArrayList<Node> busca = buscaProfundidade(nome);
		if(busca.size() == 0)
			return null;
		if(ultimoElemento(busca).equals(new Node(nome)))
			return ultimoElemento(busca);
		return null;
	}

	public int buscaLarguraDist(String nome) {
		ArrayList<Node> busca = buscaLargura(nome);
		if(busca.size() == 0)
			return -1;
		if(ultimoElemento(busca).equals(new Node(nome)))
			return busca.size();
		return -1;
	}
	
	public ArrayList<Node> buscaLargura(String nome) {
		ArrayList<Node> busca = new ArrayList<>();
		buscaLarguraRecursiva(raiz, nome, busca);
		return busca;
	}

	private void buscaLarguraRecursiva(Node node, String nome, ArrayList<Node> pilha) {
		if(node.getPai() == null)
			pilha.add(node);
		
		for (Node filho : node.getFilhos()) {
			pilha.add(filho);
			if(filho.equals(new Node(nome)))
				return;
		}
		
		for (Node filho : node.getFilhos()) {
			if(!ultimoElemento(pilha).equals(new Node(nome)))
				buscaLarguraRecursiva(filho, nome, pilha);
		}
	}

	public int buscaProfundidadeDist(String nome) {
		ArrayList<Node> busca = buscaProfundidade(nome);
		if(busca.size() == 0)
			return -1;
		if(ultimoElemento(busca).equals(new Node(nome)))
			return busca.size();
		return -1;
	}
	
	public ArrayList<Node> buscaProfundidade(String nome){
		ArrayList<Node> busca = new ArrayList<>();
		buscaProfundidadeRecursiva(raiz, nome, busca);
		return busca;
	}

	private void buscaProfundidadeRecursiva(Node node, String nome, ArrayList<Node> pilha) {
		if(node.getNome().equals(nome)){
			pilha.add(node);
		} else {
			pilha.add(node);
			for (Node filho : node.getFilhos()) {
				if(!ultimoElemento(pilha).equals(new Node(nome)))
					buscaProfundidadeRecursiva(filho, nome, pilha);
			}
		}
	}
	
	private Node ultimoElemento(ArrayList<Node> lista){
		return lista.get(lista.size()-1);
	}

	public Node getRaiz() {
		return raiz;
	}

	public void setRaiz(Node raiz) {
		this.raiz = raiz;
	}

	private void printPilha(ArrayList<Node> pilha) {
		String saida = "";
		for (Node node : pilha) {
			saida += node.getNome() + ", ";
		}
		System.out.println(saida);
	}

}
