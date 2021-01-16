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

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlunoExcluir extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lbPlano_Codigo;
	private JTextField codigo;
	private Button buttonExcluir;
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
					AlunoExcluir frame = new AlunoExcluir();
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
	public AlunoExcluir() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1185, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 1149, 473);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbPlano_Codigo = new JLabel("C\u00F3digo");
		lbPlano_Codigo.setBounds(10, 11, 94, 26);
		panel.add(lbPlano_Codigo);
		
		codigo = new JTextField();
		codigo.setColumns(10);
		codigo.setBounds(71, 14, 86, 20);
		panel.add(codigo);
				
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 1129, 403);
		panel.add(scrollPane);
		
		table = new JTable();
		modelo = new DefaultTableModel();
		Object[] column = {"Código", "Nome", "Telefone", "Data nascimento", "Logradouro", "N° logradouro", "Bairro", "Cidade", "CEP", "Data matricula", "Altura", "Peso", "Senha"};
		final Object[] row = new Object[13];
		modelo.setColumnIdentifiers(column);
		scrollPane.setViewportView(table);
		table.setModel(modelo);		
		AlunoDAO dao2 = new AlunoDAO();
		//RESETA A TABELA PRA NÃO DUPLICAR
		modelo.setNumRows(0);
		for(Aluno aluno: dao2.readAluno()) {
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
		
		buttonExcluir = new Button("Excluir");
		buttonExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Aluno a = new Aluno();
				a.setCodigo(Integer.parseInt(codigo.getText()));
				dao2.delete(a);
				
				modelo.setNumRows(0);
				for(Aluno aluno: dao2.readAluno()) {
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
		});
		buttonExcluir.setBounds(1054, 14, 70, 22);
		panel.add(buttonExcluir);
	
	}
	

}
