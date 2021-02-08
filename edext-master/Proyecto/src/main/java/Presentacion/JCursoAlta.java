package Presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import DataType.DtCurso;
import Interface.IAlta;
import Interface.IConsulta;
import Tools.Herramienta;
import net.miginfocom.swing.MigLayout;

public class JCursoAlta extends BackGround {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean VisPanel =true;
	private JCursoDatos cursoDatos;
	private JLabel lblExiste;
	/**
	 * Create the panel.
	 */
	
	public JCursoAlta (IConsulta iconsulta, IAlta ialta,Principal principal) {
		
		setLayout(new MigLayout("", "[grow][grow,left][grow][grow]", "[grow][20px,grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Creacion de Curso");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblNewLabel_1, "cell 1 0 2 1,alignx center,aligny bottom");
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 1 2 1,grow");
		panel.setLayout(new MigLayout("", "[41px][grow][grow]", "[14px][grow][][]"));

		
		JLabel lblNewLabel = new JLabel("Instituto");
		panel.add(lblNewLabel, "cell 0 0,alignx right,aligny center");
		
		JComboBox<String> cbInstituto = new JComboBox<String>();
		panel.add(cbInstituto, "cell 1 0 2 1,growx");
		cursoDatos = new JCursoDatos(iconsulta);
		panel.add(cursoDatos, "cell 0 1 3 1,grow");
		
		lblExiste = new JLabel("New label");
		panel.add(lblExiste, "cell 0 2 3 1,alignx center");
		JButton btnAceptar = new JButton("Aceptar");
		panel.add(btnAceptar, "cell 0 3 2 1,alignx center");
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar, "cell 2 3,alignx center");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.switchPanel("Principal");
			}
			
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cursoDatos.datosValidos() == true) {
					DtCurso datosC = cursoDatos.getDtCurso();
					if(ialta.registroCurso(datosC, cbInstituto.getSelectedItem().toString()) == false) {
						ialta.confirmarCurso(cursoDatos.getNomPrevias());
						lblExiste.setText("Ingreso con éxito");
						lblExiste.setVisible(true);
						cursoDatos.borrarTodo();
						cursoDatos.setPrevias();
					}else {
						lblExiste.setText("El curso ya existe");
						lblExiste.setVisible(true);
						ialta.cancelar();
					}
				}
				
					
			}

		});	
		
		lblExiste.setVisible(false);
		
		addComponentListener(new ComponentAdapter() {
			@Override
				public void componentShown(ComponentEvent e) {
				Herramienta.llenarCombobox(cbInstituto,iconsulta.listarInstituto() );
				cursoDatos.setPrevias();
				 if (Herramienta.CMBIsEmpty(cbInstituto)) {    
					 cursoDatos.blockAll();
				 }else
					 cursoDatos.unblockAll();
			}

			}	
		);
		
		

	}
	
}

