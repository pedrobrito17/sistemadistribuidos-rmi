import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import com.ifma.sd.model.Aluno;
import com.ifma.sd.remote.EscolaRemote;

public class Escola {

	private static Scanner input;

	public static void main(String[] args) {
		
		int menu = 0;
		while(menu!=3) {
			menu = Escola.menu();
		}
		System.exit(0);
	}
	
	public static int menu() {

	    int selection;
	    int matricula;
	    String turma;
	    input = new Scanner(System.in);
	
	    /***************************************************/
	    
	    System.out.println("\n\n#########################");
	    System.out.println("MENU");
	    System.out.println("#########################\n");
	    System.out.println("1 - Buscar aluno por matricula");
	    System.out.println("2 - Buscar alunos por turma");
	    System.out.println("3 - Sair");
	
	    selection = input.nextInt();
	    
	    switch (selection) {
	    	case 1:
	    		System.out.println("Matricula: ");
	    		matricula = input.nextInt();
	    		Escola.buscarAluno(matricula);
	    		break;
	    	case 2:
	    		System.out.println("Turma: ");
        		turma = input.next();
        		Escola.buscarTurma(turma);
	        case 3:
        		break;
        	default:
        		break;
	    }
	    return selection;    
	 }
	 
	 public static void buscarAluno(int matricula) {
		EscolaRemote escolaRemote = new EscolaRemote();
		try {
			Aluno aluno = escolaRemote.buscarAluno(1);
			System.out.println("-------------------------\nALUNO\n"
					+ "-------------------------");
			System.out.println("Matricula: "+aluno.getMatricula());
			System.out.println("Nome: "+aluno.getNome());
			System.out.println("Nome da mae: "+aluno.getNomeMae());
			System.out.println("Nome do pai: "+aluno.getNomePai());
			System.out.println("Telefone: "+aluno.getTelefone());
			System.out.println("Turma: "+aluno.getTurma());
		} catch (RemoteException e) {
			System.out.println("Erro ao buscar o objeto: "+e);
		}
	 }
	 
	 public static void buscarTurma(String turma) {
		 EscolaRemote escolaRemote = new EscolaRemote();
			try {
				ArrayList<Aluno> alunos = escolaRemote.buscarAlunos(turma);
				if(alunos.size()==0)
					System.out.println("Turma não encontrada");
				
				for (Aluno aluno : alunos) {
					System.out.println("-------------------------\nALUNO\n"
							+ "-------------------------");
					System.out.println("Matricula: "+aluno.getMatricula());
					System.out.println("Nome: "+aluno.getNome());
					System.out.println("Nome da mae: "+aluno.getNomeMae());
					System.out.println("Nome do pai: "+aluno.getNomePai());
					System.out.println("Telefone: "+aluno.getTelefone());
					System.out.println("Turma: "+aluno.getTurma());
				}
			} catch (RemoteException e) {
				System.out.println("Erro ao buscar o objeto: "+e);
			}
	}
	 




}
