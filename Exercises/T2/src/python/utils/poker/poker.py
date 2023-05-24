from ..mesa.baralho import Baralho
from ..mesa.Pontuacoes import Pontuacoes

class ApostaInvalida(Exception):
    """
    Erro levantado caso valor apostado invalido
    (maior que saldoAtual)
    """
    pass

class IndiceCartaParaTrocaNaoIncluso(Exception):
    """
    Erro levantado caso o indice da carta para
    troca nao consta no intervalo disponivel
    """
    pass

class Poker(Baralho):
    def __init__(self, numeroCartasDeck = 52, numeroCartasPorJogadora = 5, saldoAtual = 200.00) -> None:
        super().__init__(numeroCartasDeck)

        self.saldoAtual = saldoAtual
        self.numeroCartasPorJogadora = numeroCartasPorJogadora

    def imprimirLerApostaInicial(self):
        print("\nSaldo atual:", self.saldoAtual)
        print("Digite o valor da aposta ou 'F' para terminar ==> ", end='')

        try:
            aposta = input()
            if aposta == 'F': return -1

            aposta = float(aposta)
            if aposta > self.saldoAtual: raise ApostaInvalida
            return aposta
        except ApostaInvalida:
            print("Valor apostado deve ser menor que o saldo. Saldo corrente: {}".format(self.saldoAtual))
        except ValueError:
            print("Valor informado deve ser um numero positivo ou a letra \"F\" (sem aspas)")
        except Exception as ex:
            print(ex)
        
        return self.imprimirLerApostaInicial()
    
    def imprimirLerCartasParaTrocar(self):
        print("Digite o número das cartas que você deseja trocar, separados por espaços: ", end='')
        try:
            escolha = input().split()
            if len(escolha) == 0: return -1
            
            cartasEscolhidas = [int(i) for i in escolha]

            for i in cartasEscolhidas:
                if i <= 0 or i >= len(self.cartas)+1:
                    raise IndiceCartaParaTrocaNaoIncluso
            return cartasEscolhidas
        except ValueError:
            print("Tipo dos indices informados incompativeis com os indices inteiros disponiveis. Valores informados:", escolha)
        except IndiceCartaParaTrocaNaoIncluso:
            print("Valor incompativel com indices disponiveis. Valores informados:", escolha)
        except Exception as ex:
            print(ex)

        return self.imprimirLerCartasParaTrocar()
        
    def imprimirSemGanhos(self):
        print("Peninha... não ganhou nada nesta rodada.")

    def imprimirGanhos(self, ganho):
        print("Parabéns! Você acrescentou ${} ao seu saldo".format(ganho))
    
    def jogarNovamente(self):
        print("Tecle [ENTER] para continuar ", end='')
        if input() == "":
            return True
        else:
            return False

    def imprimirFimDeJogo(self):
        print("\nGAME OVER! Seu saldo chegou ao fim! \nVá para a casa, tome um chá e descanse, já amanheceu lá fora. Eu te amo! \u2665")

    def imprimirSaida(self):
        print("\nTerminando o jogo. Você ainda tem um saldo de ${}".format(self.saldoAtual))
    
    def jogarPoker(self):
        pontos = Pontuacoes()

        N = self.numeroCartasPorJogadora
        aposta = self.imprimirLerApostaInicial()
        if aposta == -1: 
            self.imprimirSaida()
            return

        numTrocasPermitidas = 2
        trocas = 0
        self.darCartas(N)
        while trocas != -1 and numTrocasPermitidas != 0:
            print(self)
            trocas = self.imprimirLerCartasParaTrocar()
            if trocas == -1:
                break
            self.trocarCartasSelecionadas(trocas)
            numTrocasPermitidas -= 1
        
        multiplicador = pontos.obterMultiplicador(self.cartas)
        self.saldoAtual += (multiplicador * aposta)
        self.saldoAtual = round(self.saldoAtual, 2)

        if multiplicador == 0:
            self.saldoAtual -= aposta
            self.imprimirSemGanhos()
        else:
            self.imprimirGanhos(round(multiplicador * aposta, 2))
        
        if self.saldoAtual == 0:
            self.imprimirFimDeJogo()
            return

        if self.jogarNovamente():
            self.jogarPoker()        


    
    