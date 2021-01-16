package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.beans.Plano;
import model.dao.PlanoDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlanoExcluir extends JFrame {

	private JPanel contentPane;
	private JLabel lbPlano_Codigo;
	private JTextField textFieldCodigo;
	private JTable table;
	private JScrollPane scrollPane;
	private Button buttonExcluir;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanoExcluir frame = new PlanoExcluir();
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
	public PlanoExcluir() {
		setTitle("Excluir");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbPlano_Codigo = new JLabel("C\u00F3digo");
		lbPlano_Codigo.setBounds(20, 11, 94, 26);
		contentPane.add(lbPlano_Codigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(81, 14, 86, 20);
		contentPane.add(textFieldCodigo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 414, 199);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelo = new DefaultTableModel();
		Object[] column = {"ID", "Tipo", "Valor", "Quantidade"};
		final Object[] row = new Object[4];
		modelo.setColumnIdentifiers(column);
		scrollPane.setViewportView(table);
		table.setModel(modelo);		
		PlanoDAO dao2 = new PlanoDAO();
		//RESETA A TABELA PRA NÃO DUPLICAR
		modelo.setNumRows(0);
		for (Plano p: dao2.readPlanos()) {
			row[0] = p.getId();
			row[1] = p.getTipoPlano();
			row[2] = p.getValor();
			row[3] = p.getQtd();
			modelo.addRow(row);
		}
		
		
		
		buttonExcluir = new Button("Excluir");
		buttonExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Plano p = new Plano();
			
				//RESETA A TABELA PRA NÃO DUPLICAR
				modelo.setNumRows(0);
				
				p.setId(Integer.parseInt(textFieldCodigo.getText()));
				dao2.delete(p);				
				
				for (Plano p1: dao2.readPlanos()) {
					row[0] = p1.getId();
					row[1] = p1.getTipoPlano();
					row[2] = p1.getValor();
					row[3] = p1.getQtd();
					modelo.addRow(row);
				}
				
			}
		});
		buttonExcluir.setBounds(342, 15, 70, 22);
		contentPane.add(buttonExcluir);
	}
}
