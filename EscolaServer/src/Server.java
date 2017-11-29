
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.ifma.sd.remote.EscolaRemote;


public class Server {

	public static final String URL = "//localhost/escolaRemote"; 
	
	public static void main(String[] args) {
		
		System.out.println("Iniciando o servidor...");
		
		Registry registry;
		try {
			registry = LocateRegistry.createRegistry(1080);
			registry.rebind(URL, new EscolaRemote());
		} catch (RemoteException e) {
			System.out.println("Erro ao iniciar o servidor: "+e);
		}
		
		System.out.println("Servidor rodando...");

	}

}
