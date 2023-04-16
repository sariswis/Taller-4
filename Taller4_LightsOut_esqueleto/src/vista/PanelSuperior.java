package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class PanelSuperior extends JPanel{
	private static final int FACIL = 5;
	private static final int MEDIO = 10;
	private static final int DIFICIL = 15;
	private VentanaJuego ventana;
	private JComboBox<String> opciones;
	private ButtonGroup grupo;
	private JRadioButton facil;
	private JRadioButton medio;
	private JRadioButton dificil;
	
	public PanelSuperior(VentanaJuego ventana) {
	    this.ventana = ventana;
	   this.opciones = new JComboBox<String>();
	    this.grupo = new ButtonGroup();
	   this.facil = crearRadioButton("F�cil");
	    this.medio =  crearRadioButton("Medio");
	    this.dificil = crearRadioButton("Dif�cil");
		
	    setLayout(new FlowLayout(FlowLayout.CENTER));
	    setBackground(new Color (3,135,255));
	    
	    this.opciones.addItem("3x3");
	    this.opciones.addItem("4x4");
	    this.opciones.addItem("5x5");
	    this.opciones.addItem("6x6");
	    this.opciones.setSelectedItem("5x5");
	    this.grupo.add(this.facil);
	    this.grupo.add(this.medio);
	    this.grupo.add(this.dificil);
	    this.grupo.setSelected(this.facil.getModel(), true);

	    add(crearLabel("Tama�o:"));
	    add(this.opciones);
	    add(crearLabel("Dificultad:"));
	    add(this.facil);
	    add(this.medio);
	    add(this.dificil);
	}
	
	public int getTamanio() {
		String selected = (String) opciones.getSelectedItem();
        return Integer.valueOf(selected.substring(0, 1));
	}
	
	public int getDificultad() {
		ButtonModel selected= grupo.getSelection();
		if (selected == facil.getModel()) {
		    return FACIL;
		} else if (selected == medio.getModel()) {
			return MEDIO;
		} else if (selected == dificil.getModel()) {
			return DIFICIL;
		} else {
			return FACIL;
		}
	}
	
	public JLabel crearLabel(String nombre) {
		JLabel label = new JLabel(nombre);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 16));
		return label;
	}
	
	public JRadioButton crearRadioButton(String nombre) {
		JRadioButton boton = new JRadioButton(nombre);
		boton.setForeground(Color.WHITE);
		boton.setBackground(new Color (3,135,255));
		boton.setFont(new Font("Arial", Font.PLAIN, 15));
		return boton;
	}
}
