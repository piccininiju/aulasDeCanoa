# 🛶 Simulador de Corrida de Canoa

Projeto desenvolvido como parte da disciplina de Programação Orientada a Objetos (POO), com o objetivo de aplicar conceitos de herança, polimorfismo, encapsulamento, tratamento de exceções, coleções e persistência de dados em Java.

---

## 📘 Descrição

O sistema simula o funcionamento de um clube esportivo que oferece aulas de canoa havaiana, controlando o cadastro de alunos, instrutores, planos, aulas e canoas, além de gerenciar:

- Controle de vagas e capacidade de aulas com base em instrutores e tipos de canoa (OC1, OC2, OC4, OC6);
- Check-in e fila de espera de alunos;
- Controle de mensalidades e saldo de aulas;
- Cancelamentos e regras de débito conforme o horário;
- Relatórios automáticos com informações de presença, cancelamentos e saldo;
- Persistência de dados em arquivo, permitindo salvar e carregar o estado do clube.

---

## 🧠 Conceitos Aplicados

O projeto foi estruturado de forma a demonstrar o uso prático dos principais pilares da Programação Orientada a Objetos:

- Herança e Polimorfismo:
    Classes Participante, Aluno e Instrutor formam uma hierarquia para reaproveitamento de código e especialização de comportamento.
- Encapsulamento:
    Acesso controlado aos atributos através de getters e setters, garantindo consistência dos dados.
- Tratamento de Exceções:
    - Implementação de mensagens claras e exceções personalizadas para situações como:
    - Mensalidade vencida;
    - Saldo de aulas esgotado;
    - Check-in duplicado;
    - Tentativa de check-in fora do horário permitido.
- Coleções Java:
    Utilização de estruturas como ArrayList, LinkedHashSet e Queue para manter ordem de aulas, unicidade e filas de espera.
- Persistência de Dados:
    Serialização de objetos com Serializable, permitindo salvar e carregar o estado completo do sistema.

---

## ⚙️ Funcionalidades Implementadas
- Cadastro de planos, alunos, instrutores e canoas
- Agendamento e check-in de alunos nas aulas
- Controle de vagas e fila de espera
- Cancelamentos com e sem débito de aula
- Registro de “no-show” e cancelamentos tardios
- Finalização de aulas com atualização automática de saldo
- Renovação mensal de aulas
- Geração de relatórios completos
- Salvamento e carregamento de dados (persistência)
---

## 💻 Tecnologias Utilizadas

- **Java 17+**
- Coleções da API Java (ArrayList, LinkedHashSet, Queue)
- java.time (LocalDate, LocalTime, LocalDateTime, YearMonth)
- Serializable (persistência de estado)
- Programação Orientada a Objetos (POO)  
- Console (saída de texto no terminal)

---

## 🧾 Exemplo de Execução

O método main executa um cenário completo de testes, simulando:
- Cadastro de planos e alunos;
- Pagamento de mensalidades;
- Criação de aulas e alocação de canoas/instrutores;
- Check-ins válidos e duplicados;
- Cancelamentos dentro e fora do horário;
- Relatórios antes e depois da finalização das aulas;
- Renovação de saldos mensais;
- Persistência de dados com salvamento e recarregamento. 

---

## 👩‍💻 Autora

**Juliana Piccinini**  
Projeto desenvolvido como parte da disciplina de **Programação Orientada a Objetos**.
