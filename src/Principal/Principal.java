package Principal;

import java.util.Scanner;
import Beans.*;
import DAO.PessoaDAO;


public class Principal {
	public static void main(String[] args) {
		
		Principal m = new Principal();
		m.menu();
	}

	public Scanner getScanner() {
		return new Scanner(System.in);
	}
	
	public void menu() {
		
		System.out.println("1 - CADASTRAR PESSOAS");
		System.out.println("2 - LISTAR PESSOAS");
		System.out.println("3 - ALTERAR PESSOAS");
		System.out.println("4 - EXCLUIR PESSOAS");
		System.out.println("5 - SAIR");
		System.out.print("Opção:");
		int op = getScanner().nextInt();
		
		switch (op) {
		case 1: {
			addPessoa();
			}
		case 2: {
			listar_pessoa();
		}
		case 3: {
			alterar_pessoa();
		}
		case 4: {
			excluir_pessoa();
		}
		case 5: {
			System.exit(0);
		}
		default:
			System.out.println("Digite uma opção valida!");
			menu();
		}
		
	}
	
	private void addPessoa() {
		System.out.println("Digite o CPF:");
		int cpf = getScanner().nextInt();
		System.out.println("Digite o nome: ");
		String nome = getScanner().nextLine();
		System.out.println("Digite o sobrenome: ");
		String sobrenome = getScanner().nextLine();
		System.out.println("Digite o email: ");
		String email = getScanner().nextLine();
		System.out.println("Digite a senioridade: ");
		String senioridade = getScanner().nextLine();		
		System.out.println("Digite as tecnologias que trabalha.");
		String tecnologia = getScanner().nextLine();
		System.out.println("Digite alguma experiência de projeto trabalhado:");
		String experiencia = getScanner().nextLine();
			
		
		Pessoa p = new Pessoa(cpf, nome, sobrenome, email, senioridade, tecnologia, experiencia);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.addPessoa(p);
		
		menu();
		
	}
	
	public void listar_pessoa() {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		System.out.println("Todas as pessoas cadastradas:");
		
		for (Pessoa p : pessoaDAO.mostrar_pessoas()) {
			
			System.out.println("\nCPF: " + p.getCpf());
			System.out.println("Nome: " + p.getNome());
			System.out.println("Sobrenome: " + p.getSobrenome());
			System.out.println("Email: " + p.getEmail());
			System.out.println("Senioridade: " + p.getSenioridade());
			System.out.println("Tecnologias: " + p.getTecnologia());
			System.out.println("Experiências: " + p.getExperiencia() + "\n");
		}
		menu();
	}
	
	public void excluir_pessoa() {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		System.out.println("\nDigite o CPF para excluir a pessoa do cadastro:");
		
		int cpf = getScanner().nextInt();
		
		pessoaDAO.deletePessoaByName(cpf);
		menu();
	}
	
	public void alterar_pessoa() {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		System.out.println("Digite o CPF para alterar os dados da pessoa:");
		int cpf = getScanner().nextInt();
		
		Pessoa p = pessoaDAO.acharPessoa(cpf);
		
		System.out.println("Alterando as informações:");
		System.out.println("Nome: " + p.getNome());
		System.out.println("Sobrenome: " + p.getSobrenome());
		System.out.println("Email: " + p.getEmail());
		System.out.println("Senioridade: " + p.getSenioridade());
		System.out.println("Tecnologia: " + p.getTecnologia());
		System.out.println("Experiências: " + p.getExperiencia() + "\n");
		
		
		System.out.println("Digite as novas informações:");
		System.out.println("Digite o nome: ");
		String nome = getScanner().nextLine();
		System.out.println("Digite o sobrenome: ");
		String sobrenome = getScanner().nextLine();
		System.out.println("Digite o email: ");
		String email = getScanner().nextLine();
		System.out.println("Digite a senioridade: ");
		String senioridade = getScanner().nextLine();		
		System.out.println("Digite as tecnologias que trabalha.");
		String tecnologia = getScanner().nextLine();
		System.out.println("Digite alguma experiência de projeto trabalhado:");
		String experiencia = getScanner().nextLine();
		
		pessoaDAO.alterarPessoa(p.getCpf(), nome, sobrenome, email, senioridade, tecnologia, experiencia);
		menu();



		
	}
}
