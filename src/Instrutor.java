import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Instrutor implements Serializable {
    private String nome;
    private List<LocalDateTime> horariosOcupados;

    Instrutor(String nome) {
        this.nome = nome;
        this.horariosOcupados = new ArrayList<>();
    }

    public void addAula(LocalDateTime dataHora) {
        horariosOcupados.add(dataHora);
    }

    public void removeAula(LocalDateTime dataHora) {
        horariosOcupados.remove(dataHora);
    }

    public List<LocalDateTime> getAulas() {
        return horariosOcupados;
    }

    public String getNome() {
        return nome;
    }
}