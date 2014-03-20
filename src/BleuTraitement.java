import java.awt.Image;
import java.awt.image.BufferedImage;


public class BleuTraitement extends Traitement {

	public BleuTraitement(BufferedImage base, BufferedImage res) {
		super(base, res);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void traiter(){
		for (int w = 0; w < super.imageBase.getWidth() ; ++w) {
			for (int h = 0 ; h < super.imageBase.getHeight() ; ++h){
				int rgb = super.imageBase.getRGB(w, h);
				int b = rgb & 0xFF0000FF;
				super.imageResult.setRGB(w, h, b);
			}
		}
	}

}