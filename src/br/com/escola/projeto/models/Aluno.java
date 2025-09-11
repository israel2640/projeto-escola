package br.com.escola.projeto.models;

public class Aluno {
 private int id;
 private String nome;
 private String matricula;
 private String curso;
 private String cpf;
 private String email;

 public Aluno(String nome, String matricula, String curso, String cpf, String email) {
  this.nome = nome;
  this.matricula = matricula;
  this.curso = curso;
  this.cpf = cpf;
  this.email = email;
 }

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getNome() {
  return nome;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }

 public String getMatricula() {
  return matricula;
 }

 public void setMatricula(String matricula) {
  this.matricula = matricula;
 }

 public String getCurso() {
  return curso;
 }

 public void setCurso(String curso) {
  this.curso = curso;
 }

 public String getCpf() {
  return cpf;
 }

 public void setCpf(String cpf) {
  this.cpf = cpf;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }


 public String toString() {
  return "ID: " + id +
          " | Nome: " + nome +
          " | Matrícula: " + matricula +
          " | Curso: " + curso +
          " | CPF: " + cpf +
          " | E-mail: " + email;
 }
}
