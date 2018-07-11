package model;

import java.util.ArrayList;

public class Node {
	
	private String nome;
	private Node pai;
	private ArrayList<Node> filhos;
	
	public Node(String nome) {
		this.nome = nome;
		this.filhos = new ArrayList<>();
	}
	
	public Node addFilho(String nome) {
		Node node = new Node(nome);
		this.filhos.add(node);
		node.setPai(this);
		return node;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Node getPai() {
		return pai;
	}

	public void setPai(Node pai) {
		this.pai = pai;
	}

	public ArrayList<Node> getFilhos() {
		return filhos;
	}

	public void setFilhos(ArrayList<Node> filhos) {
		this.filhos = filhos;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Node))
			return false;
		Node node = (Node) obj;
		return node.getNome().equals(this.nome);
	}

	public void removerFilho(Node node) {
		filhos.remove(node);
	}

	public void addFilhoExistente(Node node) {
		filhos.add(node);
	}

}
