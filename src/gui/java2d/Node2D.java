package gui.java2d;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Node2D implements Desenhavel{
	private Coordenada coord;
	private String label;
	private Desenhavel pai;
	
	public Node2D(Desenhavel pai, String label) {
		this.coord = new Coordenada();
		this.label = label;
		this.pai = pai;
	}
	
	@Override
	public void desenhar(Graphics g) {
		g.setColor(Color.black);
		g.fillOval( coord.getX(), coord.getY(), coord.getWidth(), coord.getHeight() );
		
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 20));
		g.drawString(label, coord.getX()+22, coord.getY()+32);
	}
	
	@Override
	public Coordenada calcular() {
		coord.setWidth(label.length()*15+2*22);
		coord.setHeight(50);
		return coord;
	}
	
	public Coordenada getCoord() {
		return coord;
	}
	
	public void setCoord(Coordenada coord) {
		this.coord = coord;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	public Desenhavel getPai() {
		return this.pai;
	}
	
	public void setPai(Desenhavel pai) {
		this.pai = pai;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Node2D))
			return false;
		Node2D node = (Node2D) obj;
		return node.getLabel().equals(this.label);
	}
}
