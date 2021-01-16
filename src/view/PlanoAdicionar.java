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
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlanoAdicionar extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lbPlano_Tipo;
	private JLabel lblPlano_Valor;
	private JLabel lblPlano_Qtd;
	private JTextField textFieldPlano_Tipo;
	private JTextField textFieldPlano_Valor;
	private JTextField textFieldPlano_Qtd;
	private JButton btnButtonPlano_Adicionar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanoAdicionar frame = new PlanoAdicionar();
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
	public PlanoAdicionar() {
		setTitle("Adicionar Plano");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 22, 414, 216);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbPlano_Tipo = new JLabel("Tipo de Plano");
		lbPlano_Tipo.setBounds(22, 27, 94, 26);
		panel.add(lbPlano_Tipo);
		
		lblPlano_Valor = new JLabel("Valor");
		lblPlano_Valor.setBounds(22, 87, 94, 26);
		panel.add(lblPlano_Valor);
		
		lblPlano_Qtd = new JLabel("Qtd. atividades dispon\u00EDveis");
		lblPlano_Qtd.setBounds(22, 143, 167, 26);
		panel.add(lblPlano_Qtd);
		
		textFieldPlano_Tipo = new JTextField();
		textFieldPlano_Tipo.setBounds(103, 30, 86, 20);
		panel.add(textFieldPlano_Tipo);
		textFieldPlano_Tipo.setColumns(10);
		
		textFieldPlano_Valor = new JTextField();
		textFieldPlano_Valor.setColumns(10);
		textFieldPlano_Valor.setBounds(103, 90, 86, 20);
		panel.add(textFieldPlano_Valor);
		
		textFieldPlano_Qtd = new JTextField();
		textFieldPlano_Qtd.setColumns(10);
		textFieldPlano_Qtd.setBounds(182, 146, 86, 20);
		panel.add(textFieldPlano_Qtd);
		
		btnButtonPlano_Adicionar = new JButton("Adicionar");
		btnButtonPlano_Adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Plano p = new Plano();
				PlanoDAO dao = new PlanoDAO();
				try {
					//ARMAZENA O CONTEUDO DIGITADO DAS CAIXAS NAS VARIAVEIS
					p.setTipoPlano(textFieldPlano_Tipo.getText());
					p.setValor(Float.parseFloat(textFieldPlano_Valor.getText()));
					p.setQtd(Integer.parseInt(textFieldPlano_Qtd.getText()));
					//INSERI NO BANCO DE DADOS
					dao.create(p);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());					
				}
				
			
				//RESETA OS CAMPOS
				textFieldPlano_Tipo.setText("");
				textFieldPlano_Valor.setText("");
				textFieldPlano_Qtd.setText("");
				
			}
		});
		btnButtonPlano_Adicionar.setBounds(10, 193, 89, 23);
		panel.add(btnButtonPlano_Adicionar);
	}

}
