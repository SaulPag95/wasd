package prJarras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorJarras implements ActionListener{
	
	private PanelJarras paneJarra;
	private Jarra jarA, jarB;

	public ControladorJarras(PanelJarras pj){
		this.paneJarra=pj;
		this.jarA=new Jarra();
		this.jarB=new Jarra();
	}

	public void actionPerformed(ActionEvent arg0) {
		
		String argumento = arg0.getActionCommand();

		if(argumento.equals(this.paneJarra.INICIAR)){
			if(this.paneJarra.capacidadInicialA()==0 || this.paneJarra.capacidadInicialA()==0 || this.paneJarra.capacidadObjetivo()==0){
				this.paneJarra.error("Introduza una capacidad inicial valida para poder iniciar el problema");
			}else{
				this.paneJarra.habilitarInicio(false);
				this.jarA.setCapacidad(this.paneJarra.capacidadInicialA());
				this.jarB.setCapacidad(this.paneJarra.capacidadInicialB());
				this.paneJarra.capacidadA(this.jarA.getCapacidad());
				this.paneJarra.capacidadB(this.jarB.getCapacidad());
				this.paneJarra.contenidoA(0);
				this.paneJarra.contenidoB(0);
			}
		}else if(argumento.equals(this.paneJarra.LLENAR_A)){
			this.jarA.setContenido(this.jarA.getCapacidad());
			this.paneJarra.contenidoA(this.jarA.getCapacidad());
			this.paneJarra.añadirAHistórico("Llenamos la jarra A");
			
		}else if(argumento.equals(this.paneJarra.LLENAR_B)){
			this.jarB.setContenido(this.jarB.getCapacidad());
			this.paneJarra.contenidoB(this.jarB.getCapacidad());
			this.paneJarra.añadirAHistórico("Llenamos la jarra B");
			
		}else if(argumento.equals(this.paneJarra.VACIAR_A)){
			this.paneJarra.contenidoA(0);
			this.jarA.setContenido(0);
			this.paneJarra.añadirAHistórico("Vaciamos la jarra A");
			
		}else if(argumento.equals(this.paneJarra.VACIAR_B)){
			this.paneJarra.contenidoB(0);
			this.jarB.setContenido(0);
			this.paneJarra.añadirAHistórico("Vaciamos la jarra B");
			
		}else if(argumento.equals(this.paneJarra.VOLCAR_B_EN_A)){
			if(this.jarB.getContenido()>this.jarA.getCapacidad()-this.jarA.getContenido()){
				int resto = this.jarB.getContenido()-(this.jarA.getCapacidad()-this.jarA.getContenido());
				this.jarA.setContenido(this.jarA.getCapacidad());
				this.jarB.setContenido(resto);
			}else{
				this.jarA.setContenido(this.jarB.getContenido()+this.jarA.getContenido());
				this.jarB.setContenido(0);
			}
			this.paneJarra.contenidoA(this.jarA.getContenido());
			this.paneJarra.contenidoB(this.jarB.getContenido());
			this.paneJarra.añadirAHistórico("Volcamos el contenido de la jarra B en la jarra A");
		}else if(argumento.equals(this.paneJarra.VOLCAR_A_EN_B)){
			if(this.jarA.getContenido()>this.jarB.getCapacidad()-this.jarB.getContenido()){
				int resto = this.jarA.getContenido()-(this.jarB.getCapacidad()-this.jarB.getContenido());
				this.jarB.setContenido(this.jarB.getCapacidad());
				this.jarA.setContenido(resto);
			}else{
				this.jarB.setContenido(this.jarA.getContenido()+this.jarB.getContenido());
				this.jarA.setContenido(0);
			}

			this.paneJarra.contenidoA(this.jarA.getContenido());
			this.paneJarra.contenidoB(this.jarB.getContenido());
			this.paneJarra.añadirAHistórico("Volcamos el contenido de la jarra A en la jarra B");
		}
		
		if(argumento.equals(this.paneJarra.FINALIZAR) || 
			(this.jarA.getContenido()==this.paneJarra.capacidadObjetivo() || this.jarB.getContenido()==this.paneJarra.capacidadObjetivo())){
			this.paneJarra.habilitarInicio(true);
			this.paneJarra.limpiar();
			if(this.jarA.getContenido()==this.paneJarra.capacidadObjetivo() || this.jarB.getContenido()==this.paneJarra.capacidadObjetivo()){
				this.paneJarra.ok("Se ha llegado a la cantidad deseada ¡¡¡Felicidades!!!");
			}
			this.jarA=new Jarra();
			this.jarB=new Jarra();
			
		}
		
		
		
	}
}
