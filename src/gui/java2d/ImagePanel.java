package gui.java2d;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1759369792112068551L;
	
	private BufferedImage imagem;
	
	public ImagePanel() {
		try {
			URL url = ImagePanel.class.getResource("/imagens/Mapa Heuristica.jpg");
			imagem = ImageIO.read(url);
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
