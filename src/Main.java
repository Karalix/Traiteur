import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Main {
	private Image imageResult;
	private static Image imageBase;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vue v = new Vue() ;
		
	}

	public Image getImageResult() {
		return imageResult;
	}

	public synchronized void setImageResult(Image newImg, int offset) {
		
	}

}
