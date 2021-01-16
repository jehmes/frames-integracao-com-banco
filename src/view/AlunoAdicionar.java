package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AlunoAdicionar extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lb;
	private JTextField Nome;
	private JLabel lb_1;
	private JTextField Telefone;
	private JLabel lb_2;
	private JTextField dtNascimento;
	private JLabel Logradouro;
	private JTextField NLogradouro;
	private JTextField textField_4;
	private JLabel lb_3;
	private JLabel Bairro;
	private JTextField textField_5;
	private JLabel lblCidade;
	private JTextField Cep;
	private JTextField Recife;
	private JLabel lb_5;
	private JLabel lb_6;
	private JTextField dtMatricula;
	private JLabel lblAltura;
	private JTextField Peso;
	private JTextField Altura;
	private JLabel lb_7;
	private JLabel lb_8;
	private JTextField Senha;
	private JButton btnButtonPlano_Adicionar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoAdicionar frame = new AlunoAdicionar();
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
	public AlunoAdicionar() {
		setTitle("Adicionar aluno");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 500, 388);
		contentPane.add(panel);
		
		lb = new JLabel("Nome");
		lb.setBounds(10, 11, 94, 26);
		panel.add(lb);
		
		Nome = new JTextField();
		Nome.setColumns(10);
		Nome.setBounds(91, 14, 159, 20);
		panel.add(Nome);
		
		lb_1 = new JLabel("Telefone");
		lb_1.setBounds(10, 48, 94, 26);
		panel.add(lb_1);
		
		Telefone = new JTextField();
		Telefone.setColumns(10);
		Telefone.setBounds(91, 51, 159, 20);
		panel.add(Telefone);
		
		lb_2 = new JLabel("Data de nascimento");
		lb_2.setBounds(10, 85, 115, 26);
		panel.add(lb_2);
		
		dtNascimento = new JTextField();
		dtNascimento.setColumns(10);
		dtNascimento.setBounds(118, 88, 132, 20);
		panel.add(dtNascimento);
		
		Logradouro = new JLabel("Logradouro");
		Logradouro.setBounds(10, 124, 94, 26);
		panel.add(Logradouro);
		
		NLogradouro = new JTextField();
		NLogradouro.setColumns(10);
		NLogradouro.setBounds(91, 164, 44, 20);
		panel.add(NLogradouro);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(91, 127, 159, 20);
		panel.add(textField_4);
		
		lb_3 = new JLabel("N \u00B0 logradouro");
		lb_3.setBounds(10, 161, 94, 26);
		panel.add(lb_3);
		
		Bairro = new JLabel("Bairro");
		Bairro.setBounds(10, 198, 94, 26);
		panel.add(Bairro);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(91, 201, 159, 20);
		panel.add(textField_5);
		
		lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 235, 94, 26);
		panel.add(lblCidade);
		
		Cep = new JTextField();
		Cep.setColumns(10);
		Cep.setBounds(91, 275, 86, 20);
		panel.add(Cep);
		
		Recife = new JTextField();
		Recife.setColumns(10);
		Recife.setBounds(91, 238, 159, 20);
		panel.add(Recife);
		
		lb_5 = new JLabel("CEP");
		lb_5.setBounds(10, 272, 94, 26);
		panel.add(lb_5);
		
		lb_6 = new JLabel("Data de matr\u00EDcula");
		lb_6.setBounds(10, 309, 94, 26);
		panel.add(lb_6);
		
		dtMatricula = new JTextField();
		dtMatricula.setColumns(10);
		dtMatricula.setBounds(118, 312, 132, 20);
		panel.add(dtMatricula);
		
		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(275, 11, 94, 26);
		panel.add(lblAltura);
		
		Peso = new JTextField();
		Peso.setColumns(10);
		Peso.setBounds(356, 51, 86, 20);
		panel.add(Peso);
		
		Altura = new JTextField();
		Altura.setColumns(10);
		Altura.setBounds(356, 14, 86, 20);
		panel.add(Altura);
		
		lb_7 = new JLabel("Peso");
		lb_7.setBounds(275, 48, 94, 26);
		panel.add(lb_7);
		
		lb_8 = new JLabel("Senha");
		lb_8.setBounds(275, 85, 94, 26);
		panel.add(lb_8);
		
		Senha = new JTextField();
		Senha.setColumns(10);
		Senha.setBounds(356, 88, 121, 20);
		panel.add(Senha);
		
		btnButtonPlano_Adicionar = new JButton("Adicionar");
		btnButtonPlano_Adicionar.setBounds(10, 346, 89, 23);
		panel.add(btnButtonPlano_Adicionar);
	}
}
