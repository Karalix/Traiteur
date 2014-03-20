import java.awt.image.BufferedImage;


public class BleuTraitement extends Traitement {

	public BleuTraitement(BufferedImage base, BufferedImage res,int offset,int taille) {
		super(base, res,offset,taille);
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