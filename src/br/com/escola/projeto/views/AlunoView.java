package br.com.escola.projeto.views;

import br.com.escola.projeto.models.Aluno;
import br.com.escola.projeto.services.AlunoService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AlunoView {

    private AlunoService alunoService;
    private Scanner scanner;

    public AlunoView(AlunoService alunoService) {
        this.alunoService = alunoService;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n===== Sistema de Cadastro de Alunos =====");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Buscar aluno por ID");
            System.out.println("4 - Buscar aluno por matrícula");
            System.out.println("5 - Atualizar aluno");
            System.out.println("6 - Remover aluno");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> listarAlunos();
                case 3 -> buscarAlunoPorId();
                case 4 -> buscarAlunoPorMatricula();
                case 5 -> atualizarAluno();
                case 6 -> removerAluno();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarAluno() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Curso: ");
        String curso = scanner.nextLine();
        System.out.print("CPF (000.000.000-00): ");
        String cpf = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        String resultado = alunoService.cadastrarAluno(nome, matricula, curso, cpf, email);
        System.out.println(resultado);
    }

    private void listarAlunos() {
        List<Aluno> alunos = alunoService.listarAlunos();
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            alunos.forEach(System.out::println);
        }
    }

    private void buscarAlunoPorId() {
        System.out.print("Digite o ID do aluno: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Optional<Aluno> aluno = alunoService.buscarAlunoPorId(id);
        aluno.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Aluno não encontrado.")
        );
    }


    private void buscarAlunoPorMatricula() {
        System.out.print("Digite a matrícula do aluno: ");
        String matricula = scanner.nextLine();

        Optional<Aluno> aluno = alunoService.buscarAlunoPorMatricula(matricula);
        aluno.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Aluno não encontrado.")
        );
    }


    private void atualizarAluno() {
        System.out.print("ID do aluno a atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Novo curso: ");
        String curso = scanner.nextLine();
        System.out.print("Novo CPF (000.000.000-00): ");
        String cpf = scanner.nextLine();
        System.out.print("Novo E-mail: ");
        String email = scanner.nextLine();

        String resultado = alunoService.atualizarAluno(id, nome, matricula, curso, cpf, email);
        System.out.println(resultado);
    }

    private void removerAluno() {
        System.out.print("ID do aluno a remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String resultado = alunoService.removerAluno(id);
        System.out.println(resultado);
    }

    public void exibirMenu() {

    }
}
