package Exercises.T3.src.java.Cargos;
import Exercises.T3.src.java.GestaoABC.Funcionaria;

public class Assistente extends Funcionaria {
  public Assistente(String nome, String CPF, double salarioBase) {
    this.nome = nome;
    this.CPF = CPF;
    this.salarioBase = salarioBase;
  };

  public double calculaSalario() {
    return this.salarioBase;
  };

  @Override
  public String toString() {
    String str = String.format("Cargo: Assistente%n");
    str += this.superToString();
    return str;
  }
}
