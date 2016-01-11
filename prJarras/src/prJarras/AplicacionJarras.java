package prJarras;

import javax.swing.JFrame;

public class AplicacionJarras {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		PanelJarras cj = new PanelJarras();
		frame.setContentPane(cj);
		frame.setSize(900, 700);
		frame.setTitle("Jarras");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
