package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Pessoa;

public class PessoaDAO {
	
	private Connection con = null;
	
	public PessoaDAO() {
		con = Conexao.getConnection();
	}
	
	public void addPessoa(Pessoa p) {
		
		String sql = "INSERT INTO pessoa (cpf, nome, sobrenome, email, senioridade, tecnologia, experiencia) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			con = Conexao.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, p.getCpf());
			stmt.setString(2, p.getNome());
			stmt.setString(3, p.getSobrenome());
			stmt.setString(4, p.getEmail());
			stmt.setString(5, p.getSenioridade());
			stmt.setString(6, p.getTecnologia());
			stmt.setString(7, p.getExperiencia());
			
			stmt.execute();
			System.out.println("Cadastro realizado com sucesso!");
			
		} catch (SQLException ex) {
			System.out.println("Erro: " +ex);
			
		}finally {
			Conexao.closeConnection(con);
		}
	}
	
	
	public ArrayList<Pessoa> mostrar_pessoas() {
		
		ArrayList<Pessoa> retorno = new ArrayList<>();
		
		String sql = "SELECT * FROM pessoa";
		
		try {
			con = Conexao.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Pessoa p = new Pessoa();
				
				p.setCpf(rs.getInt("cpf"));
				p.setNome(rs.getString("nome"));
				p.setSobrenome(rs.getString("sobrenome"));
				p.setEmail(rs.getString("email"));
				p.setSenioridade(rs.getString("senioridade"));
				p.setTecnologia(rs.getString("tecnologia"));
				p.setExperiencia(rs.getString("experiencia"));
				
				retorno.add(p);
			}
			
			rs.close();
			
			return retorno;
			
		} catch (SQLException ex) {
			System.out.println("Erro: " +ex);
			return null;
		}finally {
			Conexao.closeConnection(con);
		}
	}
	
	
	public void deletePessoaByName(Integer cpf) {
		
		String sql ="DELETE FROM pessoa WHERE cpf = ?";
		
		try {
			con = Conexao.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, cpf);
			stmt.executeUpdate();
			
			System.out.println("Pessoa deletada com sucesso!");
					
		} catch (SQLException ex) {
			System.out.println("Erro: " +ex);
		}finally {
			Conexao.closeConnection(con);
		}
	}
	
	
	public Pessoa acharPessoa(Integer cpf) {
		
		Pessoa p = new Pessoa();
		
		String sql = "SELECT * FROM pessoa WHERE cpf = ?";
		
		try {
			con = Conexao.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, cpf);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				p.setCpf(rs.getInt("cpf"));
				p.setNome(rs.getString("nome"));
				p.setSobrenome(rs.getString("sobrenome"));
				p.setEmail(rs.getString("email"));
				p.setSenioridade(rs.getString("senioridade"));
				p.setTecnologia(rs.getString("tecnologia"));
				p.setExperiencia(rs.getString("experiencia"));	
			}
			return p;
			
		} catch (SQLException ex) {
			System.out.println("Erro: "+ex);
			return null;
		}finally {
			Conexao.closeConnection(con);
		}
	}
	
	
	public void alterarPessoa(Integer cpf,  String nome, String sobrenome, String email, 
			String senioridade, String tecnologia, String experiencia) {
		
		String sql = "UPDATE pessoa SET nome = ?, sobrenome = ?, "
				+ "email = ?, senioridade = ?, tecnologia = ?, experiencia = ? WHERE cpf = ?";
		
		try {
			con = Conexao.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			
			stmt.setString(1, nome);
			stmt.setString(2, sobrenome);
			stmt.setString(3, email);
			stmt.setString(4, senioridade);
			stmt.setString(5, tecnologia);
			stmt.setString(6, experiencia);
			stmt.setInt(7, cpf);
			stmt.executeUpdate();
			System.out.println("Pessoa atualizada.");
			
		} catch (SQLException ex) {
			System.out.println("Erro: "+ex);
		}finally {
			Conexao.closeConnection(con);
		}
	}
}
