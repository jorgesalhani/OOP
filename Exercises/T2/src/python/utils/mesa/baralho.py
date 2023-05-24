from random import shuffle, randrange

class Baralho:
    def __init__(self, N = 52) -> None:
        if N != None:  
          self.tamanhoBaralho = N 
        
        valores = (N - 12) // 4
        # N exceto Q,J,K por naipe

        self.naipes = ["C", "O", "P", "E"]
        # C: Copas
        # O: Ouros
        # P: Paus
        # E: Espadas
        
        self.valores = ['A']    
        [self.valores.append(i) for i in range(2,valores+1)]
        
        self.baralho = []
        for naipe in self.naipes:
          for valor in self.valores:
             self.baralho.append((naipe, valor))

        self.cartas = []
    
    def darCartas(self, N = 5):
        self.cartas = [
            self.baralho.pop(randrange(len(self.baralho)))
            for i in range(N)
        ]

        return self.cartas
    
    def trocarCartasSelecionadas(self, trocas):
        for i in trocas:
            novaCarta = self.baralho.pop(randrange(len(self.baralho)))
            self.baralho.append(self.cartas[i-1])
            self.cartas[i-1] = novaCarta
        return self.cartas
    
    def __str__(self) -> str:
        borda = """
+------+
|      |
|      |
|      |
+------+
"""
        bordaSplit = borda.split('\n')

        mesa = ""
        for i in range(1, len(bordaSplit)-1):
            mesa += " "
            for j in range(len(self.cartas)):
                if i == 3:
                    if self.cartas[j][1] != 'A' and self.cartas[j][1] >= 10:
                        mesa += "| "
                    else:
                        mesa += "|  "

                    mesa += str(self.cartas[j][1])
                    if self.cartas[j][0] == 'E':
                        mesa += '\u2660'
                    elif self.cartas[j][0] == 'C':
                        mesa += '\u2665'
                    elif self.cartas[j][0] == 'O':
                        mesa += '\u2666'
                    else:
                        mesa += '\u2663'
                    mesa += "  |"

                else:
                    mesa += bordaSplit[i]
                mesa += " "
            mesa += "\n"
            
        mesa += "    "
        mesa += "      ".join("(" + str(c+1) + ")" for c in range(len(self.cartas)))
        
        return mesa
             