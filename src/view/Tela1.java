package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.Dimension;

public class Tela1 extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMenuPlano;
	private JMenu mnMenuAluno;
	private JMenuItem mntmMenuItemAdicionar;
	private JMenuItem mntmMenuItemEditar;
	private JMenuItem mntmMenuItemExcluir;
	private JMenuItem mntmMenuItemVer;
	private JMenuItem mntmMenuItemAdicionar_1;
	private JMenuItem mntmMenuItemEditar_1;
	private JMenuItem mntmMenuItemExcluir_1;
	private JMenuItem mntmMenuItemVer_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela1 frame = new Tela1();
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
	public Tela1() {
		setTitle("Janela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 32);
		contentPane.add(menuBar);
		
		mnMenuPlano = new JMenu("Plano");
		menuBar.add(mnMenuPlano);
		
		mntmMenuItemAdicionar = new JMenuItem("Adicionar");
		mntmMenuItemAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PlanoAdicionar().setVisible(true);
				
			}
		});
		mnMenuPlano.add(mntmMenuItemAdicionar);
		
		mntmMenuItemEditar = new JMenuItem("Editar");
		mntmMenuItemEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PlanoEditar().setVisible(true);
			}
		});
		mnMenuPlano.add(mntmMenuItemEditar);
		
		mntmMenuItemExcluir = new JMenuItem("Excluir");
		mntmMenuItemExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PlanoExcluir().setVisible(true);
			}
		});
		mnMenuPlano.add(mntmMenuItemExcluir);
		
		mntmMenuItemVer = new JMenuItem("Ver");
		mntmMenuItemVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PlanoVer().setVisible(true);
				
				
			}
		});
		mnMenuPlano.add(mntmMenuItemVer);
		
		mnMenuAluno = new JMenu("Aluno");
		menuBar.add(mnMenuAluno);
		
		mntmMenuItemAdicionar_1 = new JMenuItem("Adicionar");
		mntmMenuItemAdicionar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AlunoAdicionar().setVisible(true);
			}
		});
		mnMenuAluno.add(mntmMenuItemAdicionar_1);
		
		mntmMenuItemEditar_1 = new JMenuItem("Editar");
		mntmMenuItemEditar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AlunoEditar().setVisible(true);
			}
		});
		mnMenuAluno.add(mntmMenuItemEditar_1);
		
		mntmMenuItemExcluir_1 = new JMenuItem("Excluir");
		mntmMenuItemExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AlunoExcluir().setVisible(true);
			}
		});
		mnMenuAluno.add(mntmMenuItemExcluir_1);
		
		mntmMenuItemVer_1 = new JMenuItem("Ver");
		mntmMenuItemVer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AlunoVer().setVisible(true);
			}
		});
		mnMenuAluno.add(mntmMenuItemVer_1);
		
		lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/BG.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(5, 45, 412, 203);
		contentPane.add(lblNewLabel);
	}
}
