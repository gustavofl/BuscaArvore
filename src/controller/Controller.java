package controller;

import arvore.Arvore;
import arvore.Node;

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
	
	public void addNode(Node node, String nome) {
		Node pai = arvore.getNode(node.getNome());
		if(pai == null)
			System.out.println("Nao existe um no com nome "+node.getNome()+" na arvore.");
		else
			pai.addFilho(nome);
	}

}
