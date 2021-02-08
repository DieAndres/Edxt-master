package Presentacion;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import DataType.DtUsuario;
import Interface.IModificacion;
import Logica.Manejador;
import Logica.Usuario;
import Tools.Herramienta;
import net.miginfocom.swing.MigLayout;

public class JUsuarioModificar extends BackGround {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	private JUsuarioDatos datosUsr;
	private JComboBox<String> cbxNickname;
	private JLabel lblExito;
	
	private Manejador manejador = Manejador.getInstancia();
	private JPanel panel;
	private JLabel lblNewLabel;
	
	public JUsuarioModificar(IModificacion cModif, Principal principal) {
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow,bottom]"));
		
		lblNewLabel = new JLabel("Modificacion de Usuario");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblNewLabel, "cell 1 0,alignx center,aligny bottom");
		
		panel = new JPanel();
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[36px][36px,grow][grow]", "[14px][grow][][]"));
		
		JLabel lblUsuario = new JLabel("Usuario");
		panel.add(lblUsuario, "cell 0 0,alignx left,aligny top");
		
		cbxNickname = new JComboBox<String>();
		panel.add(cbxNickname, "cell 1 0 2 1,growx");
		
		datosUsr = new JUsuarioDatos();
		panel.add(datosUsr, "cell 0 1 3 1,grow");
		
		lblExito = new JLabel("Los datos del usuario han sido actualizados con exito");
		panel.add(lblExito, "cell 0 2 3 1,alignx center");
		
		JButton btnAceptar = new JButton("Aceptar");
		panel.add(btnAceptar, "cell 0 3 3 1,alignx center");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarDatosUsrActionPerformed(arg0, cModif);
			}
		});
		cbxNickname.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				llenarUsuarios(cModif);
			}
		});
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				datosUsr.borrarTodo();
				llenarUsuarios(cModif);
			}
		});
	}
	
	
	public void llenarUsuarios(IModificacion cModif) {
		Herramienta.llenarCombobox(cbxNickname, cModif.listarUsuario());
		lblExito.setVisible(false);
		if(Herramienta.CMBIsEmpty(cbxNickname) == false) {
			Usuario usr = manejador.buscarUsuario(cbxNickname.getSelectedItem().toString());
			datosUsr.setDatos(usr.getDtUsuario());
			datosUsr.blockNickEmail();
		}
	}
	
	protected void modificarDatosUsrActionPerformed(ActionEvent arg0, IModificacion cModif) {
		if(datosUsr.datosValidos()) {
			DtUsuario usuario = datosUsr.getDtUsuario();
			cModif.modificarUsuario(usuario);
			lblExito.setVisible(true);
		}
	}

}


