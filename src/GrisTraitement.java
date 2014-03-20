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
				//int rgb = super.imageBase.getRGB(w, h);

				//super.imageResult.setRGB(w, h, );
			}
		}
	}

}
