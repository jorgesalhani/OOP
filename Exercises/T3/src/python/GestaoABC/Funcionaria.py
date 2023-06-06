from abc import ABC, abstractmethod

class CpfInvalido(Exception):
    """
    Erro levantado caso CPF informado invalido
    """
    pass

class Funcionaria(ABC):
    def __init__(self, nome: str, CPF: str, salarioBase: float) -> None:
        self.nome = nome
        self.CPF = CPF
        self.salarioBase = salarioBase

    @abstractmethod
    def calculaSalario() -> float:
        pass
    
    @staticmethod
    def obterRestoCpfTruncado(CPF: str, posicaoTruncamento: int) -> int:
        multiplicador = posicaoTruncamento
        soma = 0
        for i in range(posicaoTruncamento-1):
            cpfNumI = int(CPF[i])
            soma += (multiplicador * cpfNumI)
            multiplicador -= 1

        resto = (soma * 10) % 11
        if resto == 10 or resto == 11:
            resto = 0
        return resto

    @staticmethod
    def verificaCPF(CPF: str):
        if len(CPF) != 11: 
            raise CpfInvalido("Tamanho inválido de CPF. Informado: " + CPF)

        resto = Funcionaria.obterRestoCpfTruncado(CPF, 10)
        digitoVerificador = int(CPF[9])

        if resto != digitoVerificador:
            raise CpfInvalido("Número inválido de CPF. Informado: " + CPF)
        
        resto = Funcionaria.obterRestoCpfTruncado(CPF, 11)
        digitoVerificador = int(CPF[10])

        if resto != digitoVerificador:
            raise CpfInvalido("Número inválido de CPF. Informado: " + CPF)

    def __str__(self) -> str:
        return f" Nome: {self.nome}\n CPF: {self.CPF}\n Salario base: {self.salarioBase}\n"
    
    
