import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;

public class Aula implements Serializable {
    protected ArrayList<Canoa> canoas;
    protected int qntCanoas;
    protected LocalDate data;
    protected LocalTime horarioInc;
    protected ArrayList<Instrutor> instrutores;
    protected int qntAlunos;
    protected int contadorInstrutor;

    Aula(int qntCanoas, LocalDate data, LocalTime horaInc) {
        this.qntCanoas = qntCanoas;
        this.data = data;
        this.horarioInc = horaInc;
        canoas = new ArrayList<>(qntCanoas);
        instrutores = new ArrayList<>();
        this.qntAlunos = 0;
        this.contadorInstrutor = 0;
    }

    public void addCanoa(Canoa canoa) {
        try {
            if (canoas.size() < qntCanoas) {
                canoas.add(canoa);
                System.out.println("\nCanoa " + canoa.getTipo().name() + " (capacidade "
                        + canoa.getCapacidade() + ") adicionada a aula!");
            } else {
                System.out.println("\nNao foi possivel adicionar a canoa " + canoa.getTipo().name()
                        + " (capacidade " + canoa.getCapacidade() + "), maximo de canoas atingido!");
            }
        } catch (Exception e) {
            System.out.println("\nErro ao adicionar a canoa " + canoa.getTipo().name() + ": " + e.getMessage());
        }
    }

    public void addInstrutor(Instrutor instrutor) {
        try {
            LocalDateTime horarioAula = LocalDateTime.of(data, horarioInc);
            if (instrutor.getAulas().contains(horarioAula)) {
                System.out.println("\nO instrutor " + instrutor.getNome() + " nao tem esse horario disponivel!");
            } else {
                instrutores.add(instrutor);
                instrutor.addAula(horarioAula);
                this.contadorInstrutor++;
                System.out.println("\nInstrutor " + instrutor.getNome() + " adicionada a aula!");
            }
        } catch (Exception e) {
            System.out.println("\nErro ao adicionar o instrutor " + instrutor.getNome() + ": " + e.getMessage());
        }
    }

    public void calculaAlunos() {
        try {
            int contadorOC1 = 0;
            for (Canoa c : canoas) {
                if (c.getCapacidade() > 1 && this.contadorInstrutor > 0) {
                    if (c.getCapacidade() == 6) {
                        qntAlunos += 5;
                    } else if (c.getCapacidade() == 4) {
                        qntAlunos += 3;
                    } else if (c.getCapacidade() == 2) {
                        qntAlunos += 1;
                    }
                    this.contadorInstrutor--;
                } else if (c.getCapacidade() == 1) {
                    contadorOC1++;
                }
            }

            while (contadorOC1 >= 2 && this.contadorInstrutor > 0) {
                qntAlunos += 1;
                this.contadorInstrutor--;
                contadorOC1 -= 2;
            }
        } catch (Exception e) {
            System.out.println("\nErro ao calcular alunos: " + e.getMessage());
        }
    }

}
