package com.ifma.sd.escolainterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.ifma.sd.model.Aluno;

public interface EscolaInterface extends Remote {
	
	public Aluno getAluno(int matricula) throws RemoteException;
	
	public ArrayList<Aluno> getTurma(String turma) throws RemoteException;
	
}
