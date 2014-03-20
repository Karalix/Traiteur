import java.awt.Image;


public class Traitement implements ITraiter, Runnable{

	protected Image imageBase ;
	protected Image imageResult;
	protected int offset ;
	
	
	public Traitement(Image base,int offset){
		imageBase = base;
		this.offset = offset ;
		
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
