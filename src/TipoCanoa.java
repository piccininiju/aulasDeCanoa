public enum TipoCanoa {
  OC6(6),
  OC4(4),
  OC2(2),
  OC1(1);

  private final int capacidade;

  TipoCanoa(int capacidade) {
    this.capacidade = capacidade;
  }

  public int getCapacidade() {
    return capacidade;
  }
}