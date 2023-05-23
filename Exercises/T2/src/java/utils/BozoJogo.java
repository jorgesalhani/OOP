package Exercises.T2.src.java.utils;
import Exercises.T2.src.java.utils.*;
import java.util.Arrays;


public class BozoJogo{
  public BozoJogo() {

  }

  private static void imprimirRodada(int rodada) {
    try {
      System.out.print(String.format("****** Rodada %d%n", rodada));
      System.out.println("Pressione ENTER para lançar os dados");
      String enter = EntradaTeclado.leString();
    } catch (Exception exc) {
      System.out.println(exc);
    }
  }

  private static boolean[] imprimirLerTrocaDados(int nDados) {
    try {
      System.out.println("Digite os números dos dados que quiser TROCAR. Separados por espaços.");
      String valores = EntradaTeclado.leString();

      String[] dadosEscolhidos = valores.split(" ");

      int numDadosEscolhidos = dadosEscolhidos.length;
      if (numDadosEscolhidos == 0) return null;

      while (numDadosEscolhidos > nDados) {
        System.out.printf("Maximo de dados escolhidos: %d. Correspondente informado: %d%n", nDados, numDadosEscolhidos);
        valores = EntradaTeclado.leString();
        dadosEscolhidos = valores.split(" ");
        numDadosEscolhidos = dadosEscolhidos.length;
      }

      if (numDadosEscolhidos == 0 || dadosEscolhidos == null) return null;
      if (numDadosEscolhidos == 1 && dadosEscolhidos[0].length() == 0) return null;

      boolean[] dadosTrocados = new boolean[nDados];

      int dadoEscolhido_i = 0;
      int indxDadoEscolhido = 0;
      for (int i = 0; i < nDados; i++) {
        if (dadoEscolhido_i < numDadosEscolhidos){
          indxDadoEscolhido = Integer.valueOf(dadosEscolhidos[dadoEscolhido_i]);
        };
        indxDadoEscolhido--;
        if (i == indxDadoEscolhido) {
          dadosTrocados[i] = true;
          dadoEscolhido_i++;
        } else {
          dadosTrocados[i] = false;
        }
      }

      return dadosTrocados;
    } catch (Exception exc) {
      System.out.println(exc);
    }

    return null;
  }

  private void imprimirLerPosicaoPlacar(Placar placar, int[] dados) {
    try {
      System.out.println(placar.toString());
      System.out.print("Escolha a posição que quer ocupar com essa jogada ===> ");
      int posicao = EntradaTeclado.leInt();
      placar.add(posicao, dados);
      System.out.println(placar.toString());
    } catch (Exception exc) {
      System.out.println(exc);
    }

  }

  private void imprimirFinal(Placar placar) {
    System.out.println("***********************************");
    System.out.println("***");
    System.out.printf("*** Seu escore final foi: %d%n", placar.getScore());
    System.out.println("***");
    System.out.println("***********************************");
  }

  public void jogar() {
    int rodada = 1;
    int nDados = 5;
    Placar placar = new Placar();
    System.out.println(placar.toString());
    RolaDados rolaDados = new RolaDados(nDados);
    int[] dados = rolaDados.rolar();
    while (rodada <= 10) {
      imprimirRodada(rodada);
      dados = rolaDados.rolar();
      for (int trocaDado = 0; trocaDado < 2; trocaDado++) {
        System.out.println(rolaDados.toString());
        boolean[] dadosTrocados = imprimirLerTrocaDados(nDados);
        if (dadosTrocados != null) {
          dados = rolaDados.rolar(dadosTrocados);
        }
        else {break;}
      }
      rodada++;

      System.out.println(rolaDados.toString());
      imprimirLerPosicaoPlacar(placar, dados);
    }

    imprimirFinal(placar);
  }
}
