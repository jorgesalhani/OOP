package Exercises.T2.src.java.utils;
import java.util.ArrayList;

public class RolaDados{
  private int numeroDados = 0;
  private ArrayList<Dado> dados = new ArrayList<Dado>();
  private int[] valorDados;

  public RolaDados(int n) {
    numeroDados = n;
    valorDados = new int[n];
    for (int i = 0; i < numeroDados; i++) {
      Dado dado = new Dado();
      dados.add(dado);
      valorDados[i] = dado.getLado();
    }
  }

  public int[] rolar() {
    for (int i = 0; i < numeroDados; i++) {
      valorDados[i] = dados.get(i).rolar();
    }
    return valorDados;
  }

  public int[] rolar(boolean[] quais) {
    for (int i = 0; i < quais.length; i++) {
      if (quais[i]) {
        valorDados[i] = dados.get(i).rolar();
      }
    }
    return valorDados;
  }

  @Override
  public String toString() {
    String rolaDadosString = "";
    for (int i = 0; i < dados.size(); i++) {
      rolaDadosString.concat(dados.get(i).toString());
      System.out.print(dados.get(i).toString());
    }
    return rolaDadosString;
  }
}
