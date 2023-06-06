"""
@author: Jorge Augusto Salgado Salhani - 8927418
"""

from Cargos.Assistente import Assistente
from Cargos.Gerente import Gerente
from Cargos.Vendedora import Vendedora
from GestaoABC.FolhaSalarial import FolhaSalarial

if __name__ == '__main__':
    cpf = "12345678909"
    Gerente.verificaCPF(cpf)
    gerente = Gerente("Flora", cpf, 20.00)

    cpf = "42092105876"
    Vendedora.verificaCPF(cpf)
    vendedora = Vendedora("Flora", cpf, 20.00, 15.00)

    cpf = "42092105876"
    Assistente.verificaCPF(cpf)
    assistente = Assistente("Flora", cpf, 20.00)

    folhaSalarial = FolhaSalarial()
    folhaSalarial.adicionarFuncionaria(gerente)
    folhaSalarial.adicionarFuncionaria(vendedora)
    folhaSalarial.adicionarFuncionaria(assistente)
    print(folhaSalarial.__str__())
