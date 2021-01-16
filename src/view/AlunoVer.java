package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.beans.Aluno;
import model.beans.Plano;
import model.dao.AlunoDAO;
import model.dao.PlanoDAO;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AlunoVer extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoVer frame = new AlunoVer();
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
	public AlunoVer() {
		setTitle("Alunos cadastrados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1184, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1148, 408);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelo = new DefaultTableModel();
		Object[] column = {"Código", "Nome", "Telefone", "Data nascimento", "Logradouro", "N° logradouro", "Bairro", "Cidade", "CEP", "Data matricula", "Altura", "Peso", "Senha"};
		final Object[] row = new Object[13];
		modelo.setColumnIdentifiers(column);
		scrollPane.setViewportView(table);
		table.setModel(modelo);	
		
		
		AlunoDAO dao = new AlunoDAO();		
		//PREENCHE AS COLUNAS COM OS DADOS CADASTRADO NO BANCO
		for(Aluno aluno: dao.readAluno()) {
			row[0] = aluno.getCodigo();
			row[1] = aluno.getNome();
			row[2] = aluno.getTelefone();
			row[3] = aluno.getDtNasc();
			row[4] = aluno.getLogradouro();
			row[5] = aluno.getNumeroLogradouro();
			row[6] = aluno.getBairro();
			row[7] = aluno.getCidade();
			row[8] = aluno.getCep();
			row[9] = aluno.getDtMatricula();
			row[10] = aluno.getAltura();
			row[11] = aluno.getPeso();
			row[12] = aluno.getSenha();
			
		
			modelo.addRow(row);
			
		}
	}

}
