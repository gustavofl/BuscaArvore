package controller;

import java.util.ArrayList;

import model.arvore.Arvore;
import model.arvore.Node;
import model.exceptions.NodeJaExisteException;
import model.exceptions.NodeNotFoundException;
import model.exceptions.NomeInvalidoException;

public class ControllerArvore {
	
	private Arvore arvore;
	private static ControllerArvore instance = null;
	
	private ControllerArvore() {
		arvore = new Arvore();
	}
	
	public static ControllerArvore getInstance() {
		if(instance == null)
			instance = new ControllerArvore();
		return instance;
	}
	
	public void addNode(String nomePai, String nome) throws NomeInvalidoException, NodeJaExisteException, NodeNotFoundException {
		
		if(nome.equals("")) {
			throw new NomeInvalidoException();
		}
		
		// para add a raiz da arvore
		if(arvore.getRaiz() == null) {
			arvore.setRaiz(new Node(nome));
			if(nomePai != null)
				System.err.println("Raiz da arvore adicionada, nome do no pai ignorado.");
		}
		
		// para add um no filho
		else {
			if(nomePai == null)
				throw new NomeInvalidoException("pai");
			Node pai = arvore.getNode(nomePai);
			if(pai == null)
				throw new NodeNotFoundException(nomePai);
			else {
				if(arvore.getNode(nome) != null)
					throw new NodeJaExisteException(nome);
				else
					pai.addFilho(nome);
			}
		}
		
	}
	
	public void removerNode(String nome) {
		Node node = arvore.getNode(nome);
		
		if(node == null) return;
		
		if(node.equals(arvore.getRaiz())) {
			arvore.setRaiz(null);
			return;
		}
		
		node.getPai().removerFilho(node);
	}
	
	public void alterarNode(String nomeAtual, String novoNome, String novoPai) throws NomeInvalidoException, NodeJaExisteException {
		if(arvore.getNode(novoNome) != null && !nomeAtual.equals(novoNome))
			throw new NodeJaExisteException(novoNome);
		
		Node nodePai = arvore.buscaProfundidade(novoPai, nomeAtual).getNext();
		Node node = arvore.getNode(nomeAtual);
		node.setNome(novoNome);
		
		// verificar se o novo pai eh descendente do node (listar os nodes colocando o node atual como restricao e o novoPai como busca, se achar ta tudo bem!)
		if(nodePai == null)
			return;
		
		if(nodePai.equals(new Node(novoPai))) {
			node.getPai().removerFilho(node);
			node.setPai(nodePai);
			node.getPai().addFilhoExistente(node);
		} else {
			throw new NomeInvalidoException("pai");
		}
	}
	 
	public int buscaProfundidade(String nome) throws NodeNotFoundException {
		int custo = arvore.buscaProfundidadeCusto(nome);
		return custo;
	}
	
	public int buscaLargura(String nome) throws NodeNotFoundException {
		int custo = arvore.buscaLarguraCusto(nome);
		return custo;
	}
	
	public Node getNode(String nome) {
		return arvore.getNode(nome);
	}
	
	public ArrayList<Node> getListaNodes() {
		return arvore.buscaLargura(null).toArrayList();
	}
	
	public String[] toArrayString() {
		ArrayList<Node> listaNodes = getListaNodes();
		String[] arrayNomes = new String[listaNodes.size()];
		for (int i = 0; i < arrayNomes.length; i++) {
			arrayNomes[i] = listaNodes.get(i).getNome();
		}
		return arrayNomes;
	}
	
	public Arvore getArvore() {
		return arvore;
	}

	public ArrayList<Node> getListaNodesComRestricao(String nomeNode) {
		return arvore.buscaProfundidadeComRestricao(nomeNode);
	}

}
