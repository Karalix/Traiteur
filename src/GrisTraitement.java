import java.awt.image.BufferedImage;


public class GrisTraitement extends Traitement {

	public GrisTraitement(BufferedImage base, BufferedImage res,int offset,int taille) {
		super(base, res,offset,taille);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void traiter(){
		for (int w = 0; w < super.imageBase.getWidth() ; ++w) {
			for (int h = 0 ; h < super.imageBase.getHeight() ; ++h){
				int rgb = super.imageBase.getRGB(w, h);
				int b = rgb & 0xFF0000FF;
				int r = (rgb & 0xFFFF0000)>>>16;
				int v = (rgb & 0xFF00FF00)>>>8;

				int gris = ((b+r+v)/3);
				int newPix = (gris<<16)+(gris<<8)+gris;
				super.imageResult.setRGB(w, h, newPix);
			}
		}
	}

}
