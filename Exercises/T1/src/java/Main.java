package Exercises.T1.src.java;
import Exercises.T1.src.java.utils.*;

public class Main {
    public static void main(String[] args) {
        Senha jogoSenha = new Senha();
        int N = jogoSenha.obterEntrada();
        int senha = jogoSenha.obterValorAleatorio(N);
        jogoSenha.adivinharSenha(senha);
    }
}
