import java.io.Serializable;

public class Canoa implements Serializable {
    private TipoCanoa tipo;
    private int capacidade;
    private boolean statusDisponibilidade;

    Canoa(TipoCanoa tipo) {
        this.tipo = tipo;
        this.capacidade = tipo.getCapacidade();
        this.statusDisponibilidade = true;
    }

    public TipoCanoa getTipo() {
        return tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean isStatusDisponibilidade() {
        return statusDisponibilidade;
    }

    public void setStatusDisponibilidade(boolean statusDisponibilidade) {
        this.statusDisponibilidade = statusDisponibilidade;
    }
}
