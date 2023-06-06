package Exercises.T3.src.java.GestaoABC;
import java.util.ArrayList;

public class FolhaSalarial {
  private ArrayList<Funcionaria> funcionariasAtuais = new ArrayList<Funcionaria>(); 
  private double folhaSalarialAcumulada = 0.0;

  public FolhaSalarial() {}

  public void adicionarFuncionaria(Funcionaria funcionaria) {
    funcionariasAtuais.add(funcionaria);
  }

  @Override
  public String toString() {
    String folhaFinal = "";
    folhaFinal += "===============================\n";
    folhaFinal += "****** POO Entrerprises *******\n";
    folhaFinal += "===============================\n\n";

    folhaFinal += "====== Quadros da gestão ======\n";
    folhaFinal += "**** Delamaro 1o sem. 2023 ****\n";
    folhaFinal += "===============================\n\n";
    folhaFinal += "======== Folha Salarial =======\n\n";
    
    for (Object funcId : funcionariasAtuais) {
      folhaFinal += funcId.toString() + "\n";

      // double salarioFuncId = funcId.calculaSalario();
      // folhaFinal += String.format("%f", salarioFuncId);
      // folhaSalarialAcumulada += salarioFuncId;
    }

    return folhaFinal;
  }
}
