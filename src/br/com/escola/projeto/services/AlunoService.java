package br.com.escola.projeto.services;

import br.com.escola.projeto.models.Aluno;
import br.com.escola.projeto.repositories.AlunoRepository;
import br.com.escola.projeto.utils.Validador;

import java.util.List;
import java.util.Optional;

public class AlunoService {

 private AlunoRepository alunoRepository;

 public AlunoService(AlunoRepository alunoRepository) {
  this.alunoRepository = alunoRepository;
 }

 public String cadastrarAluno(String nome, String matricula, String curso, String cpf, String email) {

  if (Validador.isNullOrEmpty(nome) || Validador.isNullOrEmpty(matricula)
          || Validador.isNullOrEmpty(curso) || Validador.isNullOrEmpty(cpf) || Validador.isNullOrEmpty(email)) {
   return "Erro: Todos os campos são obrigatórios!";
  }

  if (!Validador.isNumeric(matricula)) {
   return "Erro: Matrícula deve conter apenas números.";
  }

  if (!Validador.isCpfValido(cpf)) {
   return "Erro: CPF inválido. Use o formato 000.000.000-00.";
  }

  if (!Validador.isEmailValido(email)) {
   return "Erro: E-mail inválido.";
  }

  if (alunoRepository.buscarPorMatricula(matricula).isPresent()) {
   return "Erro: Já existe um aluno cadastrado com esta matrícula.";
  }

  Aluno novoAluno = new Aluno(nome, matricula, curso, cpf, email);
  alunoRepository.salvar(novoAluno);
  return "Aluno cadastrado com sucesso! ID: " + novoAluno.getId();
 }

 public List<Aluno> listarAlunos() {
  return alunoRepository.listarTodos();
 }

 public Optional<Aluno> buscarAlunoPorId(int id) {
  return alunoRepository.buscarPorId(id);
 }

 public Optional<Aluno> buscarAlunoPorMatricula(String matricula) {
  if (Validador.isNullOrEmpty(matricula)) {
   return Optional.empty();
  }
  return alunoRepository.buscarPorMatricula(matricula);
 }

 public String atualizarAluno(int id, String novoNome, String novaMatricula, String novoCurso, String cpf, String email) {

  if (Validador.isNullOrEmpty(novoNome) || Validador.isNullOrEmpty(novaMatricula)
          || Validador.isNullOrEmpty(novoCurso) || Validador.isNullOrEmpty(cpf) || Validador.isNullOrEmpty(email)) {
   return "Erro: Todos os campos são obrigatórios!";
  }

  if (!Validador.isNumeric(novaMatricula)) {
   return "Erro: Matrícula deve conter apenas números.";
  }

  if (!Validador.isCpfValido(cpf)) {
   return "Erro: CPF inválido. Use o formato 000.000.000-00.";
  }

  if (!Validador.isEmailValido(email)) {
   return "Erro: E-mail inválido.";
  }

  Optional<Aluno> alunoOptional = alunoRepository.buscarPorId(id);
  if (!alunoOptional.isPresent()) {
   return "Erro: Aluno com ID " + id + " não encontrado.";
  }

  Optional<Aluno> alunoComMesmaMatricula = alunoRepository.buscarPorMatricula(novaMatricula);
  if (alunoComMesmaMatricula.isPresent() && alunoComMesmaMatricula.get().getId() != id) {
   return "Erro: A matrícula '" + novaMatricula + "' já está em uso por outro aluno.";
  }

  Aluno alunoParaAtualizar = alunoOptional.get();
  alunoParaAtualizar.setNome(novoNome);
  alunoParaAtualizar.setMatricula(novaMatricula);
  alunoParaAtualizar.setCurso(novoCurso);
  alunoParaAtualizar.setCpf(cpf);
  alunoParaAtualizar.setEmail(email);

  alunoRepository.atualizar(alunoParaAtualizar);
  return "Aluno atualizado com sucesso!";
 }

 public String removerAluno(int id) {
  if (!alunoRepository.buscarPorId(id).isPresent()) {
   return "Erro: Aluno com ID " + id + " não encontrado.";
  }

  boolean removido = alunoRepository.remover(id);
  return removido ? "Aluno removido com sucesso." : "Erro ao remover aluno.";
 }
}
