package Exercises.T3.src.java.GestaoABC;
import Exercises.T3.src.java.Validacoes.CpfInvalidoException;

public abstract class Funcionaria {
  public String nome;
  public String CPF;
  public double salarioBase;

  private static int obterRestoCpfTruncado(String CPF, int posicaoTruncamento) {
    int multiplicador = posicaoTruncamento;
    int soma = 0;
    for (int i = 0; i < posicaoTruncamento-1; i++) {
      int cpfNumI = Character.getNumericValue(CPF.charAt(i));
      soma += (multiplicador * cpfNumI);
      multiplicador--;
    }

    
    int resto = (soma * 10) % 11;
    if (resto == 10 || resto == 11) {resto = 0;}
    return resto;
  }

  public static void verificaCPF(String CPF) throws CpfInvalidoException {
    if (CPF.length() != 11) {
      throw new CpfInvalidoException(
        String.format("Tamanho inválido de CPF.%nInformado: %s%n", CPF)
      );
    };

    int resto = obterRestoCpfTruncado(CPF, 10);

    int digitoVerificador = Character.getNumericValue(CPF.charAt(9));
    if (resto != digitoVerificador) {
      throw new CpfInvalidoException(
        String.format("Número inválido de CPF.%nInformado: %s%n", CPF)
      );
    }

    resto = obterRestoCpfTruncado(CPF, 11);

    digitoVerificador = Character.getNumericValue(CPF.charAt(10));
    if (resto != digitoVerificador) {
      throw new CpfInvalidoException(
        String.format("Número inválido de CPF.%nInformado: %s%n", CPF)
      );
    }
  }

  public String superToString() {
    String strF = String.format(
      "- Nome: %s%n- CPF: %s%n- Salario base: %,.2f%n",
      this.nome, this.CPF, this.salarioBase
    );
    return strF;
  }

  public abstract double calculaSalario();
}
