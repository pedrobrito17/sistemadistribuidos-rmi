package com.ifma.sd.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import com.ifma.sd.escolainterface.EscolaInterface;
import com.ifma.sd.model.Aluno;
import com.ifma.sd.service.EscolaService;

public class EscolaRemote extends UnicastRemoteObject implements EscolaInterface{

	private static final long serialVersionUID = 1L;
	private EscolaService escolaService = new EscolaService();
	
	public EscolaRemote() throws RemoteException {
		super();
		System.out.println("Objeto remoto criado...");
	}

	@Override
	public Aluno getAluno(int matricula) throws RemoteException {
		return escolaService.getAluno(matricula);
	}

	@Override
	public ArrayList<Aluno> getTurma(String turma) throws RemoteException {
		return escolaService.getTurma(turma);
	}

}
