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
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		List<Funcionario> list = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			System.out.println();
			System.out.println("Emplyoee #" + (i + 1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			
			while (hasId(list, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			list.add(new Funcionario(id, name, salary));
		}
		
		System.out.println();		
		for (Funcionario obj : list) {
			System.out.println(obj);
			}
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		Integer idSalary = sc.nextInt();
		Funcionario fun = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
		
		if (fun == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double porcentagem = sc.nextDouble();
			fun.incrementaSalario(porcentagem);
		}
		
		
		System.out.println();		
		for (Funcionario obj : list) {
			System.out.println(obj);
			}
		
		sc.close();

	}
	
	public static boolean hasId(List<Funcionario> list, int id) {
		Funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
