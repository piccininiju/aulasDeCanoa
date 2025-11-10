import java.util.ArrayList;

public class GestorAlunos {
    private ArrayList<Aluno> todosAlunos;

    public GestorAlunos() {
        todosAlunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        todosAlunos.add(aluno);
    }

    public void renovarAulasMensais() {
        try {
            for (Aluno aluno : todosAlunos) {
                if (aluno.isMensalidadePaga()) {
                    aluno.setSaldoAulas(aluno.getPlano().getQntAulas());
                } else {
                    aluno.setSaldoAulas(0);
                    System.out.println("\n" + aluno.getNome() + " nao pagou a mensalidade, saldo nao renovado.");
                }
            }
            System.out.println("\nRenovacao mensal concluida com sucesso!");
        } catch (Exception e) {
            System.out.println("\nErro ao renovar aulas mensais: " + e.getMessage());
        }
    }
}
