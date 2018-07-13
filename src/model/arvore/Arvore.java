package model.arvore;

import java.util.ArrayList;

import model.exceptions.NodeNotFoundException;

public class Arvore {

	private Node raiz;

	public Arvore(String nome) {
		this.raiz = new Node(nome);
	}
	
	public Arvore() {
		this.raiz = null;
	}

	public Node getNode(String nome) {
		PilhaNode busca = buscaProfundidade(nome);
		if (busca.empty())
			return null;
		if (busca.getNext().getNome().equals(nome))
			return busca.getNext();
		return null;
	}

	// BUSCA LARGURA
	public int buscaLarguraCusto(String nome) throws NodeNotFoundException {
		PilhaNode busca = buscaLargura(nome);
		if (busca.empty())
			throw new NodeNotFoundException();
		if (busca.getNext().equals(new Node(nome))) {
			return busca.getTamanho();
		}
		throw new NodeNotFoundException();
	}

	public PilhaNode buscaLargura(String nome) {
		PilhaNode resultado = new PilhaNode();
		
		if(raiz == null) return resultado;
		
		FilaNode fila = new FilaNode(raiz);
		buscaLarguraRecursiva(nome, resultado, fila);
		return resultado;
	}

	private void buscaLarguraRecursiva(String nome, PilhaNode resultado, FilaNode fila) {
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
	public int buscaProfundidadeCusto(String nome) throws NodeNotFoundException {
		PilhaNode busca = buscaProfundidade(nome);
		if (busca.empty())
			throw new NodeNotFoundException();
		if (busca.getNext().equals(new Node(nome)))
			return busca.getTamanho();
		throw new NodeNotFoundException();
	}

	public PilhaNode buscaProfundidade(String nomeNodeBusca, String nomeNodeRestricao) {
		PilhaNode resultado = new PilhaNode();
		
		if(raiz == null) return resultado;
		
		Node nodeBusca = null;
		if(nomeNodeBusca != null) nodeBusca = new Node(nomeNodeBusca);
		
		Node nodeRestricao = null;
		if(nomeNodeRestricao != null) nodeRestricao = new Node(nomeNodeRestricao);
		
		buscaProfundidadeRecursiva(raiz, nodeBusca, nodeRestricao, resultado);
		return resultado;
	}
	
	public PilhaNode buscaProfundidade(String nomeNodeBusca) {
		return buscaProfundidade(nomeNodeBusca, null);
	}

	public ArrayList<Node> buscaProfundidadeComRestricao(String nomeNode) {
		return buscaProfundidade(null, nomeNode).toArrayList();
	}

	public ArrayList<Node> buscaProfundidade() {
		return buscaProfundidade(null, null).toArrayList();
	}

	private void buscaProfundidadeRecursiva(Node node, Node busca, Node restricao, PilhaNode resultado) {
		if (node.equals(busca)) {
			resultado.add(node);
		} else {
			if(node.equals(restricao)) return;
			
			resultado.add(node);
			for (Node filho : node.getFilhos()) {
				if (!resultado.getNext().equals(busca))
					buscaProfundidadeRecursiva(filho, busca, restricao, resultado);
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
