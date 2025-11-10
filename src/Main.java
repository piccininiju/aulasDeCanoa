import java.time.*;

public class Main {
    public static void main(String[] argas) throws Exception {

        // Criando planos de aula
        Plano plano1 = new Plano(200, 4); // plano com valor 200 e 4 aulas
        Plano plano2 = new Plano(350, 8); // plano com valor 350 e 8 aulas

        // Criando alunos
        Aluno aluno1 = new Aluno("Yago", plano1);
        aluno1.pagarMensalidade(); // aluno pagou a mensalidade
        Aluno aluno2 = new Aluno("Ariel", plano2);
        aluno2.pagarMensalidade();
        Aluno aluno3 = new Aluno("Ana", plano2);
        aluno3.pagarMensalidade();
        Aluno aluno4 = new Aluno("Helena", plano2); // ainda não pagou

        // Gestor alunos
        GestorAlunos gestorAlunos = new GestorAlunos();
        gestorAlunos.adicionarAluno(aluno1);
        gestorAlunos.adicionarAluno(aluno2);
        gestorAlunos.adicionarAluno(aluno3);
        gestorAlunos.adicionarAluno(aluno4);

        // Criando instrutores
        Instrutor instrutor1 = new Instrutor("Mauricio");
        Instrutor instrutor2 = new Instrutor("Julia");
        Instrutor instrutor3 = new Instrutor("Gabriel");

        // Criando canoas
        Canoa canoa1 = new Canoa(TipoCanoa.OC1);
        Canoa canoa2 = new Canoa(TipoCanoa.OC2);
        Canoa canoa3 = new Canoa(TipoCanoa.OC4);
        Canoa canoa4 = new Canoa(TipoCanoa.OC6);

        // Criando a primeira aula
        AulaAluno aula1 = new AulaAluno(2, LocalDate.of(2025, 10, 10), LocalTime.of(6, 0));
        aula1.addCanoa(canoa3);
        aula1.addCanoa(canoa2);
        aula1.addInstrutor(instrutor1);
        aula1.addInstrutor(instrutor2);
        aula1.calculaAlunos(); // calcula a quantidade de alunos que a aula suporta

        // Agendando alunos para a aula
        aula1.checkInAula(aluno1, LocalDateTime.of(2025, 4, 10, 15, 0));
        aula1.checkInAula(aluno2, LocalDateTime.of(2025, 5, 10, 20, 0));
        aula1.checkInAula(aluno3, LocalDateTime.of(2025, 9, 10, 5, 0));
        aula1.checkInAula(aluno4, LocalDateTime.of(2025, 9, 10, 5, 25)); // aluno sem mensalidade paga → vai gerar aviso
        aula1.checkInAula(aluno1, LocalDateTime.of(2025, 9, 10, 10, 0)); // tentativa de duplicado → aviso

        // Cancelamentos de aula1
        aula1.cancelaAula(aluno2, LocalDateTime.of(2025, 9, 10, 12, 30)); // cancelamento dentro do limite
        aula1.cancelaAula(aluno3, LocalDateTime.of(2025, 10, 10, 5, 30)); // cancelamento tardio

        // Finalizando aula1
        aula1.finalizarAula(); // decrementa saldo de aulas dos alunos que participaram

        // Criando a segunda aula
        AulaAluno aula2 = new AulaAluno(3, LocalDate.of(2025, 11, 10), LocalTime.of(8, 0));
        aula2.addCanoa(canoa2);
        aula2.addCanoa(canoa1);
        aula2.addCanoa(canoa1);
        aula2.addInstrutor(instrutor3);
        aula2.addInstrutor(instrutor1);
        aula2.calculaAlunos(); // calcula a capacidade da aula

        // Agendando alunos para a aula2
        aula2.checkInAula(aluno1, LocalDateTime.of(2025, 10, 10, 5, 0));
        aula2.checkInAula(aluno2, LocalDateTime.of(2025, 9, 10, 21, 0));
        aula2.checkInAula(aluno3, LocalDateTime.of(2025, 11, 10, 3, 0));

        // Cancelamento aula2
        aula2.cancelaAula(aluno1, LocalDateTime.of(2025, 10, 10, 7, 0));

        // Finalizando aula2
        aula2.finalizarAula();

        // Criando e utilizando o relatório
        Relatorio relatorio = new Relatorio();

        relatorio.adicionarAula(aula1);
        relatorio.adicionarAula(aula2);

        // Listar aulas por data e horario
        relatorio.listAulas();

        // Gera um relatório das aulas
        relatorio.geraRelatorioAula(aula1);
        relatorio.geraRelatorioAula(aula2);

        // Gerar relatorio dos alunos
        relatorio.geraRelatorioAlunos();

        // Simular renovação mensal
        gestorAlunos.renovarAulasMensais();
        relatorio.geraRelatorioAlunos();

        // Persistencia de dados
        relatorio.salvaArquivo("DadosTeste");
        Relatorio.carregaArquivo("DadosTeste");
    }
}
