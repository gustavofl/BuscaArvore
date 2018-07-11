package controller;

import java.util.ArrayList;

import arvore.Arvore;
import arvore.Node;
import arvore.java2d.DesenharArvore;

public class Controller {
	
	private Arvore arvore;
	private static Controller instance = null;
	private DesenharArvore tela;
	
	private Controller() {
		arvore = new Arvore();
	}
	
	public static Controller getInstance() {
		if(instance == null)
			instance = new Controller();
		return instance;
	}
	
	public void addNode(String nomePai, String nome) {
		
		// para add a raiz da arvore
		if(arvore.getRaiz() == null) {
			arvore.setRaiz(new Node(nome));
			if(nomePai != null) {
				System.out.println("Raiz da arvore adicionada, nome do no pai ignorado.");
				tela = new DesenharArvore(arvore);
			}
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
		
		tela.repaint();
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
	
	public void closeTela() {
		tela.dispose();
	}

}
