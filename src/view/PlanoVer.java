package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.beans.Plano;
import model.dao.PlanoDAO;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class PlanoVer extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanoVer frame = new PlanoVer();
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
	public PlanoVer() {
		setTitle("Planos cadastrados");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 400, 419);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelo = new DefaultTableModel();
		Object[] column = {"ID", "Tipo", "Valor", "Quantidade"};
		final Object[] row = new Object[4];
		modelo.setColumnIdentifiers(column);
		scrollPane.setViewportView(table);
		table.setModel(modelo);	
		
		PlanoDAO dao = new PlanoDAO();		
		//PREENCHE AS COLUNAS COM OS DADOS CADASTRADO NO BANCO
		for(Plano plano: dao.readPlanos()) {
			row[0] = plano.getId();
			row[1] = plano.getTipoPlano();
			row[2] = plano.getValor();
			row[3] = plano.getQtd();
			modelo.addRow(row);
			
		}
		
	}
}
