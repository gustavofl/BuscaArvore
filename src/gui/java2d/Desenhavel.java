package gui.java2d;

import java.awt.Graphics;

public interface Desenhavel {
	public static final int PADX = 10;
	public static final int PADY = 10;
	
	public void desenhar(Graphics g);
	public Coordenada calcular();
	public Desenhavel getPai();
}
