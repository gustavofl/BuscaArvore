package gui.java2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Linha implements Desenhavel {
	
	private Node2D node1, node2;
	private Coordenada coord;
	private Desenhavel pai;

	public Linha(Desenhavel pai, Node2D node1, Node2D node2) {
		this.pai = pai;
		this.node1 = node1;
		this.node2 = node2;
	}

	@Override
	public void desenhar(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(coord.getX(), coord.getY(), coord.getX()+coord.getWidth(), coord.getY()+coord.getHeight());
	}

	@Override
	public Coordenada calcular() {
		int x1,x2,y1,y2;
		x1 = node1.getCoord().getX()+node1.getCoord().getWidth()/2;
		y1 = node1.getCoord().getY()+node1.getCoord().getHeight()/2;
		x2 = node2.getCoord().getX()+node2.getCoord().getWidth()/2;
		y2 = node2.getCoord().getY()+node2.getCoord().getHeight()/2;
		coord = new Coordenada(x1, y1, x2-x1, y2-y1);
		return coord;
	}

	public Node2D getNode1() {
		return node1;
	}

	public void setNode1(Node2D node1) {
		this.node1 = node1;
	}

	public Node2D getNode2() {
		return node2;
	}

	public void setNode2(Node2D node2) {
		this.node2 = node2;
	}

	public Coordenada getCoord() {
		return coord;
	}

	public void setCoord(Coordenada coord) {
		this.coord = coord;
	}

	@Override
	public Desenhavel getPai() {
		return pai;
	}

	public void setPai(Desenhavel pai) {
		this.pai = pai;
	}

}
