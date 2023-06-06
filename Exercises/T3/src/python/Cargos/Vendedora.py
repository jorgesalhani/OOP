from GestaoABC.Funcionaria import Funcionaria

class Vendedora(Funcionaria):
    def __init__(self, nome: str, CPF: str, salarioBase: float, comissao: float) -> None:
        super().__init__(nome, CPF, salarioBase)
        self.comissao = comissao
    
    def calculaSalario(self) -> float:
        return self.salarioBase + self.comissao

    def __str__(self) -> str:
        return "Cargo: Vendedora\n" + super().__str__()


    