package br.com.uniara.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.uniara.model.Aluno;

public class AlunoDAO {

	private static final String SQL_INSERT = "INSERT INTO "
			+ "aluno (ra, nome, sobrenome, idade, curso) "
			+ "values(?,?,?,?,?);";
	
	private static final String SQL_SELECT = "SELECT * FROM aluno;";
	
	public static void salvar(Aluno aluno) throws SQLException {
		
		Connection conexao = ConnectionMySql.getConexaoMySQL();
		
		PreparedStatement ps = conexao.prepareStatement(SQL_INSERT);
		
		ps.setInt(1, aluno.getRa());
		ps.setString(2, aluno.getNome());
		ps.setString(3, aluno.getSobrenome());
		ps.setInt(4, aluno.getIdade());
		ps.setInt(5, aluno.getCurso());
		
		ps.execute();

	}
	public static String obterTudo() throws SQLException {
		
		Connection conexao = ConnectionMySql.getConexaoMySQL();
		PreparedStatement ps = conexao.prepareStatement(SQL_SELECT);
		ResultSet rs = ps.executeQuery();
		StringBuilder sb = new StringBuilder();
		while(rs.next()) {
			sb.append("\nAluno\nRA: ").append(rs.getInt(1))
			.append(" Nome: ").append(rs.getString(2))
			.append(" Sobrenome: ").append(rs.getString(3))
			.append(" Idade: ").append(rs.getInt(4))
			.append(" Curso: ").append(rs.getInt(5))
			.append("\n\n");
			
		}
		
		return sb.toString();
	}
	

}
