from GestaoABC.Funcionaria import Funcionaria

class Assistente(Funcionaria):
    def __init__(self, nome: str, CPF: str, salarioBase: float) -> None:
        super().__init__(nome, CPF, salarioBase)

    def calculaSalario(self) -> float:
        return self.salarioBase
    
    def __str__(self) -> str:
        return "Cargo: Assistente\n" + super().__str__()
