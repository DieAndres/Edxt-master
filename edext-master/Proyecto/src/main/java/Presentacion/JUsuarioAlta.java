package Presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import DataType.DtDocente;
import DataType.DtEstudiante;
import DataType.DtUsuario;
import Interface.IAlta;
import Interface.IConsulta;
import Tools.Herramienta;
import Tools.ImageLoad;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Font;

public class JUsuarioAlta extends BackGround {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JUsuarioDatos jUsuarioDatos;
	private JComboBox cbxInstituto;
	private JRadioButton rdbEstudiante;
	private ImageLoad lErrorInsti;

	/**
	 * Create the panel.
	 */
	public JUsuarioAlta(IAlta iAlta,IConsulta iconsulta,Principal principal) {

		ButtonGroup group = new ButtonGroup();
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				Herramienta.llenarCombobox(cbxInstituto, iconsulta.listarInstituto());
				lErrorInsti.setVisible(false);
			}
		});
		setLayout(new MigLayout("", "[grow][grow,right][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Creacion de Usuario");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.WHITE);
		add(lblNewLabel, "cell 1 0,alignx center,aligny bottom");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 1 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow]", "[168px,grow][][][grow][]"));
		jUsuarioDatos = new JUsuarioDatos();
		panel_1.add(jUsuarioDatos, "cell 0 0 3 1,growx,aligny top");
		
		JLabel lblInstituto = new JLabel("Instituto");
		panel_1.add(lblInstituto, "flowx,cell 0 1,alignx right");
		cbxInstituto = new JComboBox();
		panel_1.add(cbxInstituto, "cell 1 1 2 1,growx");
		
		JPanel panel = new JPanel();
		panel_1.add(panel, "cell 0 2 3 1,grow");
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, Color.white));
		panel.setLayout(new MigLayout("", "[68px,grow][grow]", "[18px]"));
		JRadioButton rdbDocente = new JRadioButton("Docente");
		rdbDocente.setSelected(true);
		panel.add(rdbDocente, "cell 0 0,alignx center,aligny top");
		rdbDocente.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Herramienta.unblockAll(cbxInstituto);
				cbxInstituto.removeAllItems();
				Herramienta.llenarCombobox(cbxInstituto, iconsulta.listarInstituto());
				
			}
		});
		group.add(rdbDocente);
		
		
		rdbEstudiante = new JRadioButton("Estudiante");
		panel.add(rdbEstudiante, "cell 1 0,alignx center");
		rdbEstudiante.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Herramienta.blockAll(cbxInstituto);
				lErrorInsti.setVisible(false);
			}
		});
		group.add(rdbEstudiante);
		
		JLabel lblCartel = new JLabel("New label");
		panel_1.add(lblCartel, "cell 0 3 3 1,alignx center");
		
		
		JButton btnAceptar = new JButton("Aceptar");
		panel_1.add(btnAceptar, "cell 0 4,alignx center");
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_1.add(btnCancelar, "cell 2 4,alignx center");
		
		lErrorInsti = new ImageLoad("/errorIcon.png");
		panel_1.add(lErrorInsti, "cell 0 1");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.switchPanel("Principal");
			}
		});
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jUsuarioDatos.datosValidos() == true ) {
				
					DtUsuario usuario=jUsuarioDatos.getDtUsuario();
					if(rdbEstudiante.isSelected()==true) {
						  DtEstudiante estudiante=new DtEstudiante(usuario);
						  if( iAlta.registroUsuarioEst(estudiante)==false) {
							  lblCartel.setText("Estudiante Registrado");
							  lblCartel.setVisible(true);
							  jUsuarioDatos.borrarTodo();
							}
						  else {
							  lblCartel.setText("El Nickname o Correo ya existe");
								lblCartel.setVisible(true);
						  }
					}
					else if(Herramienta.CMBIsEmpty(cbxInstituto)== false )
					{
						String foto = " "; //MOMENTANEO PARA QUE NO DE ERROR
						Herramienta.unblockAll(cbxInstituto);
						DtDocente docente=new DtDocente(usuario.getNickName(),usuario.getNombre(),usuario.getApellido(),usuario.getEmail(),usuario.getFecha(),cbxInstituto.getSelectedItem().toString(), usuario.getPass(), foto);
						if( iAlta.registroUsuarioDoc(docente)==false) {
							jUsuarioDatos.borrarTodo();
							lblCartel.setText("Docente Registrado");
							lblCartel.setVisible(true);
						}
						else {
							lblCartel.setText("El Nickname o Correo ya existe");
							lblCartel.setVisible(true);
						}
						
					}else {
						lErrorInsti.setVisible(true);
						lErrorInsti.setToolTipText("No hay Instututos para asignar al docente");
					}
				}
			}
			
		});
		lblCartel.setVisible(false);
		
		lErrorInsti.setVisible(false);

		
	   


	}

}
