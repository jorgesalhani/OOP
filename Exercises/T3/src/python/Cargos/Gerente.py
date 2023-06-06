from GestaoABC.Funcionaria import Funcionaria

class Gerente(Funcionaria):
    def __init__(self, nome: str, CPF: str, salarioBase: float) -> None:
        super().__init__(nome, CPF, salarioBase)
    
    def calculaSalario(self) -> float:
        return self.salarioBase * 2
    
    def __str__(self) -> str:
        return "Cargo: Gerente\n" + super().__str__()