package model.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.sun.net.httpserver.Authenticator.Result;

import connect.ConnectionFactory;
import model.beans.Aluno;

public class AlunoDAO {

	public void create(Aluno a) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"INSERT INTO aluno(nome_aluno, telefone_aluno, dt_nascimento, logradouro, numero_logradouro, bairro, cidade, cep, "
							+ "dt_matricula, altura, peso, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, a.getNome());
			stmt.setString(2, a.getTelefone());
			stmt.setString(3, a.getDtNasc());
			stmt.setString(4, a.getLogradouro());
			stmt.setString(5, a.getNumeroLogradouro());
			stmt.setString(6, a.getBairro());
			stmt.setString(7, a.getCidade());
			stmt.setString(8, a.getCep());
			stmt.setString(9, a.getDtMatricula());
			stmt.setFloat(10, a.getAltura());
			stmt.setFloat(11, a.getPeso());
			stmt.setString(12, a.getSenha());

			stmt.executeUpdate();

			JOptionPane.showInternalMessageDialog(null, "Salvo com sucesso");

		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao salvar " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<Aluno> readAluno() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Aluno> alunos = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM aluno");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Aluno aluno = new Aluno();
				
				aluno.setCodigo(rs.getInt("cd_matricula"));
				aluno.setNome(rs.getString("nome_aluno"));
				aluno.setTelefone(rs.getString("telefone_aluno"));
				aluno.setDtNasc(rs.getString("dt_nascimento"));
				aluno.setLogradouro(rs.getString("logradouro"));
				aluno.setNumeroLogradouro(rs.getString("numero_logradouro"));
				aluno.setBairro(rs.getString("bairro"));
				aluno.setCidade(rs.getString("cidade"));
				aluno.setCep(rs.getString("cep"));
				aluno.setDtMatricula(rs.getString("dt_matricula"));
				aluno.setAltura(rs.getFloat("altura"));
				aluno.setPeso(rs.getFloat("peso"));
				aluno.setSenha(rs.getString("senha"));

				alunos.add(aluno);
			}

		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao excluir " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return alunos;
	}

	public void modify(Aluno a) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean validador = false;

		try {
			stmt = con.prepareStatement("SELECT * FROM aluno");
			rs = stmt.executeQuery();
			while (rs.next()) {
				if (a.getCodigo() == rs.getInt("cd_matricula")) {
					stmt = con.prepareStatement(
							"UPDATE aluno SET nome_aluno = ?, telefone_aluno = ?, dt_nascimento = convert(datetime, ?,103), logradouro = ?, numero_logradouro = ?, "
									+ "bairro = ?, cidade = ?, cep = ?, dt_matricula = convert(datetime, ?,103), altura = ?, peso = ?, senha = ? WHERE cd_matricula = ? ");
					stmt.setString(1, a.getNome());
					stmt.setString(2, a.getTelefone());
					stmt.setString(3, a.getDtNasc());
					stmt.setString(4, a.getLogradouro());
					stmt.setString(5, a.getNumeroLogradouro());
					stmt.setString(6, a.getBairro());
					stmt.setString(7, a.getCidade());
					stmt.setString(8, a.getCep());
					stmt.setString(9, a.getDtMatricula());
					stmt.setFloat(10, a.getAltura());
					stmt.setFloat(11, a.getPeso());
					stmt.setString(12, a.getSenha());
					stmt.setInt(13, a.getCodigo());

					stmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

					validador = false;
					break;

				} else
					validador = true;
			}

			if (validador) {
				JOptionPane.showMessageDialog(null, "Código não encontrado");
			}

		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao excluir " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
	}

	public void delete(Aluno a) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean validador = false;

		try {
			stmt = con.prepareStatement("SELECT * FROM aluno");
			rs = stmt.executeQuery();
			while (rs.next()) {
				if (a.getCodigo() == rs.getInt("cd_matricula")) {

					stmt = con.prepareStatement("DELETE FROM aluno WHERE cd_matricula = ?");
					stmt.setInt(1, a.getCodigo());
					stmt.executeUpdate();

					JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
					// RESETA O VALIDADOR DO ID
					validador = false;
					break;
				}
			}

			if (validador) {
				JOptionPane.showInternalMessageDialog(null, "O código informado não existe");
			}

		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao excluir " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
	}

}
