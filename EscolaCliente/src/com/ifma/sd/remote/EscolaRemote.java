package com.ifma.sd.remote;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import com.ifma.sd.escolainterface.EscolaInterface;
import com.ifma.sd.model.Aluno;

public class EscolaRemote {

	private EscolaInterface escolaRemote;
	
	private static final String URL = "//localhost/escolaRemote";
	
	public EscolaRemote() {
		
		//System.out.println("Iniciando a comunicação com o servidor...");
		
		try { 
			Registry registry = LocateRegistry.getRegistry(1080);
			escolaRemote = (EscolaInterface) registry.lookup(URL);
			//System.out.println("Objeto remoto recebido...");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("Erro ao receber o objeto remoto: "+e);
		}
	}
	
	public Aluno buscarAluno(int matricula) throws RemoteException {
		return escolaRemote.getAluno(matricula);
	}

	public ArrayList<Aluno> buscarAlunos(String turma) throws RemoteException {
		return escolaRemote.getTurma(turma);
	}

}
