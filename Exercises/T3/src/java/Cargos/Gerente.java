package Exercises.T3.src.java.Cargos;
import Exercises.T3.src.java.GestaoABC.Funcionaria;

public class Gerente extends Funcionaria {
  public Gerente(String nome, String CPF, double salarioBase) {
    this.nome = nome;
    this.CPF = CPF;
    this.salarioBase = salarioBase;
  };

  public double calculaSalario() {
    return this.salarioBase * 2;
  };

  @Override
  public String toString() {
    String str = String.format("Cargo: Gerente%n");
    str += this.superToString();
    return str;
  }
}
