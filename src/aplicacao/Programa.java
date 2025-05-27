package src.aplicacao;

//import src.jogotabuleiro.Posicao;
//import src.jogotabuleiro.Tabuleiro;
import src.xadrez.PartidaXadrez;
import src.xadrez.PecaXadrez;
import src.xadrez.PosicaoXadrez;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Teste de posição
//        Posicao pos = new Posicao(3, 5);
//        System.out.println(pos.toString());

        // Teste de peças
//        Tabuleiro tabuleiro = new Tabuleiro(8, 8);
//        System.out.println();

        // Impressão do tabuleiro com linha e codigo
//        PartidaXadrez partida = new PartidaXadrez();
//        UI.printTabuleiro(partida.getPecas());

        // Testar movimento da peça
        PartidaXadrez partidaXadrez = new PartidaXadrez();
        while (true) {
            UI.printTabuleiro(partidaXadrez.getPecas());
            System.out.println();
            System.out.print("Origem: ");
            PosicaoXadrez origem = UI.LerPosicaoXadrez(sc);

            System.out.print("Destino: ");
            PosicaoXadrez destino = UI.LerPosicaoXadrez(sc);
            System.out.println();

            PecaXadrez capturarPeca = partidaXadrez.RealizarMovimentoXadrez(origem, destino);
        }

    }
}