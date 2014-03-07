import java.awt.Image;


public class Traitement implements ITraiter, Runnable{

	protected Image imageBase ;
	protected Image imageResult;
	protected int offset ;
	protected Main m ;
	
	
	public Traitement(Main m,Image base, int offset){
		this.m = m ;
		imageBase = base;
		this.offset = offset ;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void traiter() {
		// TODO Auto-generated method stub
		
	}

}
