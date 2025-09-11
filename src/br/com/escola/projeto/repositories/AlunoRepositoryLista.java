package br.com.escola.projeto.repositories;

import br.com.escola.projeto.models.Aluno;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AlunoRepositoryLista implements AlunoRepository {
 private List<Aluno> alunos = new ArrayList<>();
 private int proximoId = 1;


 public void salvar(Aluno aluno) {
 aluno.setId(proximoId++);
 alunos.add(aluno);
 }


 public Optional<Aluno> buscarPorId(int id) {
 return alunos.stream()
 .filter(a -> a.getId() == id)
 .findFirst();
 }


 public Optional<Aluno> buscarPorMatricula(String matricula) {
 return alunos.stream()
 .filter(a -> a.getMatricula().equalsIgnoreCase(matricula))
 .findFirst();
 }


 public List<Aluno> listarTodos() {
 return alunos.stream()
 .sorted(Comparator.comparing(Aluno::getNome))
 .collect(Collectors.toList());
 }


 public void atualizar(Aluno alunoAtualizado) {
 buscarPorId(alunoAtualizado.getId()).ifPresent(alunoExistente -> {
 int index = alunos.indexOf(alunoExistente);
 alunos.set(index, alunoAtualizado);
 });
 }


 public boolean remover(int id) {
 return alunos.removeIf(aluno -> aluno.getId() == id);
 }
}
