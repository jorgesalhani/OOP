package Exercises.T3.src.java;
import Exercises.T3.src.java.Cargos.Assistente;
import Exercises.T3.src.java.Cargos.Gerente;
import Exercises.T3.src.java.Cargos.Vendedora;
import Exercises.T3.src.java.Utils.EntradaTeclado;

public class Main {
  
  public static void main(String args[]) {
    String cpf = "12345678909";
    
    Gerente.verificaCPF(cpf);
    Gerente gerente = new Gerente("Iara", cpf, 10.0);
    System.out.println(gerente.toString());

    cpf = "42092105876";
    Vendedora.verificaCPF(cpf);
    Vendedora vendedora = new Vendedora("Iara", cpf, 10.0);
    System.out.println(vendedora.toString());

    cpf = "12345678909";
    Assistente.verificaCPF(cpf);
    Assistente assistente = new Assistente("Iara", cpf, 10.0);
    System.out.println(assistente.toString());
  }
}
