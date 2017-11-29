package com.ifma.sd.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ifma.sd.connection.ConexaoBD;
import com.ifma.sd.model.Aluno;

public class EscolaRepository {
	
	private Connection conn;
	private PreparedStatement prd;
	private ResultSet result;
	private Aluno aluno = null;
	private ArrayList<Aluno> alunos;
	
	public Aluno getAluno(int matricula) {
		String sql = "SELECT * FROM aluno WHERE matricula = ?";
		
		try {
			conn = ConexaoBD.getConexao();
			prd = conn.prepareStatement(sql);
			prd.setInt(1, matricula);
			result = prd.executeQuery();
			
			if(result.first()) {
				aluno = new Aluno();
				aluno.setMatricula(result.getInt("matricula"));
				aluno.setNome(result.getString("nome"));
				aluno.setNomeMae(result.getString("nome_mae"));
				aluno.setNomePai(result.getString("nome_pai"));
				aluno.setTelefone(result.getString("telefone"));
				aluno.setTurma(result.getString("turma"));
				return aluno;
			}
		} catch (SQLException e) {
			System.out.println("Erro sql: "+e);
		}finally {
			try {
				prd.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar conexao: "+e);
			}
		}
		return aluno;
	}
	
	public ArrayList<Aluno> getTurma(String turma){
		String sql = "SELECT * FROM aluno WHERE turma = ?";
		alunos = new ArrayList<Aluno>();
		
		try {
			conn = ConexaoBD.getConexao();
			prd = conn.prepareStatement(sql);
			prd.setString(1,  turma);
			result = prd.executeQuery();
			
			if(result.next()) {
				aluno = new Aluno();
				aluno.setMatricula(result.getInt("matricula"));
				aluno.setNome(result.getString("nome"));
				aluno.setNomeMae(result.getString("nome_mae"));
				aluno.setNomePai(result.getString("nome_pai"));
				aluno.setTelefone(result.getString("telefone"));
				aluno.setTurma(result.getString("turma"));
				alunos.add(aluno);
			}
			return alunos;
			
		}catch (SQLException e) {
			System.out.println("Erro sql: "+e);
		}finally {
			try {
				prd.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar conexao: "+e);
			}
		}
		return alunos;
	}

}
