import java.awt.Image;
import java.awt.image.BufferedImage;


public class Traitement implements ITraiter, Runnable{

	protected BufferedImage imageBase ;
	protected BufferedImage imageResult;
	protected int offset ;
	
	
	public Traitement(BufferedImage base,BufferedImage res){
		imageBase = base;
		imageResult = res ;
		
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
