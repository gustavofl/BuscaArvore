package arvore.java2d;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import arvore.Arvore;

@SuppressWarnings("serial")
public class DesenharArvore extends Frame {

	private Arvore arvore;
	private Div toplevel;

	public DesenharArvore(Arvore arvore) {
		super("Arvore");
		this.arvore = arvore;
		
		setBackground( Color.gray );
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				// System.exit(0);
			}
		});
	}

	public void paint(Graphics g) {
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