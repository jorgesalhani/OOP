package Exercises.T2.src.java;
import Exercises.T2.src.java.utils.*;

public class Bozo {

  public static void main(String args[]) throws java.io.IOException {
    
    Placar placar = new Placar();
    System.out.print(placar.toString());

    int rodada = 0;
    RolaDados rolaDados = new RolaDados(6);
    while (rodada < 10) {
      rolaDados.rolar();
      rolaDados.toString();  
      rodada++;
    }

  }
}
