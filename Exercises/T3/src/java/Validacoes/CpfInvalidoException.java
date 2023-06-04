package Exercises.T3.src.java.Validacoes;

public class CpfInvalidoException extends IllegalArgumentException {
  public CpfInvalidoException() {}

  public CpfInvalidoException(String mensagem) {
    super(mensagem);
  }

  public CpfInvalidoException(String mensagem, Throwable causa) {
    super(mensagem, causa);
  }
}
