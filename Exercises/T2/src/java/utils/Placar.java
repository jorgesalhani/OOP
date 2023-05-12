package Exercises.T2.src.java.utils;

public class Placar {
  private String[] posicoes = {
    "(1)","(2)","(3)","(4)","(5)","(6)",
    "(7)","(8)","(9)","(10)"
  };

  private String[] posicoesNomes = {
    "(1) #1","(2) #2","(3) #3","(4) #4","(5) #5","(6) #6",
    "(7) full hand","(8) sequencia","(9) quadra","(10) quina"
  };

  private int score = 0;

  public Placar() {

  }

  static int verificarQuadra(int[] histograma) {
    int pontuacao = 0;
    for (int i = 0; i < histograma.length; i++) {
      if (histograma[i] >= 4) {
        pontuacao = 30;
      }
    }
    return pontuacao;
  }

  static int verificarQuina(int[] histograma) {
    int pontuacao = 0;
    for (int i = 0; i < histograma.length; i++) {
      if (histograma[i] >= 5) {
        pontuacao = 30;
      }
    }
    return pontuacao;
  }

  static int verificarFullHand(int[] histograma) {
    int pontuacao = 0;
    int verificado = 0;
    for (int i = 0; i < histograma.length; i++) {
      if (histograma[i] == 3) {
        verificado += 1;
      }

      if (histograma[i] == 2) {
        verificado += 1;
      }
    }

    if (verificado == 2) {
      pontuacao = 15;
    }
    return pontuacao;
  }

  static int verificarSequencia(int[] dados) {
    int pontuacao = 0;
    for (int i = 0; i < (dados.length - 1); i++) {
      if (dados[i+1] == dados[i] + 1) {
        pontuacao = 20;
      }
    }
    return pontuacao;
  }

  public void add(int posicao, int[] dados) throws java.lang.IllegalArgumentException {
    try {
      if (posicao > 10) {
        throw new IllegalArgumentException(String.format(
          "Argumento <posicao> deve ser menor que 10. Correspondente: %s%n", posicao
        ));
      }
      if (dados.length != 5) {
        throw new IllegalArgumentException(String.format(
          "Argumento <dados> deve conter 5 dados. Correspondente: %d%n", dados.length
        ));
      }

      int pontuacao = 0;
      if (posicao <= 6) {
        for (int i = 0; i < dados.length; i++) {
          if (dados[i] == posicao) {
            pontuacao += dados[i];
          }
        }
      } else {
        int histograma[] = {0,0,0,0,0,0};

        for (int i = 0; i < dados.length; i++) {
          histograma[dados[i]-1] += 1;
        }

        switch (posicao) {
          case 7: 
            pontuacao += verificarFullHand(histograma);
          break;

          case 8: 
            pontuacao += verificarSequencia(dados);
          break;

          case 9:
            pontuacao += verificarQuadra(histograma);
          break;

          case 10: 
            pontuacao += verificarQuina(histograma);
          break;
        }
      }

      posicoes[posicao] = String.valueOf(pontuacao);
      score += pontuacao;

    } catch (Exception ex) {
      System.out.println(ex.toString());
    }
  }

  public int getScore() {
    return score;
  }

  @Override
  public String toString() {
    String placarString = String.format("""
         %s   |   %s    |   %s
      ------------------------------
         %s   |   %s    |   %s
      ------------------------------
         %s   |   %s    |   %s
      ------------------------------
               |   %s   |
               +----------+
      """, 
      posicoes[0], posicoes[6], posicoes[3], posicoes[1], posicoes[7], 
      posicoes[4], posicoes[2], posicoes[8], posicoes[5], posicoes[9]
    );

    return placarString;
  }
}