/**
 * @author: Jorge Augusto Salgado Salhani - 8927418
 */



package Exercises.T3.src.java;
import Exercises.T3.src.java.Cargos.Assistente;
import Exercises.T3.src.java.Cargos.Gerente;
import Exercises.T3.src.java.Cargos.Vendedora;
import Exercises.T3.src.java.Entrada.EntradaTeclado;
import Exercises.T3.src.java.GestaoABC.FolhaSalarial;

public class Main {
  
  public static void main(String args[]) {
    String cpf = "12345678909";
    
    Gerente.verificaCPF(cpf);
    Gerente gerente = new Gerente("Iara", cpf, 10.0);

    cpf = "42092105876";
    Vendedora.verificaCPF(cpf);
    Vendedora vendedora = new Vendedora("Iara", cpf, 10.0, 2.0);

    cpf = "12345678909";
    Assistente.verificaCPF(cpf);
    Assistente assistente = new Assistente("Iara", cpf, 10.0);

    FolhaSalarial folhaSalarial = new FolhaSalarial();
    folhaSalarial.adicionarFuncionaria(assistente);
    folhaSalarial.adicionarFuncionaria(vendedora);
    folhaSalarial.adicionarFuncionaria(gerente);

    System.out.println(folhaSalarial);
  }
}
