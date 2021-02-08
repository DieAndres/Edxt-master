package Presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import DataType.DtPrograma;
import Excepciones.ProgramaRepetidoExcepcion;
import Interface.IAlta;
import Tools.Herramienta;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.JPanel;

public class JProgramaAlta extends BackGround {
	private static final long serialVersionUID = 1L;
	
	private JProgramaDatos programaDatos;
	private JLabel lblExiste;
	

	/**
	 * Create the panel.
	 */
	public JProgramaAlta(IAlta iAlta,Principal principal) {
		setLayout(new MigLayout("", "[grow][::450px,grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Agregar Programa");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		add(lblNewLabel, "cell 1 0,alignx center,aligny bottom");
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[208px,grow][][grow]", "[grow][][23px]"));
		programaDatos = new JProgramaDatos();
		panel.add(programaDatos, "cell 0 0 3 1,grow");
		
		lblExiste = new JLabel("New label");
		lblExiste.setForeground(Color.WHITE);
		panel.add(lblExiste, "cell 0 1 3 1,alignx center");
		
		
		JButton btnAceptar = new JButton("Aceptar");
		panel.add(btnAceptar, "cell 0 2,alignx center,aligny top");
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar, "cell 2 2,alignx center");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.switchPanel("Principal");
			}
		});
		
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(programaDatos.datosValidos()) {
					DtPrograma infoProg = programaDatos.getDtPrograma();
					try {
						iAlta.registrarPrograma(infoProg);
						lblExiste.setText("El programa de formacion fue creado con exito");
						lblExiste.setVisible(true);
						programaDatos.borrarTodo();
					} catch(ProgramaRepetidoExcepcion ex) {
						lblExiste.setText(ex.getMessage());
						lblExiste.setVisible(true);	
					}	
				}
			}
		});
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				lblExiste.setVisible(false);
				programaDatos.borrarTodo();
				
			}
		});

	}

}
