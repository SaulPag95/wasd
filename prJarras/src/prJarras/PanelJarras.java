package prJarras;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelJarras extends JPanel implements VistaJarras{

	private static final long serialVersionUID = 1L;
	
	private JPanel panel1, panel2, panelInitA, panelIniciar, objtiv, panelInitB, jarraA, contenidoPA, capacidadPA, jarraB, contenidoPB, capacidadPB, centro;
	private JLabel inf, lCantA, lCantB, contenidoA, capacidadA, contenidoB, capacidadB, objv;
	private JTextArea registro, cantA, cantB, contA, contB, capA, capB, objetivo;
	private JButton iCapacidades, llenaA, vaciaA, der, izq, fin, llenaB, vaciaB;
	private ControladorJarras actionL;

	public PanelJarras(){

		setLayout(new GridLayout(0, 1, 5, 5));
		this.panel1 = new JPanel(new GridLayout(1,3,5,5));
		this.panel2 = new JPanel(new GridLayout(1,3,5,5));
		this.registro = new JTextArea();
		this.registro.setEditable(false);
		this.inf = new JLabel(" ");
		

		this.lCantA = new JLabel("Jarra A ");
		this.cantA = new JTextArea();
		

		this.panelInitA = new JPanel(new GridLayout(1,2));
		this.panelInitA.add(this.lCantA);
		this.panelInitA.add(this.cantA);
		
		this.iCapacidades = new JButton("Iniciar Capacidades");
		this.objv = new JLabel("Objetivo: ");
		this.objetivo = new JTextArea();
		
		this.objtiv = new JPanel(new GridLayout(1, 2));
		this.objtiv.add(this.objv);
		this.objtiv.add(this.objetivo);
		
		
		this.panelIniciar = new JPanel(new GridLayout(2, 1));
		this.panelIniciar.add(this.iCapacidades);
		this.panelIniciar.add(this.objtiv);
		
		
		this.lCantB = new JLabel("Jarra B ");
		this.cantB = new JTextArea();
		
		this.panelInitB = new JPanel(new GridLayout(1,2));
		this.panelInitB.add(this.lCantB);
		this.panelInitB.add(this.cantB);
		
		
		this.panel1.add(this.panelInitA);
		this.panel1.add(this.panelIniciar);
		this.panel1.add(this.panelInitB);
		
		
		this.jarraA = new JPanel(new GridLayout(4,1,5,5));
		this.llenaA = new JButton("Llenar");
		
		this.contenidoA = new JLabel("Contenido: ");
		this.contA = new JTextArea();
		this.contA.setEditable(false);
		
		this.contenidoPA = new JPanel(new GridLayout(1,2));
		this.contenidoPA.add(this.contenidoA);
		this.contenidoPA.add(this.contA);
		
		this.capacidadA = new JLabel("Capacidad: ");
		this.capA = new JTextArea();
		this.capA.setEditable(false);
		
		this.capacidadPA = new JPanel(new GridLayout(1,2));
		this.capacidadPA.add(this.capacidadA);
		this.capacidadPA.add(this.capA);
		
		this.vaciaA = new JButton("Vaciar");
		
		
		this.jarraA.add(this.llenaA);
		this.jarraA.add(this.contenidoPA);
		this.jarraA.add(this.capacidadPA);
		this.jarraA.add(this.vaciaA);
		
		this.panel2.add(this.jarraA);
		
		
		this.centro = new JPanel(new GridLayout(3,1,5,5));
		this.der = new JButton(new ImageIcon("images/flecha_d.png"));
		this.izq = new JButton(new ImageIcon("images/flecha_i.png")); 
		this.fin = new JButton("Finalizar");
		
		this.centro.add(this.der);
		this.centro.add(this.izq);
		this.centro.add(this.fin);
		
		
		this.panel2.add(this.centro);
		
		
		this.jarraB = new JPanel(new GridLayout(4,1,5,5));
		this.llenaB = new JButton("Llenar");
		
		this.contenidoB = new JLabel("Contenido: ");
		this.contB = new JTextArea();
		this.contB.setEditable(false);
		
		this.contenidoPB = new JPanel(new GridLayout(1,2));
		this.contenidoPB.add(this.contenidoB);
		this.contenidoPB.add(this.contB);
		
		this.capacidadB = new JLabel("Capacidad: ");
		this.capB = new JTextArea();
		this.capB.setEditable(false);
		
		this.capacidadPB = new JPanel(new GridLayout(1,2));
		this.capacidadPB.add(this.capacidadB);
		this.capacidadPB.add(this.capB);
		
		this.vaciaB = new JButton("Vaciar");
		
		
		this.jarraB.add(this.llenaB);
		this.jarraB.add(this.contenidoPB);
		this.jarraB.add(this.capacidadPB);
		this.jarraB.add(this.vaciaB);
		
		
		this.panel2.add(this.jarraB);
		
		this.panel1.setPreferredSize(new Dimension(500,500));
		add(this.panel1);
		add(this.panel2);
		add(this.registro);
		add(this.inf);
		
		
		this.actionL = new ControladorJarras(this);
		
		this.iCapacidades.addActionListener(actionL);
		this.der.addActionListener(actionL);
		this.izq.addActionListener(actionL);
		this.fin.addActionListener(actionL);
		this.llenaA.addActionListener(actionL);
		this.llenaB.addActionListener(actionL);
		this.vaciaA.addActionListener(actionL);
		this.vaciaB.addActionListener(actionL);
		
		this.iCapacidades.setActionCommand(INICIAR);
		this.der.setActionCommand(VOLCAR_A_EN_B);
		this.izq.setActionCommand(VOLCAR_B_EN_A);
		this.fin.setActionCommand(FINALIZAR);
		this.llenaA.setActionCommand(LLENAR_A);
		this.llenaB.setActionCommand(LLENAR_B);
		this.vaciaA.setActionCommand(VACIAR_A);
		this.vaciaB.setActionCommand(VACIAR_B);
		
		habilitarInicio(true);
	}

	public int capacidadInicialA() {
		try{
			return Integer.parseInt(this.cantA.getText());
		}catch(NumberFormatException e){
			return 0;
		}
		
	}

	public int capacidadInicialB() {
		try{
			return Integer.parseInt(this.cantB.getText());
		}catch(NumberFormatException e){
			return 0;
		}
	}
	
	public int capacidadObjetivo(){
		try{
			if(this.objetivo.getText().equals(this.cantA.getText()) || this.objetivo.getText().equals(this.cantB.getText())){
				return 0;
			}
			return Integer.parseInt(this.objetivo.getText());
		}catch(NumberFormatException e){
			return 0;
		}
	}

	public void error(String mensaje) {
		this.inf.setForeground(Color.red);
		this.inf.setText(mensaje);
	}

	public void ok(String mensaje) {
		this.inf.setForeground(Color.black);
		this.inf.setText(mensaje);
	}

	public void habilitarInicio(boolean b) {
		this.cantA.setEnabled(b);
		this.cantB.setEnabled(b);
		this.iCapacidades.setEnabled(b);
		this.lCantA.setEnabled(b);
		this.lCantB.setEnabled(b);
		this.objetivo.setEditable(!b);
		
		this.registro.setEnabled(!b);
		this.contA.setEnabled(!b);
		this.contB.setEnabled(!b);
		this.capA.setEnabled(!b);
		this.capB.setEnabled(!b);
		this.llenaA.setEnabled(!b);
		this.vaciaA.setEnabled(!b);
		this.llenaB.setEnabled(!b);
		this.vaciaB.setEnabled(!b);
		this.der.setEnabled(!b);
		this.izq.setEnabled(!b);
		this.fin.setEnabled(!b);
		this.capacidadA.setEnabled(!b);
		this.capacidadB.setEnabled(!b);
		this.contenidoA.setEnabled(!b);
		this.contenidoB.setEnabled(!b);
		this.objetivo.setEditable(b);
		
	}

	public void capacidadA(int c) {
		this.capA.setText(String.valueOf(c));
	}

	public void capacidadB(int c) {
		this.capB.setText(String.valueOf(c));
	}

	public void contenidoA(int c) {
		this.contA.setText(String.valueOf(c));
	}

	public void contenidoB(int c) {
		this.contB.setText(String.valueOf(c));
	}

	public void añadirAHistórico(String mensaje) {
		this.registro.setText(this.registro.getText()+"\n"+mensaje);
	}

	public void limpiar() {
		this.registro.setText("");
	}

}
