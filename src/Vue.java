import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;


public class Vue {
	private JFrame frame;
	private JPanel panel;
	private  JLabel image ;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem ouvrir;
	private JMenuItem sauver;
	private JSlider slider;
	
	
	public Vue(){
		frame = new JFrame("Traiteur");
		panel = new JPanel();
		image = new JLabel();
		slider = new JSlider(1,31,4);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		panel.add(slider);
		panel.add(image, BorderLayout.CENTER);
		
		menuBar = new JMenuBar();
		menu = new JMenu("Fichier");
		ouvrir = new JMenuItem("Ouvrir");
		sauver = new JMenuItem("Sauvegarder");
		
		
		
		frame.setJMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(ouvrir);
		menu.add(sauver);
		frame.getContentPane().add(panel,BorderLayout.CENTER);
		frame.setMinimumSize(new Dimension(720,640));
		
		frame.setVisible(true);
		
	}
}
