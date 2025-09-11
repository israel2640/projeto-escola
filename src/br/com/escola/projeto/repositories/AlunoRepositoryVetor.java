package br.com.escola.projeto.repositories;

import br.com.escola.projeto.models.Aluno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AlunoRepositoryVetor implements AlunoRepository {
 private static final int TAMANHO_MAXIMO = 100;
 private Aluno[] alunos = new Aluno[TAMANHO_MAXIMO];
 private int proximoId = 1;
 private int totalAlunos = 0;


 public void salvar(Aluno aluno) {
 if (totalAlunos >= TAMANHO_MAXIMO) {
 System.out.println("Erro: Capacidade máxima de armazenamento atingida.");
 return;
 }
 aluno.setId(proximoId++);
 alunos[totalAlunos++] = aluno;
 }


 public Optional<Aluno> buscarPorId(int id) {
 for (int i = 0; i < totalAlunos; i++) {
 if (alunos[i].getId() == id) {
 return Optional.of(alunos[i]);
 }
 }
 return Optional.empty();
 }


 public Optional<Aluno> buscarPorMatricula(String matricula) {
 for (int i = 0; i < totalAlunos; i++) {
 if (alunos[i].getMatricula().equalsIgnoreCase(matricula)) {
 return Optional.of(alunos[i]);
 }
 }
 return Optional.empty();
 }


 public List<Aluno> listarTodos() {
 return Arrays.stream(alunos, 0, totalAlunos)
 .sorted(Comparator.comparing(Aluno::getNome))
 .collect(Collectors.toList());
 }


 public void atualizar(Aluno alunoAtualizado) {
 for (int i = 0; i < totalAlunos; i++) {
 if (alunos[i].getId() == alunoAtualizado.getId()) {
 alunos[i] = alunoAtualizado;
 return;
 }
 }
 }


 public boolean remover(int id) {
 for (int i = 0; i < totalAlunos; i++) {
 if (alunos[i].getId() == id) {
 for (int j = i; j < totalAlunos - 1; j++) {
 alunos[j] = alunos[j + 1];
 }
 alunos[totalAlunos - 1] = null;
 totalAlunos--;
 return true;
 }
 }
 return false;
 }
}
