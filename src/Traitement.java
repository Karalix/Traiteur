import java.awt.image.BufferedImage;


public class Traitement implements ITraiter, Runnable{

	protected BufferedImage imageBase ;
	protected BufferedImage imageResult;
	protected int offset ;
	protected int taille;
	
	
	public Traitement(BufferedImage base,BufferedImage res,int offset,int taille){
		imageBase = base;
		imageResult = res ;
		this.offset = offset;
		this.taille = taille;
	}
	
	@Override
	public void run() {
		traiter();
		
	}

	@Override
	public void traiter() {
		// TODO Auto-generated method stub
		
	}

}
