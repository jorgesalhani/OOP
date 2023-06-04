package Exercises.T3.src.java;
import Exercises.T3.src.java.Cargos.Gerente;
import Exercises.T3.src.java.Utils.EntradaTeclado;

public class Main {
  
  public static void main(String args[]) {
    String cpf = "12345678909";
    
    Gerente.verificaCPF(cpf);
    Gerente gerente = new Gerente("Iara", cpf, 10.0);
  }
}
