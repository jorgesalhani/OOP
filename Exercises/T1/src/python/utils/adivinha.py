from utils.random import *

class ValorNegativoInvalido(Exception):
    """
    Erro levantado caso N negativo
    """
    pass

class VerificadorInvalido(Exception):
    """
    Erro levantado caso verificador
    nao contido em ["correto", "maior", "menor"]
    (independente de capitalizacao)
    """
    pass

class VerificadorInvalidoAlias(Exception):
    """
    Erro levantado caso verificador
    nao contido em ['C', 'M', 'm']
    (dependente de capitalizacao)
    """

class Adivinha:
    def __init__(self) -> None:
        print("Jogo Adivinha")
        print("=============\n")

        self.palpiteLimiteSup = 0
        self.palpiteLimiteInf = 0
        self.verificadores = ["correto", "maior", "menor"]
        self.verificadoresAlias = ['C', 'M', 'm']
        self.verificador = ''
        self.N = 0
        self.r = Random()

    def obterEntrada(self):
        print("1. Intervalo do seu valor escolhido [0,N)")
        try:
            entrada = input("Limite superior N: ")
            N = int(entrada)
            
            if N < 0: raise ValorNegativoInvalido

        except ValueError:
            print("Valor informado deve ser inteiro: '{}'".format(entrada))
            raise ValueError
        
        except ValorNegativoInvalido:
            print("Valor informado deve ser positivo: {}".format(N))
            raise ValorNegativoInvalido

        except Exception as excErr:
            print(excErr)
            raise excErr
            
        self.N = N
        self.palpiteLimiteSup = N

    def verificarPalpite(self, palpite):
        print("Palpite: {}".format(palpite))
        
        verificar = input("Correto/Maior/menor? [C/M/m] ")
        if len(verificar) > 1: verificar = verificar.lower()

        try:
            if len(verificar) > 1 and verificar not in self.verificadores: 
                raise VerificadorInvalido
            
            if len(verificar) == 1 and verificar not in self.verificadoresAlias:
                raise VerificadorInvalidoAlias
        
        except VerificadorInvalido:
            print("Verificador invalido: {}".format(verificar))
            print("Disponiveis: {}\n".format(self.verificadores))
            raise VerificadorInvalido

        except VerificadorInvalidoAlias:
            print("Verificador invalido: {}".format(verificar))
            print("Disponiveis: {}\n".format(self.verificadoresAlias))
            raise VerificadorInvalidoAlias

        self.verificador = verificar
        return verificar

    def verificarPrimeiroPalpite(self):
        if self.palpiteLimiteInf == 0 and self.palpiteLimiteSup == self.N:
            return True
        return False

    def obterPrimeiroPalpite(self):
        palpite = self.r.get_int_rand(maximo=self.N)
        return palpite
    
    def obterProximoPalpite(self):
        numAleatorio = self.r.get_rand()
        palpite = int(
            self.palpiteLimiteInf + 
            numAleatorio * (self.palpiteLimiteSup - self.palpiteLimiteInf)
        )
        return palpite
    
    def atualizarLimites(self, palpite):
        if self.verificador in ['M', 'maior']:
            self.palpiteLimiteInf = palpite
            return
        
        if self.verificador in ['m', 'menor']:
            self.palpiteLimiteSup = palpite
            return


    def obterPalpite(self):
        palpite = 0

        if self.verificarPrimeiroPalpite():
            palpite = self.obterPrimeiroPalpite()
        else:
            palpite = self.obterProximoPalpite()
        
        return palpite
        

    def jogarAdivinha(self):
        try:
            self.obterEntrada()
            palpite = self.obterPalpite()
            while self.verificarPalpite(palpite) not in ['C', 'correto']:
                self.atualizarLimites(palpite)
                palpite = self.obterPalpite()
            
            print("\n***********************************")
            print("*** Parabéns! Adivinha correta! ***")
            print("***********************************")

        except Exception as exc:
            print(exc)        
        
        
        

        
