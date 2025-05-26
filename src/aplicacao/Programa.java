package src.aplicacao;

import src.jogotabuleiro.Posicao;
import src.jogotabuleiro.Tabuleiro;
import src.xadrez.PartidaXadrez;

public class Programa {
    public static void main(String[] args) {

        // Teste de posição
        Posicao pos = new Posicao(3, 5);
        System.out.println(pos.toString());

        // Teste de peças
        Tabuleiro tabuleiro = new Tabuleiro(8, 8);
        System.out.println();

        // Impressão do tabuleiro com linha e codigo
        PartidaXadrez partida = new PartidaXadrez();
        UI.printTabuleiro(partida.getPecas());
    }
}