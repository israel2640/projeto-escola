# 🚀 Sistema de Cadastro de Alunos em Java

![Status](https://img.shields.io/badge/Status-Concluído-brightgreen)

Aplicação de console (CLI) em Java puro que simula um sistema para gerenciamento de alunos. O projeto foi desenvolvido como uma atividade acadêmica para aplicar conceitos fundamentais de arquitetura de software, programação orientada a objetos e estruturas de dados.

---

## 📚 Contexto do Projeto

Este software foi desenvolvido como parte das atividades da disciplina de **Java**, ministrada pelo professor **Vinicius**, na **ETE Cícero Dias**.

---

## 👥 Equipe

Este projeto foi idealizado e desenvolvido pela seguinte equipe:

* **Israel**
* **Claudio**
* **Airton**
* **Rannikelly**
---

## ✨ Funcionalidades Principais

* **Cadastro de Alunos**: Permite a inclusão de novos alunos com nome, matrícula e curso.
* **Listagem Completa**: Exibe todos os alunos cadastrados, ordenados alfabeticamente pelo nome.
* **Busca Específica**: Busca de alunos por ID ou por matrícula.
* **Atualização de Dados**: Permite editar as informações de um aluno já existente.
* **Remoção de Alunos**: Exclui um aluno do sistema através do seu ID.
* **Seleção de Armazenamento**: O usuário pode escolher no início da execução se deseja usar um Vetor (Array) ou uma Lista (ArrayList) para o armazenamento de dados em memória.

---

## 🛠️ Tecnologias e Conceitos Aplicados

* **Linguagem**: Java 17+
* **Arquitetura**: Padrão **MVC (Model-View-Controller)** para separar as responsabilidades do sistema:
    * **Model**: Classes de domínio (`Aluno`).
    * **View**: Interação com o usuário no console (`AlunoView`).
    * **Controller**: Lógica de negócio e validações (`AlunoService`).
* **Padrão de Projeto**: **Repository Pattern**, que abstrai a camada de acesso a dados através de uma interface (`AlunoRepository`), permitindo a troca das implementações de armazenamento (Vetor e Lista) sem impactar o resto do sistema.
* **Princípios de Orientação a Objetos**:
    * **Encapsulamento**: Proteção dos dados do `Aluno`.
    * **Polimorfismo**: Utilização das diferentes implementações do `AlunoRepository` de forma transparente pelo `AlunoService`.
* **Estrutura de Dados**: Uso de Array (`Vetor`) e `ArrayList` (`Lista`) para armazenamento volátil de dados em memória.
* **Validações**: Tratamento de entradas do usuário para garantir a integridade dos dados.

---

## 📂 Estrutura de Pastas

O projeto foi organizado seguindo a separação de responsabilidades do padrão MVC.

```
src/
└── br/com/escola/projeto/
    ├── Main.java           # Ponto de entrada da aplicação
    ├── models/             # → Camada Model (Entidades)
    │   └── Aluno.java
    ├── repositories/       # → Camada de Acesso a Dados (Interface e Implementações)
    │   ├── AlunoRepository.java
    │   ├── AlunoRepositoryLista.java
    │   └── AlunoRepositoryVetor.java
    ├── services/           # → Camada Controller (Lógica de Negócio)
    │   └── AlunoService.java
    ├── utils/              # → Classes auxiliares
    │   └── Validador.java
    └── views/              # → Camada View (Interação com o Console)
        └── AlunoView.java
```

---

## ⚙️ Como Executar

**Pré-requisitos:**
* Ter o **JDK (Java Development Kit)** versão 17 ou superior instalado.

**Passos:**

1.  **Clone o repositório:**
    ```bash
    git clone (https://github.com/israel2640/projeto-escola)
    ```
2.  **Abra em uma IDE:**
    * Abra o projeto na sua IDE Java de preferência (IntelliJ IDEA, Eclipse, VS Code com extensões Java).
3.  **Execute o projeto:**
    * Encontre o arquivo `Main.java` dentro de `src/br/com/escola/projeto/`.
    * Execute o método `main()` para iniciar a aplicação no console.

A aplicação irá solicitar que você escolha o método de armazenamento (Vetor ou Lista) e, em seguida, exibirá o menu principal.
