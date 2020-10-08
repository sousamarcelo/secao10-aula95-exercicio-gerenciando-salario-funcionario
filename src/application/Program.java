package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		//Funcionario funcionario = null;

		System.out.print("Quantos funcionarios deseja registrar?: ");
		int quantidadeDeFuncionarios = sc.nextInt();
		List<Funcionario> lista = new ArrayList<>();

		for (int i = 0; i < quantidadeDeFuncionarios; i++) {
			sc.nextLine();
			System.out.println("Funcionario #" + (i+1));
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while (temId(lista, id)) {
				System.out.print("Id ja existe, digite outro Id: ");
				id = sc.nextInt();
			}
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			Double salario = sc.nextDouble();
			 
			lista.add(new Funcionario(id, nome, salario));

			System.out.println();
		}
		System.out.println();
		System.out.print("Insira o ID do funcionario que tera o aumento de salario: ");		
		int id = sc.nextInt(); // observei que o valor para entrar no predicado abaico precisou ser int e não Integer, caso contrario so null
		
		
		Funcionario funcionario = lista.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
		if (funcionario == null) {
			System.out.println("Erro: Id invalido!");
		} else {
			System.out.print("Porcentagem para aumento: ");
			double pocertagem = sc.nextDouble();
			funcionario.aumentar(pocertagem);
		}
			
		System.out.println();
		System.out.println("Lista de Funcionarios: ");
		for (Funcionario f : lista) {
			System.out.println(f.getId() + ", " + f.getNome()+ ", " + String.format("%.2f", f.getSalario()));
		}

		sc.close();

	}
	
	public static boolean temId (List<Funcionario> lista, int id) {
		Funcionario funcionario = lista.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
		return funcionario != null;
	}

}
