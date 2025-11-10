import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Aluno implements Serializable {
    private String nome;
    private int saldoAulas;
    private boolean mensalidadePaga;
    private Plano plano;
    private static List<Aluno> todosAlunos = new ArrayList<>();

    Aluno(String nome, Plano plano) {
        this.nome = nome;
        this.mensalidadePaga = false;
        this.plano = plano;
        if (this.mensalidadePaga) {
            this.saldoAulas = plano.getQntAulas();
        } else {
            this.saldoAulas = 0;
        }
        todosAlunos.add(this);
    }

    public void pagarMensalidade() {
        this.mensalidadePaga = true;
        this.saldoAulas = plano.getQntAulas();
        System.out.println("\n" + nome + " pagou a mensalidade.");
    }

    public String getNome() {
        return nome;
    }

    public int getSaldoAulas() {
        return saldoAulas;
    }

    public boolean isMensalidadePaga() {
        return mensalidadePaga;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setSaldoAulas(int saldoAulas) {
        this.saldoAulas = saldoAulas;
    }

    public static List<Aluno> getTodosAlunos() {
        return todosAlunos;
    }

}
