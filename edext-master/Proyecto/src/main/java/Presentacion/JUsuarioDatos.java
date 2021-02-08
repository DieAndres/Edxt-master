package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import DataType.DtUsuario;
import Tools.Herramienta;
import Tools.ImageLoad;
import net.miginfocom.swing.MigLayout;

public class JUsuarioDatos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfNickname;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfEmail;
	private JDateChooser dcFNac;
	private ImageLoad lErrorNick;
	private ImageLoad lErrorApe;
	private ImageLoad lErrorEmail;
	private ImageLoad lErrorc;
	private ImageLoad lErrorFNac;
	private ImageLoad lErrorPass;
	private JLabel lblPass;
	private JTextField tfPass;
	private MigLayout migLayout;
	

	/**
	 * Create the panel.
	 */
	public JUsuarioDatos() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				cleanErrors();
			}
		});
		migLayout = new MigLayout("", "[grow][][][grow][][][grow][grow]", "[grow,top][:30:30][grow][:30:30][grow][:30:30][grow][:78.00:30][grow,bottom]");
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(migLayout);
		JLabel lblNickname = new JLabel("Nickname");
		add(lblNickname, "cell 1 1,alignx trailing");
		lErrorNick = new ImageLoad("/errorIcon.png");
		add(lErrorNick,"cell 2 1,alignx center");
		
		tfNickname = new JTextField();
		tfNickname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(lErrorNick.isVisible() == true) {
					lErrorNick.setVisible(false);
				}
			}
		});
		add(tfNickname, "cell 3 1 4 1,growx");
		tfNickname.setColumns(10);
		
		lblPass = new JLabel("Password");
		add(lblPass, "cell 1 2,alignx right");
		lErrorPass = new ImageLoad("/errorIcon.png");
		add(lErrorPass,"cell 2 2,alignx center");
		
		tfPass = new JTextField();
		tfPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				lErrorPass.setVisible(false);
			}
		});
		tfPass.setColumns(10);
		add(tfPass, "cell 3 2 4 1,growx");
		
		JLabel lblNombre = new JLabel("Nombre");
		add(lblNombre, "cell 1 3,alignx trailing");
		
		lErrorc = new ImageLoad("/errorIcon.png");
		add(lErrorc, "cell 2 3,alignx center");
		
		tfNombre = new JTextField();
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(lErrorc.isVisible() == true) {
					lErrorc.setVisible(false);
				}
			}
		});
		add(tfNombre, "cell 3 3,growx");
		tfNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		add(lblApellido, "cell 4 3,alignx trailing");
		
		lErrorApe = new ImageLoad("/errorIcon.png");
		add(lErrorApe, "cell 5 3,alignx trailing");
		
		tfApellido = new JTextField();
		tfApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(lErrorApe.isVisible() == true) {
					lErrorApe.setVisible(false);
				}
			}
		});
		add(tfApellido, "cell 6 3,growx");
		tfApellido.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "cell 1 5,alignx trailing");
		
		lErrorEmail = new ImageLoad("/errorIcon.png");
		add(lErrorEmail, "cell 2 5,alignx center");
		
		tfEmail = new JTextField();
		tfEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(lErrorEmail.isVisible() == true) {
					lErrorEmail.setVisible(false);
				}
			}
		});
		add(tfEmail, "cell 3 5 4 1,growx");
		tfEmail.setColumns(10);
		
		JLabel lblFNac = new JLabel("Fecha de Nacimiento");
		add(lblFNac, "cell 1 7,alignx right");
		
		lErrorFNac = new ImageLoad("/errorIcon.png");
		
		add(lErrorFNac, "cell 2 7,alignx center");
		
		dcFNac = new JDateChooser();
		dcFNac.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lErrorFNac.setVisible(false);
			}
		});
		add(dcFNac, "cell 3 7 4 1,grow");
		cleanErrors();
		lErrorPass.setVisible(false);
	}
	
	
	
	public void blockAll() {
		tfNickname.setEditable(false);
		tfNombre.setEditable(false);
		tfApellido.setEditable(false);
		tfEmail.setEditable(false);
		dcFNac.getCalendarButton().setEnabled(false);
		JDateChooser chooser = new JDateChooser();
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dcFNac.getDateEditor();
		editor.setEditable(false);
	}
	
	public void unblockAll() {
		tfNickname.setEditable(false);
		tfNombre.setEditable(false);
		tfApellido.setEditable(false);
		tfEmail.setEditable(false);
		dcFNac.getCalendarButton().setEnabled(false);
		JDateChooser chooser = new JDateChooser();
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dcFNac.getDateEditor();
		editor.setEditable(true);
	}
	
	public void borrarTodo() {
		tfNickname.setText("");
		tfNombre.setText("");
		tfApellido.setText("");
		tfEmail.setText("");
		dcFNac.setDate(null);;
	}
	
	public String getNombre() {
		return tfNombre.getText();
	}
	public String getNickname() {
		return tfNickname.getText();
	}
	public String getApellido() {
		return tfApellido.getText();
	}
	public String getEmail() {
		return tfEmail.getText();
	}
	
	public Date getFNac() {
		return dcFNac.getDate();
	}

	public DtUsuario getDtUsuario() {
		String foto = " "; //POR EL EMOMENTO PARA QUE NO DE ERROR EL CONTRUCTOR DE DtUsuario.
		return new DtUsuario(tfNickname.getText(),tfNombre.getText(),tfApellido.getText(),tfEmail.getText(),dcFNac.getDate(),tfPass.getText(), foto);
	}
	public void setDatos(DtUsuario usr) {
		tfPass.setVisible(false);
		lblPass.setVisible(false);
		
		tfNickname.setText(usr.getNickName());
		tfNombre.setText(usr.getNombre());
		tfApellido.setText(usr.getApellido());
		tfEmail.setText(usr.getEmail());
		dcFNac.setDate(usr.getFecha());;
	}

	public boolean datosValidos() {
		Boolean returno = true;
		if(tfNickname.getText().toString().equals("") == true) {
			returno = false;
			lErrorNick.setVisible(true);
			lErrorNick.setToolTipText("El nickname est� vac�o");
		}
		
		
		if(tfNombre.getText().toString().equals("") == true) {
			returno = false;
			lErrorc.setVisible(true);
			lErrorc.setToolTipText("El nombre est� vac�o");
		}
		if(tfPass.getText().toString().equals("") && tfPass.isVisible() == true) {
			returno = false;
			lErrorPass.setVisible(true);
			lErrorPass.setToolTipText("La contrasenia est� vac�a");
		}
		
		if(tfApellido.getText().toString().equals("") == true) {
			returno = false;
			lErrorApe.setVisible(true);
			lErrorApe.setToolTipText("El apellido est� vac�o");
		}
		if(tfEmail.getText().toString().equals("") == true) {
			returno = false;
			lErrorEmail.setVisible(true);
			lErrorEmail.setToolTipText("El Email est� vac�o");
		}
		if(dcFNac.getDate() == null) {
			returno = false;
			lErrorFNac.setVisible(true);
			lErrorFNac.setToolTipText("No se a seleccionado una fecha");
		}
		return returno;
	}
	



	public void cleanErrors() {
		lErrorNick.setVisible(false);
		lErrorApe.setVisible(false);
		lErrorEmail.setVisible(false);
		lErrorc.setVisible(false);
		lErrorFNac.setVisible(false);
	}
	
	public void blockNickEmail() {
		Herramienta.blockAll(tfNickname, tfEmail);
	}

}
