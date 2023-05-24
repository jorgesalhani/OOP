class Pontuacoes:
    def __init__(self) -> None:
        self.premioMultiplicador = {
            "dupla": 1,
            "trinca": 2,
            "straight": 5,
            "flush": 10,
            "fullHand": 20,
            "quadra": 50,
            "straightFlush": 100,
            "royalStraightFlush": 200
        }

    def associarValores(self, cartasOriginal):
        cartas = []
        for carta in cartasOriginal:
            if carta[1] == 'J':
                cartas.append((carta[0], 11))
            elif carta[1] == 'Q':
                cartas.append((carta[0], 12))
            elif carta[1] == 'K':
                cartas.append((carta[0], 13))
            elif carta[1] == 'A':
                cartas.append((carta[0], 14))
            else:
                cartas.append((carta[0], carta[1]))
        return cartas
    
    def obterMultiplicador(self, cartasOriginal : list):
        cartas = cartasOriginal
                
        ordemRoyal = [10,'J','Q','K','A']
        naipe = cartas[0][0]

        histogramaNaipes = {}
        histogramaValores = {}

        for carta in cartas:
            if carta[0] in histogramaNaipes:
                histogramaNaipes[carta[0]] += 1
            else:
                histogramaNaipes[carta[0]] = 1

            if carta[1] in histogramaValores:
                histogramaValores[carta[1]] += 1
            else:
                histogramaValores[carta[1]] = 1    
        
        royal = True
        if len(cartas) != len(ordemRoyal):
            royal = False
        else:
            for i in range(len(cartas)):
                if cartas[i][0] != naipe or cartas[i][1] not in ordemRoyal:
                    royal = False
                    break
        if royal:
            return self.premioMultiplicador['royalStraightFlush']
        
        cartas = self.associarValores(cartasOriginal)

        straightFlush = True
        straight = True
        cartas.sort(key=lambda x:x[1])
        for i in range(len(cartas)-1):
            if cartas[i][1] != cartas[i+1][1]+1 or carta[i][0] != naipe:
                straightFlush = False
            
            if cartas[i][1]+1 != cartas[i+1][1]:
                straight = False

        if straightFlush:
            return self.premioMultiplicador['straightFlush']
        
        quadra = False
        fullHand = False
        verificadorFullHand = 0
        verificadorPares = 0

        trinca = False
        dupla = False
        
        for k,v in histogramaValores.items():
            if v == 4:
                quadra = True
                break

            if v == 3:
                trinca = True
            if v == 2:
                verificadorPares += 1

            if v == 3 and len(histogramaValores) == 2:
                verificadorFullHand += 1
            if v == 2 and len(histogramaValores) == 2:
                verificadorFullHand += 1

        if verificadorPares == 2:
            dupla = True

        if verificadorFullHand == 2:
            fullHand = True

        if quadra:
            return self.premioMultiplicador['quadra']
        

        if fullHand:
            return self.premioMultiplicador['fullHand']
        
        flush = False
        for k,v in histogramaNaipes.items():
            if v == 5:
                flush = True
                break
                
        if flush:
            return self.premioMultiplicador['flush']
        
        if straight:
            return self.premioMultiplicador['straight']
        
        if trinca:
            return self.premioMultiplicador['trinca']

        if dupla:
            return self.premioMultiplicador['dupla']
        
        return 0
