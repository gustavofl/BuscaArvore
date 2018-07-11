package gui.java2d;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import model.Arvore;

@SuppressWarnings("serial")
public class ComponentArvore2D extends JComponent {

	private Arvore arvore;
	private Div toplevel;

	public ComponentArvore2D(Arvore arvore) {
		this.arvore = arvore;
		
		setBackground( Color.gray );
		setVisible(true);
	}

	public void paint(Graphics g) {
		if(arvore.getRaiz() == null) return;
		
		this.toplevel = new Div(null, arvore.getRaiz());
		this.toplevel.getCoord().setY(30);
		Coordenada coord = this.toplevel.calcular();
		setSize(coord.getWidth()+coord.getX(), coord.getHeight()+coord.getY());
		this.toplevel.desenhar(g);
	}

	public Arvore getArvore() {
		return arvore;
	}

	public void setArvore(Arvore arvore) {
		this.arvore = arvore;
	}
}