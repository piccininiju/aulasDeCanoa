import java.io.*;
import java.util.*;

public class Relatorio implements Serializable {
    private ArrayList<AulaAluno> aulas;

    public Relatorio() {
        this.aulas = new ArrayList<>();
    }

    public void adicionarAula(AulaAluno aula) {
        aulas.add(aula);
    }

    public void listAulas() {
        try {
            aulas.sort(Comparator.comparing(a -> a.data.atTime(a.horarioInc)));
            System.out.println("\n==== Lista de aulas por data e horario ====");
            int contador = 1;
            for (AulaAluno aula : aulas) {
                System.out.println("Aula " + contador);
                System.out.println("Data: " + aula.data + " | Horario: " + aula.horarioInc);
                contador++;
            }
        } catch (Exception e) {
            System.out.println("\nErro ao listar aulas: " + e.getMessage());
        }
    }

    public void geraRelatorioAula(AulaAluno aula) {
        try {
            System.out.println("\n==== Relatorio da aula ====");
            System.out.println("Data: " + aula.data + " | Horario: " + aula.horarioInc);

            System.out.println("\nAlunos confirmados:");
            for (Aluno a : aula.getAlunos()) {
                System.out.println("- " + a.getNome());
            }

            System.out.println("\nInstrutores:");
            for (Instrutor i : aula.instrutores) {
                System.out.println("- " + i.getNome());
            }

            System.out.println("\nFila de espera:");
            for (Aluno f : aula.getFila()) {
                System.out.println("- " + f.getNome());
            }

            System.out.println("\nQuantidade de cancelamentos: " + aula.getCancelamento());

        } catch (Exception e) {
            System.out.println("\nErro ao imprimir relatorio da aula: " + e.getMessage());
        }
    }

    public void geraRelatorioAlunos() {
        try {
            System.out.println("\n ==== Relatorio dos Alunos ====");
            for (Aluno a : Aluno.getTodosAlunos()) {
                System.out.println("Aluno: " + a.getNome());
                System.out.println("Plano: " + a.getPlano().getQntAulas() + " aulas");
                System.out.println("Saldo atual: " + a.getSaldoAulas());
                System.out.println("Mensalidade paga: " + (a.isMensalidadePaga() ? "sim" : "nao"));
                System.out.println("----------------------------");
            }
        } catch (Exception e) {
            System.out.println("\nErro ao gerar relatorio geral: " + e.getMessage());
        }
    }

    public void salvaArquivo(String nomeArquivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(this);
            System.out.println("\nEstado do sistema salvo com sucesso em " + nomeArquivo);
        } catch (Exception e) {
            System.out.println("\nErro ao salvar dados: " + e.getMessage());
        }
    }

    public static Relatorio carregaArquivo(String nomeArquivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            Relatorio relatorio = (Relatorio) in.readObject();
            System.out.println("\nEstado do sistema carregado de " + nomeArquivo);
            return relatorio;
        } catch (Exception e) {
            System.out.println("\nErro ao carregar dados: " + e.getMessage());
            return new Relatorio();
        }
    }

    public ArrayList<AulaAluno> getAulas() {
        return aulas;
    }
}
