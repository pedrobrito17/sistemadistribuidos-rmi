package com.ifma.sd.service;

import java.util.ArrayList;

import com.ifma.sd.model.Aluno;
import com.ifma.sd.repository.EscolaRepository;

public class EscolaService {
	
	private EscolaRepository alunos = new EscolaRepository();
	
	public Aluno getAluno(int matricula) {
		return alunos.getAluno(matricula);
	}
	
	public ArrayList<Aluno> getTurma(String turma){
		return alunos.getTurma(turma);
	}

}
