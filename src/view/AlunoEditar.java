package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.beans.Aluno;
import model.dao.AlunoDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlunoEditar extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lb;
	private JTextField nome;
	private JLabel lb_1;
	private JTextField telefone;
	private JLabel lb_2;
	private JTextField dtnascimento;
	private JLabel Logradouro;
	private JTextField Nlogradouro;
	private JTextField logradouro;
	private JLabel lb_3;
	private JLabel Bairro;
	private JTextField bairro;
	private JLabel lblCidade;
	private JTextField cep;
	private JTextField Cidade;
	private JLabel lb_4;
	private JLabel lb_5;
	private JTextField dtMatricula;
	private JLabel lblAltura;
	private JTextField peso;
	private JTextField altura;
	private JLabel lb_6;
	private JLabel lb_7;
	private JTextField senha;
	private JButton btnButtonPlano_Confirmar;
	private JLabel lblCdigo;
	private JTextField Codigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoEditar frame = new AlunoEditar();
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
	public AlunoEditar() {
		setTitle("Editar aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lb.setBounds(10, 48, 94, 26);
		panel.add(lb);
		
		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(91, 51, 159, 20);
		panel.add(nome);
		
		lb_1 = new JLabel("Telefone");
		lb_1.setBounds(10, 85, 94, 26);
		panel.add(lb_1);
		
		telefone = new JTextField();
		telefone.setColumns(10);
		telefone.setBounds(91, 88, 159, 20);
		panel.add(telefone);
		
		lb_2 = new JLabel("Data de nascimento");
		lb_2.setBounds(10, 122, 115, 26);
		panel.add(lb_2);
		
		dtnascimento = new JTextField();
		dtnascimento.setColumns(10);
		dtnascimento.setBounds(118, 125, 132, 20);
		panel.add(dtnascimento);
		
		Logradouro = new JLabel("Logradouro");
		Logradouro.setBounds(10, 161, 94, 26);
		panel.add(Logradouro);
		
		Nlogradouro = new JTextField();
		Nlogradouro.setColumns(10);
		Nlogradouro.setBounds(91, 201, 44, 20);
		panel.add(Nlogradouro);
		
		logradouro = new JTextField();
		logradouro.setColumns(10);
		logradouro.setBounds(91, 164, 159, 20);
		panel.add(logradouro);
		
		lb_3 = new JLabel("N \u00B0 logradouro");
		lb_3.setBounds(10, 198, 94, 26);
		panel.add(lb_3);
		
		Bairro = new JLabel("Bairro");
		Bairro.setBounds(10, 235, 94, 26);
		panel.add(Bairro);
		
		bairro = new JTextField();
		bairro.setColumns(10);
		bairro.setBounds(91, 238, 159, 20);
		panel.add(bairro);
		
		lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 272, 94, 26);
		panel.add(lblCidade);
		
		cep = new JTextField();
		cep.setColumns(10);
		cep.setBounds(91, 312, 86, 20);
		panel.add(cep);
		
		Cidade = new JTextField();
		Cidade.setColumns(10);
		Cidade.setBounds(91, 275, 159, 20);
		panel.add(Cidade);
		
		lb_4 = new JLabel("CEP");
		lb_4.setBounds(10, 309, 94, 26);
		panel.add(lb_4);
		
		lb_5 = new JLabel("Data de matr\u00EDcula");
		lb_5.setBounds(283, 11, 94, 26);
		panel.add(lb_5);
		
		dtMatricula = new JTextField();
		dtMatricula.setColumns(10);
		dtMatricula.setBounds(391, 14, 99, 20);
		panel.add(dtMatricula);
		
		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(288, 50, 94, 26);
		panel.add(lblAltura);
		
		peso = new JTextField();
		peso.setColumns(10);
		peso.setBounds(369, 90, 86, 20);
		panel.add(peso);
		
		altura = new JTextField();
		altura.setColumns(10);
		altura.setBounds(369, 53, 86, 20);
		panel.add(altura);
		
		lb_6 = new JLabel("Peso");
		lb_6.setBounds(288, 87, 94, 26);
		panel.add(lb_6);
		
		lb_7 = new JLabel("Senha");
		lb_7.setBounds(288, 124, 94, 26);
		panel.add(lb_7);
		
		senha = new JTextField();
		senha.setColumns(10);
		senha.setBounds(369, 127, 121, 20);
		panel.add(senha);
		
		btnButtonPlano_Confirmar = new JButton("Confirmar");
		btnButtonPlano_Confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AlunoDAO dao = new AlunoDAO();
				Aluno aluno = new Aluno();
				
				aluno.setNome(nome.getText());
				aluno.setTelefone(telefone.getText());
				aluno.setDtNasc(dtnascimento.getText());
				aluno.setLogradouro(logradouro.getText());
				aluno.setNumeroLogradouro(Nlogradouro.getText());
				aluno.setBairro(bairro.getText());
				aluno.setCidade(Cidade.getText());
				aluno.setCep(cep.getText());
				aluno.setDtMatricula(dtMatricula.getText());
				aluno.setAltura(Float.parseFloat(altura.getText()));
				aluno.setPeso(Float.parseFloat(peso.getText()));
				aluno.setSenha(senha.getText());
				aluno.setCodigo(Integer.parseInt(Codigo.getText()));
				
				dao.modify(aluno);
				
			}
		});
		btnButtonPlano_Confirmar.setBounds(10, 346, 89, 23);
		panel.add(btnButtonPlano_Confirmar);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 11, 94, 26);
		panel.add(lblCdigo);
		
		Codigo = new JTextField();
		Codigo.setColumns(10);
		Codigo.setBounds(91, 14, 60, 20);
		panel.add(Codigo);
	}

}
