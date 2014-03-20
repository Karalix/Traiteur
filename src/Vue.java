import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private Image imagesrc;
	private Image imageres;
	
	
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
		menuTraitement = new JMenu("Traitement");
		gris = new JMenuItem("Gris");
		bleu = new JMenuItem("Bleu");
		rouge = new JMenuItem("Rouge");
		vert = new JMenuItem("Vert");
		
		gris.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				traitement = new GrisTraitement(imagesrc, 0);
				
			}
		});
		
		bleu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				traitement = new BleuTraitement(imagesrc, 0);

				
			}
		});
		
		rouge.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				traitement = new RougeTraitement(imagesrc, 0);

				
			}
		});
		
		vert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				traitement = new RougeTraitement(imagesrc, 0);

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
}
