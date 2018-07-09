package arvore.java2d;

import java.awt.Graphics;
import java.util.ArrayList;

import arvore.Node;

public class Div implements Desenhavel {
	private Coordenada coord;
	private ArrayList<Div> filhos;
	private ArrayList<Linha> ligacoes;
	private Desenhavel pai;
	private Node2D node;

	public Div(Desenhavel pai, Node node) {
		this.coord = new Coordenada();
		this.filhos = new ArrayList<>();
		this.ligacoes = new ArrayList<>();
		this.pai = pai;
		construirRecursivo(node);
	}

	public void construirRecursivo(Node node) {
		this.node = new Node2D(this, node.getNome());
		for (Node f : node.getFilhos()) {
			Div novaDiv = new Div(this, f);
			this.filhos.add(novaDiv);
			this.ligacoes.add(new Linha(this, this.node, novaDiv.getNode()));
		}
	}

	@Override
	public void desenhar(Graphics g) {
		for (Linha linha : ligacoes)
			linha.desenhar(g);
		
		node.desenhar(g);

		for (Div f : filhos)
			f.desenhar(g);
	}

	@Override
	public Coordenada calcular() {
		Coordenada coordNode = node.calcular();
		this.coord.setHeight(coordNode.getHeight() + 2 * PADY);
		this.coord.setWidth(coordNode.getWidth() + 2 * PADX);

		// calcular a posicao dos filhos
		int somaLargFilhos = 0;
		int alturaAtual = this.coord.getHeight();
		int novaAltura, padx, pady;

		if (filhos.size() == 1) {
			padx = 0;
			pady = 0;
		} else {
			padx = PADX;
			pady = PADY;
		}

		for (Div f : filhos) {
			f.getCoord().setX(this.coord.getX() + somaLargFilhos + padx);
			f.getCoord().setY(this.coord.getY() + this.coord.getHeight() + pady);
			f.calcular();
			somaLargFilhos += 2 * padx + f.getCoord().getWidth();
			novaAltura = this.coord.getHeight() + f.getCoord().getHeight() + 2 * padx;
			if (novaAltura > alturaAtual)
				alturaAtual = novaAltura;
		}
		this.coord.setHeight(alturaAtual);
		if (somaLargFilhos > this.coord.getWidth())
			this.coord.setWidth(somaLargFilhos);

		// calcular a posicao do node (CENTRO/TOPO)
		int centroHorizontal;
		if (filhos.size() == 0)
			centroHorizontal = this.coord.getX() + coord.getWidth() / 2;
		else {
			int inicioPrimeiroFilho = filhos.get(0).getNode().getCoord().getX();
			Node2D ultimoFilho = filhos.get(filhos.size() - 1).getNode();
			int finalUltimoFilho = ultimoFilho.getCoord().getX() + ultimoFilho.getCoord().getWidth();
			centroHorizontal = (inicioPrimeiroFilho + finalUltimoFilho) / 2;
		}
		coordNode.setX(centroHorizontal - coordNode.getWidth() / 2);
		coordNode.setY(this.coord.getY() + PADY);
		
		// calcular as coordenadas das linhas
		for (Linha linha : ligacoes)
			linha.calcular();
		
		return this.coord;
	}

	@Override
	public Desenhavel getPai() {
		return this.pai;
	}

	public Coordenada getCoord() {
		return coord;
	}

	public void setCoord(Coordenada coord) {
		this.coord = coord;
	}

	public ArrayList<Div> getFilhos() {
		return filhos;
	}

	public void setFilhos(ArrayList<Div> filhos) {
		this.filhos = filhos;
	}

	public Node2D getNode() {
		return node;
	}

	public void setNode(Node2D node) {
		this.node = node;
	}

	public void setPai(Desenhavel pai) {
		this.pai = pai;
	}
}
