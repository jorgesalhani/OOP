from GestaoABC.Funcionaria import Funcionaria
from typing import List, Union

class FolhaSalarial:
    def __init__(self) -> None:
        self.funcionariasAtuais = []
        self.folhaSalarialAcumulada = 0

    def adicionarFuncionaria(self, funcionaria: Union[Funcionaria, List[Funcionaria]]):
        if isinstance(funcionaria, Funcionaria):
          self.funcionariasAtuais.append(funcionaria)
          return
      
        if isinstance(funcionaria, List[Funcionaria]):
          for funcI in funcionaria:  
            self.funcionariasAtuais.append(funcI)

    def __str__(self) -> str:
        folhaFinal = ""
        folhaFinal += "===============================\n"
        folhaFinal += "****** POO Entrerprises *******\n"
        folhaFinal += "===============================\n\n"

        folhaFinal += "====== Quadros da gestão ======\n"
        folhaFinal += "**** Delamaro 1o sem. 2023 ****\n"
        folhaFinal += "===============================\n\n"
        folhaFinal += "======== Folha Salarial =======\n\n"
    
        for funcId in self.funcionariasAtuais:
          folhaFinal += funcId.__str__()
          salarioFuncId = funcId.calculaSalario()
          folhaFinal += f' Salario recebido: {str(salarioFuncId)}\n\n'
          self.folhaSalarialAcumulada += salarioFuncId

        folhaFinal += '***** Acumulado ******\n'
        folhaFinal += '**********************\n'
        folhaFinal += '      ' + str(self.folhaSalarialAcumulada) + '\n'
        return folhaFinal