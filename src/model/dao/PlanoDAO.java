package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;



import connect.ConnectionFactory;
import model.beans.Plano;

public class PlanoDAO {

	public void create(Plano p) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			if (p.getTipoPlano().equalsIgnoreCase("B") || p.getTipoPlano().equalsIgnoreCase("P") || p.getTipoPlano().equalsIgnoreCase("O")) {
				stmt = con.prepareStatement("INSERT INTO plano (tipo_plano, valor_plano, qtd_atividades_disponiveis) VALUES (?, ?, ?)");
				stmt.setString(1, p.getTipoPlano());
				stmt.setFloat(2, p.getValor());
				stmt.setInt(3, p.getQtd());
							
				stmt.executeUpdate();
				JOptionPane.showInternalMessageDialog(null, "Salvo com sucesso");
			}
			else JOptionPane.showInternalMessageDialog(null, "Tipo de Plano não existe");
			
				
		} catch (SQLException e) {
			
			JOptionPane.showInternalMessageDialog(null, "Erro ao salvar "+e.getMessage());
			
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
	public List<Plano> readPlanos(){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Plano> planos = new ArrayList<Plano>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM plano");
			rs = stmt.executeQuery();
			//PASSA POR CADA CADASTRO NA LISTA DO BANCO E SALVA EM UMA VARIAVEL TIPO LISTA
			while(rs.next()) {
				
				Plano plano = new Plano();
				
				plano.setId(rs.getInt("cd_plano"));
				plano.setTipoPlano(rs.getString("tipo_plano"));
				plano.setValor(rs.getFloat("valor_plano"));
				plano.setQtd(rs.getInt(("qtd_atividades_disponiveis")));
				
				planos.add(plano);				
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
	
		
		return planos;
	}
	
	public void modify(Plano p) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean validador = false;
		try {
			stmt = con.prepareStatement("SELECT * FROM plano");
			rs = stmt.executeQuery();
			//O WHILE É UM TRATAMENTO PARA VER SE O CODIGO INFORMADO EXISTE NO CADASTRO 
			while(rs.next()) {
				if(p.getId() == rs.getInt("cd_plano")) {
					//FAZ O UPDATE DO CADASTRO BASEADO NO CODIGO(ID)
					stmt = con.prepareStatement("UPDATE plano SET tipo_plano = ?, valor_plano = ?, qtd_atividades_disponiveis = ? WHERE cd_plano = ? ");
					stmt.setString(1, p.getTipoPlano());
					stmt.setFloat(2, p.getValor());
					stmt.setInt(3, p.getQtd());
					stmt.setInt(4, p.getId());
					
					stmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
					
					//RESETA O VALIDADOR DO ID
					validador = false;
					break;					
				} 
				else validador = true;				
			}			
			//MOSTRA NA TELA SE O CODIGO NÃO FOI ENCONTRADO
			if (validador) {
				JOptionPane.showMessageDialog(null, "Código não encontrado");
			}
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao alterar "+e.getMessage());
		}	finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
	}
	
	public void delete(Plano p) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;	
		ResultSet rs = null;
		boolean validador = false;
		try {
			stmt = con.prepareStatement("SELECT * FROM plano");
			rs = stmt.executeQuery();
			//O WHILE É UM TRATAMENTO PARA VER SE O CODIGO INFORMADO EXISTE NO BO CADASTRO 
			while(rs.next()) {
				if(p.getId() == rs.getInt("cd_plano")) {
					//FAZ O UPDATE DO CADASTRO BASEADO NO CODIGO(ID)
					stmt = con.prepareStatement("DELETE FROM plano WHERE cd_plano = ?");
					stmt.setInt(1, p.getId());
					stmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
					//RESETA O VALIDADOR DO ID
					validador = false;
					break;					
				} 
				else validador = true;				
			}
			if (validador) {
				JOptionPane.showInternalMessageDialog(null, "O código informado não existe");
			}
			
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao excluir "+e.getMessage());
			
		}
	}
	
}
