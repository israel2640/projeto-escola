package br.com.escola.projeto;

import br.com.escola.projeto.repositories.AlunoRepository;
import br.com.escola.projeto.repositories.AlunoRepositoryLista;
import br.com.escola.projeto.repositories.AlunoRepositoryVetor;
import br.com.escola.projeto.services.AlunoService;
import br.com.escola.projeto.views.AlunoView;

import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
  AlunoRepository alunoRepository = null;

  System.out.println("--- Bem-vindo ao Sistema de Cadastro ---");
  System.out.println("Escolha o modo de armazenamento:");
  System.out.println("1. Vetor (Array - com limite de 100 registros)");
  System.out.println("2. Lista (ArrayList - dinâmico)");
  System.out.print("Opção: ");

  int escolha = -1;
  while (alunoRepository == null) {
   try {
    escolha = Integer.parseInt(scanner.nextLine());
    if (escolha == 1) {
     alunoRepository = new AlunoRepositoryVetor();
     System.out.println("Usando armazenamento em VETOR.");
    } else if (escolha == 2) {
     alunoRepository = new AlunoRepositoryLista();
     System.out.println("Usando armazenamento em LISTA.");
    } else {
     System.out.print("Opção inválida. Tente novamente (1 ou 2): ");
    }
   } catch (NumberFormatException e) {
    System.out.print("Entrada inválida. Digite 1 ou 2: ");
   }
  }

  AlunoService alunoService = new AlunoService(alunoRepository);
  AlunoView alunoView = new AlunoView(alunoService);
  alunoView.mostrarMenu();
  scanner.close();
 }
}
