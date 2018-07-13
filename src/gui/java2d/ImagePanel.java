package gui.java2d;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1759369792112068551L;
	
	private BufferedImage imagem;
	
	public ImagePanel() {
		try {
			imagem = ImageIO.read(new File("imagens/Mapa Heuristica.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagem, 0, 0, null);
	}
	
}
