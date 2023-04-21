package Exercises.T1.src.java.utils;

public class Senha {

    public int obterEntrada() {
        System.out.println("Jogo Senha\n==========\n");
        System.out.println("1. Gerar numero aleatorio [0,N)");
        System.out.print("Limite superior N: ");
        try {
            int N = EntradaTeclado.leInt();
            return N;
        } catch(Exception err) {
            System.out.println(err);
            return -1;
        }
    }

    public int obterValorAleatorio(int N) {
        Random r = new Random();
        int valorAleatorio = r.getIntRand(N);
        return valorAleatorio;
    }

    public boolean verificarPalpite(int senha) {
        System.out.print("Palpite: ");
        int palpite = 0;
        
        try {
            palpite = EntradaTeclado.leInt();
        } catch (Exception err) {
            System.out.println(err);
            return false;
        }

        if (senha == palpite) return true;
        
        if (senha < palpite) {
            System.out.println("Maior");
        } else {
            System.out.println("Menor");
        }

        return false;
    }

    public void adivinharSenha(int senha) {
        int tentativa = 1;
        while (!verificarPalpite(senha)) tentativa++;
        System.out.println("\n*******************************");
        System.out.println("*** Parabéns! Você acertou! ***");
        System.out.println("*******************************\n");
        System.out.printf("Senha correta: %d%n", senha);
        System.out.printf("Total de tentativas: %d%n", tentativa);
    }
}
