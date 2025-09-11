package br.com.escola.projeto.repositories;

import br.com.escola.projeto.models.Aluno;
import java.util.List;
import java.util.Optional;

public interface AlunoRepository {
 void salvar(Aluno aluno);
 Optional<Aluno> buscarPorId(int id);
 Optional<Aluno> buscarPorMatricula(String matricula);
 List<Aluno> listarTodos();
 void atualizar(Aluno aluno);
 boolean remover(int id);
}
