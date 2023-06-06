package Exercises.T3.src.java.Cargos;
import Exercises.T3.src.java.GestaoABC.Funcionaria;

public class Vendedora extends Funcionaria{
  private double comissao;

  public Vendedora(String nome, String CPF, double salarioBase, double comissao) {
    this.nome = nome;
    this.CPF = CPF;
    this.salarioBase = salarioBase;
    this.comissao = comissao;
  };

  public double calculaSalario() {
    return this.salarioBase + this.comissao;
  };

  @Override
  public String toString() {
    String str = String.format("Cargo: Vendedora%n");
    str += this.superToString();
    return str;
  }
}
