package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.beans.Plano;
import model.dao.PlanoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlanoEditar extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lbPlano_Tipo;
	private JTextField textFieldTipo;
	private JLabel lblPlano_Valor;
	private JTextField textFieldValor;
	private JLabel lblPlano_Qtd;
	private JTextField textFieldQtd;
	private JLabel lbPlano_Codigo;
	private JTextField textFieldCodigo;
	private JButton btnButtonConfirmar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanoEditar frame = new PlanoEditar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlanoEditar() {
		setTitle("Alterar");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 414, 206);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbPlano_Tipo = new JLabel("Tipo de Plano");
		lbPlano_Tipo.setBounds(10, 70, 94, 26);
		panel.add(lbPlano_Tipo);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(91, 73, 86, 20);
		panel.add(textFieldTipo);
		
		lblPlano_Valor = new JLabel("Valor");
		lblPlano_Valor.setBounds(10, 110, 94, 26);
		panel.add(lblPlano_Valor);
		
		textFieldValor = new JTextField();
		textFieldValor.setColumns(10);
		textFieldValor.setBounds(91, 113, 86, 20);
		panel.add(textFieldValor);
		
		lblPlano_Qtd = new JLabel("Qtd. atividades dispon\u00EDveis");
		lblPlano_Qtd.setBounds(10, 158, 167, 26);
		panel.add(lblPlano_Qtd);
		
		textFieldQtd = new JTextField();
		textFieldQtd.setColumns(10);
		textFieldQtd.setBounds(170, 161, 86, 20);
		panel.add(textFieldQtd);
		
		lbPlano_Codigo = new JLabel("C\u00F3digo");
		lbPlano_Codigo.setBounds(10, 11, 94, 26);
		panel.add(lbPlano_Codigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(91, 14, 86, 20);
		panel.add(textFieldCodigo);
		
		btnButtonConfirmar = new JButton("Confirmar");
		btnButtonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Plano p = new Plano();
				PlanoDAO dao = new PlanoDAO();
				
				try {
					p.setTipoPlano(textFieldTipo.getText());
					p.setValor(Float.parseFloat(textFieldValor.getText()));
					p.setQtd(Integer.parseInt(textFieldQtd.getText()));
					p.setId(Integer.parseInt(textFieldCodigo.getText()));
					
					dao.modify(p);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			
				
				textFieldValor.setText("");
				textFieldQtd.setText("");
				textFieldCodigo	.setText("");
				
				
			}
		});
		btnButtonConfirmar.setBounds(20, 228, 89, 23);
		contentPane.add(btnButtonConfirmar);
	}
}
