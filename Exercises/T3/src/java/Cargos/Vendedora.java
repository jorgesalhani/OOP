package Exercises.T3.src.java.Cargos;
import Exercises.T3.src.java.UtilsABC.Funcionaria;

public class Vendedora extends Funcionaria{
  public Vendedora(String nome, String CPF, double salarioBase) {
    this.nome = nome;
    this.CPF = CPF;
    this.salarioBase = salarioBase;
  };

  public double calculaSalario() {
    return this.salarioBase;
  };

  @Override
  public String toString() {
    String str = String.format("Cargo: Vendedora%n");
    str += this.superToString();
    return str;
  }
}
