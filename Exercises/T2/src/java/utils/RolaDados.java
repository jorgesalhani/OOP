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
    int numLinhasPrint = 5;

    int tamLinha0 = dados.get(0).toString().split("\n")[0].length();
    String indiceDado = " ";
    for (int i = 1; i <= dados.size(); i++) {
      indiceDado += String.valueOf(i);
      for (int j = 0; j < tamLinha0; j++) {
        indiceDado += " ";
      }
    }
    indiceDado += "\n";
    

    rolaDadosString += indiceDado;
    for (int linha = 0; linha < numLinhasPrint; linha++) {
      for (int i = 0; i < dados.size(); i++) {
        String linhaDado = dados.get(i).toString().split("\n")[linha];
        rolaDadosString += String.format(" %s", linhaDado);
      }
      rolaDadosString += "\n";
    }
    return rolaDadosString;
  }
}
