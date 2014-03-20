import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Vue {
	private JFrame frame;
	private JPanel panel;
	private  JLabel image ;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenu menuTraitement;
	private JMenuItem ouvrir;
	private JMenuItem sauver;
	private JMenuItem gris;
	private JMenuItem bleu;
	private JMenuItem rouge;
	private JMenuItem vert;
	private JSlider slider;
	private JFileChooser chooser;
	
	private Traitement traitement ;
	private BufferedImage imagesrc;
	private BufferedImage imageres;
	
	
	public Vue(){
		frame = new JFrame("Traiteur");
		panel = new JPanel();
		image = new JLabel();
		slider = new JSlider(1,31,4);
		chooser = new JFileChooser();
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		panel.add(slider, BorderLayout.NORTH);
		panel.add(image, BorderLayout.CENTER);
		
		menuBar = new JMenuBar();
		menu = new JMenu("Fichier");
		ouvrir = new JMenuItem("Ouvrir");
		sauver = new JMenuItem("Sauvegarder");
		ouvrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG & GIF Images", "jpg", "png", "gif");
			    chooser.setFileFilter(filter);
				chooser.showOpenDialog(null);
				
				try {
					imagesrc = ImageIO.read(chooser.getSelectedFile());
					setImage(imagesrc);
				} catch(IOException e) {
					e.printStackTrace();
					String workingDir = System.getProperty("user.dir");
				    System.out.println("Current working directory : " + workingDir);
				}
				
			}
		});
		
		sauver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {	
				try {
					ImageIO.write(imageres, "png", new File("imgOutput.png"));
				} catch(IOException e) {
				    System.out.println(e);
				}
				
			}
		});
		
		menuTraitement = new JMenu("Traitement");
		gris = new JMenuItem("Gris");
		bleu = new JMenuItem("Bleu");
		rouge = new JMenuItem("Rouge");
		vert = new JMenuItem("Vert");
		
		gris.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				imageres = new BufferedImage(imagesrc.getWidth(),imagesrc.getHeight(),BufferedImage.TYPE_INT_ARGB);
				int offsetPrev = 0;
				int offset =0;
				for (int i = 1 ; i <= slider.getValue() ; ++i){
					offset += calcOffset(i, offsetPrev);
					traitement = new GrisTraitement(imagesrc, imageres,offsetPrev,offset);
					traitement.traiter();
					offsetPrev = offset;
					setImage(imageres);
				}
			}
		});
		
		bleu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				imageres = new BufferedImage(imagesrc.getWidth(),imagesrc.getHeight(),BufferedImage.TYPE_INT_ARGB);
				int offsetPrev = 0;
				int offset =0;
				for (int i = 1 ; i <= slider.getValue() ; ++i){
					offset += calcOffset(i, offsetPrev);
					traitement = new BleuTraitement(imagesrc, imageres,offsetPrev,offset);
					traitement.traiter();
					offsetPrev = offset;
					setImage(imageres);
				}
			}
		});
		
		rouge.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				imageres = new BufferedImage(imagesrc.getWidth(),imagesrc.getHeight(),BufferedImage.TYPE_INT_ARGB);
				int offsetPrev = 0;
				int offset =0;
				for (int i = 1 ; i <= slider.getValue() ; ++i){
					offset += calcOffset(i, offsetPrev);
					traitement = new RougeTraitement(imagesrc, imageres,offsetPrev,offset);
					traitement.traiter();
					offsetPrev = offset;
					setImage(imageres);
				}
				
			}
		});
		
		vert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				imageres = new BufferedImage(imagesrc.getWidth(),imagesrc.getHeight(),BufferedImage.TYPE_INT_ARGB);
				int offsetPrev = 0;
				int offset =0;
				for (int i = 1 ; i <= slider.getValue() ; ++i){
					offset += calcOffset(i, offsetPrev);
					traitement = new VertTraitement(imagesrc, imageres,offsetPrev,offset);
					traitement.traiter();
					offsetPrev = offset;
					setImage(imageres);
				}
			}
		});
		
		
		
		frame.setJMenuBar(menuBar);
		menuBar.add(menu);
		menuBar.add(menuTraitement);
		menu.add(ouvrir);
		menu.add(sauver);
		menuTraitement.add(gris);
		menuTraitement.add(bleu);
		menuTraitement.add(rouge);
		menuTraitement.add(vert);
		frame.getContentPane().add(panel,BorderLayout.CENTER);
		frame.setMinimumSize(new Dimension(720,640));
		
		frame.setVisible(true);
		
	}
	
	public void setImage(Image i){
		ImageIcon icon = new ImageIcon(i);
		image.setIcon(icon);
	}
	
	public int calcOffset(int numTh,int offsetPrev){
		int nbTh = slider.getValue() - numTh;
		if(nbTh == 0)
			return imagesrc.getWidth() - offsetPrev;
		else
			return imagesrc.getWidth()/slider.getValue();
	}
}
