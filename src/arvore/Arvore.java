package arvore;

import java.util.ArrayList;

public class Arvore {

	private Node raiz;

	public Arvore(String nome) {
		this.raiz = new Node(nome);
	}
	
	public Arvore() {
		this.raiz = null;
	}

	public Node getNode(String nome) {
		Pilha busca = buscaProfundidade(nome);
		if (busca.empty())
			return null;
		if (busca.getNext().getNome().equals(nome))
			return busca.getNext();
		return null;
	}

	// BUSCA LARGURA
	public int buscaLarguraCusto(String nome) {
		Pilha busca = buscaLargura(nome);
		if (busca.empty())
			return -1;
		if (busca.getNext().equals(new Node(nome))) {
			return busca.getTamanho();
		}
		return -1;
	}

	public Pilha buscaLargura(String nome) {
		Pilha resultado = new Pilha();
		
		if(raiz == null) return resultado;
		
		Fila fila = new Fila(raiz);
		buscaLarguraRecursiva(nome, resultado, fila);
		return resultado;
	}

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

	// BUSCA PROFUNDIDADE
	public int buscaProfundidadeCusto(String nome) {
		Pilha busca = buscaProfundidade(nome);
		if (busca.empty())
			return -1;
		if (busca.getNext().equals(new Node(nome)))
			return busca.getTamanho();
		return -1;
	}

	public Pilha buscaProfundidade(String nome) {
		Pilha resultado = new Pilha();
		
		if(raiz == null) return resultado;
		
		buscaProfundidadeRecursiva(raiz, nome, resultado);
		return resultado;
	}

	public ArrayList<Node> buscaProfundidade() {
		return buscaProfundidade(null).toArrayList();
	}

	private void buscaProfundidadeRecursiva(Node node, String nome, Pilha resultado) {
		if (node.getNome().equals(nome)) {
			resultado.add(node);
		} else {
			resultado.add(node);
			for (Node filho : node.getFilhos()) {
				if (nome == null || !resultado.getNext().getNome().equals(nome))
					buscaProfundidadeRecursiva(filho, nome, resultado);
			}
		}
	}

	public Node getRaiz() {
		return raiz;
	}

	public void setRaiz(Node raiz) {
		this.raiz = raiz;
	}

}
