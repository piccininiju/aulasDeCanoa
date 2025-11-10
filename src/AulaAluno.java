import java.time.*;
import java.util.ArrayList;

public class AulaAluno extends Aula {
    private ArrayList<Aluno> alunos;
    private ArrayList<Aluno> fila;
    private int cancelamento;

    AulaAluno(int qntCanoas, LocalDate data, LocalTime horaInc) {
        super(qntCanoas, data, horaInc);
        alunos = new ArrayList<>(this.qntAlunos);
        fila = new ArrayList<>();
    }

    public int getCancelamento() {
        return cancelamento;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public ArrayList<Aluno> getFila() {
        return fila;
    }

    public void checkInAula(Aluno aluno, LocalDateTime time) {
        LocalDateTime limite = LocalDateTime.of(super.data, super.horarioInc).minusHours(1);

        try {
            if (time.isAfter(limite)) {
                throw new Exception(
                        "\nCheck-in para " + aluno.getNome() + " so pode ser realizado ate uma hora antes da aula!");
            }
            if (!aluno.isMensalidadePaga()) {
                throw new Exception(
                        "\n" + aluno.getNome() + " nao pagou a mensalidade, entao nao pode fazer check-in aulas!");
            }
            if (aluno.getSaldoAulas() == 0) {
                throw new Exception(
                        "\n" + aluno.getNome() + " tem saldo de aulas insuficiente, check-in nao realizado!");
            }
            if (alunos.contains(aluno)) {
                throw new Exception("\n" + aluno.getNome() + " ja esta com check-in nesta aula!");
            }
            if (alunos.size() < this.qntAlunos) {
                alunos.add(aluno);
                System.out.println("\nCheck-in realizado para " + aluno.getNome() + "!");
            } else {
                fila.add(aluno);
                System.out.println("\nAula sem vagas. " + aluno.getNome() + " foi adicionado(a) a fila de espera.");
            }
        } catch (Exception e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }

    public void cancelaAula(Aluno aluno, LocalDateTime time) {
        try {
            LocalDateTime limite = LocalDateTime.of(super.data, super.horarioInc).minusHours(1);
            boolean estavaNaAula = alunos.remove(aluno);

            if (estavaNaAula) {
                this.cancelamento++;
                if (!time.isAfter(limite)) {
                    System.out.println(
                            "\nAula de " + aluno.getNome() + " cancelada com sucesso, aula nao sera descontada!");
                } else {
                    aluno.setSaldoAulas(aluno.getSaldoAulas() - 1);
                    System.out.println("\nCancelamento da aula de " + aluno.getNome()
                            + " com menos de 1 hora antes, aula descontada.");
                }
            } else {
                System.out.println("\n" + aluno.getNome() + " nao estava agendado para esta aula.");
            }
            if (!fila.isEmpty()) {
                Aluno daFila = fila.remove(0);
                alunos.add(daFila);
                System.out.println("\n" + daFila.getNome() + " entrou na aula a partir da fila de espera.");
            }
        } catch (Exception e) {
            System.out.println("\nErro ao tentar cancelar a aula de " + aluno.getNome() + ": " + e.getMessage());
        }
    }

    public void finalizarAula() {
        try {
            System.out.println("\nAula finalizada. O saldo de aulas dos seguintes alunos foi atualizado: ");
            for (Aluno aluno : alunos) {
                if (aluno.getSaldoAulas() > 0) {
                    aluno.setSaldoAulas(aluno.getSaldoAulas() - 1);
                    System.out.println(aluno.getNome());
                }
            }
        } catch (Exception e) {
            System.out.println("\nErro ao finalizar a aula: " + e.getMessage());
        }
    }

}
