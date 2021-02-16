package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados da conta:");
		System.out.print("Número da conta: ");
		Integer number = sc.nextInt();
		System.out.print("Nome do titular: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double balance = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println("");
		System.out.print("Qual é o saldo de saque: ");
		double saque = sc.nextDouble();
		try {
			account.withdraw(saque);
			System.out.println("Novo valor: "+ String.format("%.2f", account.getBalance()));
			
		} catch (DomainException e) {
			System.out.println("Erro ao fazer saque " + e.getMessage());
		}
		
		
		sc.close();
	}

}
