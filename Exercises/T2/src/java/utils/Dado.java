package Exercises.T2.src.java.utils;

public class Dado extends Random{
  private int numeroLados = 6;
  private int lado = getIntRand(numeroLados) + 1;

  public Dado() {}

  public Dado(int n) {
    numeroLados = n;
  }

  public int getLado() {
    return lado;
  }

  public int rolar() {
    lado = getIntRand(numeroLados) + 1;
    return lado;
  }

  @Override
  public String toString() {
    String ladoEmString = "";

    try {
      if (numeroLados > 6) {
        Exception ex = new Exception(String.format("Método permitido para dados de até 6 lados. Correspondente atual: %d%n", lado));
        throw ex;
      }
    } catch (Exception ex) {
      System.out.println(ex.toString());
    }
    switch (lado) {
      case 1: 
        ladoEmString =
          """
          +-----+
          |     |
          |  *  |
          |     |
          +-----+
          """
        ;
      break;

      case 2:
        ladoEmString =
          """
          +-----+
          |*    |
          |     |
          |    *|
          +-----+
          """
        ;
      break;

      case 3:
        ladoEmString =
          """
          +-----+
          |*    |
          |  *  |
          |    *|
          +-----+
          """
        ;
      break;

      case 4:
        ladoEmString =
          """
          +-----+
          |*   *|
          |     |
          |*   *|
          +-----+
          """
        ;
      break;

      case 5:
        ladoEmString =
          """
          +-----+
          |*   *|
          |  *  |
          |*   *|
          +-----+
          """
        ;
      break;

      case 6:
        ladoEmString =
          """
          +-----+
          |* * *|
          |     |
          |* * *|
          +-----+
          """
        ;
      break;
    }

    return ladoEmString;
  }
}
