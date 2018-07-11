package controller;

import java.util.ArrayList;

import model.Arvore;
import model.Node;
import model.Pilha;

public class Controller {
	
	private Arvore arvore;
	private static Controller instance = null;
	
	private Controller() {
		arvore = new Arvore();
	}
	
	public static Controller getInstance() {
		if(instance == null)
			instance = new Controller();
		return instance;
	}
	
	public void addNode(String nomePai, String nome) {
		
		if(nome.equals("")) {
			System.out.println("Nome invalido.");
			return;
		}
		
		// para add a raiz da arvore
		if(arvore.getRaiz() == null) {
			arvore.setRaiz(new Node(nome));
			if(nomePai != null)
				System.out.println("Raiz da arvore adicionada, nome do no pai ignorado.");
		}
		
		// para add um no filho
		else {
			if(nomePai == null)
				System.out.println("Nome do no pai invalido");
			Node pai = arvore.getNode(nomePai);
			if(pai == null)
				System.out.println("Nao existe um no com nome "+nomePai+" na arvore.");
			else {
				if(arvore.getNode(nome) != null)
					System.out.println("Já existe um no com o nome "+nome);
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
	
	public void alterarNode(String nomeAtual, String novoNome, String novoPai) {
		if(arvore.getNode(novoNome) != null && !nomeAtual.equals(novoNome)){
			System.out.println("Ja existe um no com o nome "+novoNome);
			return;
		}
		
		Node nodePai = arvore.buscaProfundidade(novoPai, nomeAtual).getNext();
		Node node = arvore.getNode(nomeAtual);
		node.setNome(novoNome);
		
		// verificar se o novo pai eh descendente do node (listar os nodes colocando o node atual como restricao e o novoPai como busca, se achar ta tudo bem!)
		if(nodePai != null && nodePai.equals(new Node(novoPai))) {
			node.getPai().removerFilho(node);
			node.setPai(nodePai);
			node.getPai().addFilhoExistente(node);
		} else {
			System.out.println("No pai invalido ou inexistente.");
		}
	}
	 
	public int buscaProfundidade(String nome) {
		int custo = arvore.buscaProfundidadeCusto(nome);
		if(custo == -1)
			System.out.println("No nao encontrado");
		return custo;
	}
	
	public int buscaLargura(String nome) {
		int custo = arvore.buscaLarguraCusto(nome);
		if(custo == -1)
			System.out.println("No nao encontrado");
		return custo;
	}
	
	public Node getNode(String nome) {
		return arvore.getNode(nome);
	}
	
	public void updateNode(String nome, String novoNome, String novoPai) {
		Node node = arvore.getNode(nome);
		if(node == null) System.out.println("No nao encontrado");
		
		if(nome.equals(novoNome) && node.getPai().getNome().equals(novoPai))
			return;
		
		node.setNome(novoNome);
		// falta atualizar o pai
		// ver uma forma de nao causar CICLO, ie, o node ser filho de seu descendente
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
