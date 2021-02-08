package Presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Interface.IAlta;
import Tools.Herramienta;
import Tools.ImageLoad;
import net.miginfocom.swing.MigLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JInstitutoAlta extends BackGround{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNom;
	private ImageLoad lErrorNom;
	private JLabel lblExiste;
	/**
	 * Create the panel.
	 */
	public JInstitutoAlta(IAlta iAlta,Principal principal) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				Herramienta.emptyAll(txtNom);
				lErrorNom.setVisible(false);
				lblExiste.setVisible(false);
			}
		});
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new MigLayout("", "[grow][::200px,grow,fill][::200px,grow,fill][grow]", "[grow][][grow,center][::30,grow][][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Crear Instituto");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_1, "cell 1 1 2 1,alignx center");
		
		JPanel panel = new JPanel();
		panel.setBounds(68, 5, 377, 364);
		add(panel, "cell 1 2 2 1,grow");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 1, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new MigLayout("", "[37px][][grow]", "[14px,grow]"));
		
		JLabel lblNewLabel = new JLabel("Nombre");
		panel_1.add(lblNewLabel, "cell 0 0,alignx right,aligny bottom");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lErrorNom = new ImageLoad("/errorIcon.png");
		panel_1.add(lErrorNom, "cell 1 0,alignx right,aligny bottom");
		lErrorNom.setVisible(false);
		
		
		txtNom = new JTextField();
		txtNom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtNom.setText("");
			}
		});

		panel_1.add(txtNom, "cell 2 0,growx,aligny bottom");
		txtNom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				lErrorNom.setVisible(false);
				lblExiste.setVisible(false);
				
			}
		});
		txtNom.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNom.setColumns(10);
		
		lblExiste = new JLabel("El instituto ya existe");
		GridBagConstraints gbc_lblExiste = new GridBagConstraints();
		gbc_lblExiste.gridwidth = 4;
		gbc_lblExiste.insets = new Insets(0, 0, 5, 5);
		gbc_lblExiste.gridx = 0;
		gbc_lblExiste.gridy = 1;
		panel.add(lblExiste, gbc_lblExiste);
		lblExiste.setHorizontalAlignment(SwingConstants.CENTER);
		lblExiste.setVisible(false);
		
		JButton btnNewButton = new JButton("Aceptar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridwidth = 2;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 2;
		panel.add(btnCancelar, gbc_btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.switchPanel("Principal");
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNom.getText().equals("") == false) {
					lblExiste.setVisible(true);
					if(iAlta.registroInstituto(txtNom.getText())==false) {
						lblExiste.setText("Ingreso con éxito");
						txtNom.setText("");	
					}else {
						iAlta.cancelar();
						lblExiste.setText("Ya existe");
					}
				}else {
					lErrorNom.setVisible(true);

				}
			}
		});
	}
}
