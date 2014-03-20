import java.awt.image.BufferedImage;


public class RougeTraitement extends Traitement {

	public RougeTraitement(BufferedImage base, BufferedImage res,int offset,int taille) {
		super(base, res,offset,taille);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void traiter(){
		for (int w = offset; w < taille ; ++w) {
			for (int h = 0 ; h < super.imageBase.getHeight() ; ++h){
				int rgb = super.imageBase.getRGB(w, h);
				int r = rgb & 0xFFFF0000;
				super.imageResult.setRGB(w, h, r);
			}
		}
	}

}
