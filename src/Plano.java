import java.io.Serializable;

public class Plano implements Serializable {
    private int valor;
    private int qntAulas;

    Plano(int valor, int qntAulas) {
        this.valor = valor;
        this.qntAulas = qntAulas;
    }

    public int getValor() {
        return valor;
    }

    public int getQntAulas() {
        return qntAulas;
    }
}
