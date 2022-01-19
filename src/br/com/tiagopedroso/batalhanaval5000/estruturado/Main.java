package br.com.tiagopedroso.batalhanaval5000.estruturado;

import java.util.Scanner;

public class Main {

     /*
        Regra de valores no Array mar
        0 - vazio
        1 - navio inteiro
        2 - navio quebrado
        3 - tiro errado
         */

    static final int
            MAR_SIMBOLO_VAZIO = 0,
            MAR_SIMBOLO_NAVIO_INTEIRO = 1,
            MAR_SIMBOLO_NAVIO_QUEBRADO = 2,
            MAR_SIMBOLO_TIRO_ERRADO = 3
    ;

    static final char
            MAR_SIMBOLO_VAZIO_CHAR = '~',
            MAR_SIMBOLO_NAVIO_INTEIRO_CHAR = '#',
            MAR_SIMBOLO_NAVIO_QUEBRADO_CHAR = 'X',
            MAR_SIMBOLO_TIRO_ERRADO_CHAR = '^'
    ;

    public static void main(String[] args) {

        //Setup do game
        Integer tamanhoMar = 5;
        int qtdBarcos = 5;
        Integer[][] mar = inicializaMar(tamanhoMar);

        //1. Cada jogador digita seu nome
//        String nomeJogador = lerNomeJogador();

        //2. Cada jogador posiciona seus barcos (5 barcos de tamanho 1)
        imprimeMar(mar);
        for (int cont = 1; cont <= qtdBarcos; cont++) {
            posicionarBarco(mar, cont, qtdBarcos);
            imprimeMar(mar);
        }

        //3. Cada jogador atira no mar do inimigo objetivando acertar os navios inimigos
        // e após cada tentativa é exibido o status do mar do inimigo


    }

    public static String lerString(String mensagem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static void imprimeMar(Integer[][] mar) {
        System.out.println(
                "   | 0 | 1 | 2 | 3 | 4 |\n" +
                "--- --- --- --- --- ---"
        );

        for (int linha = 0; linha < mar.length; linha++) {
            System.out.print(" " + linha + " |");

            for (int coluna = 0; coluna < mar[linha].length; coluna++) {

                switch (mar[linha][coluna]) {
                    case MAR_SIMBOLO_VAZIO:
                        System.out.print(" " + MAR_SIMBOLO_VAZIO_CHAR + " |");
                        break;

                    case MAR_SIMBOLO_NAVIO_INTEIRO:
                        System.out.print(" " + MAR_SIMBOLO_NAVIO_INTEIRO_CHAR + " |");
                        break;

                    case MAR_SIMBOLO_NAVIO_QUEBRADO:
                        System.out.print(" " + MAR_SIMBOLO_NAVIO_QUEBRADO_CHAR + " |");
                        break;

                    case MAR_SIMBOLO_TIRO_ERRADO:
                        System.out.print(" " + MAR_SIMBOLO_TIRO_ERRADO_CHAR + " |");
                        break;
                }

            }

            System.out.println("\n--- --- --- --- --- ---");
        }
    }

    public static Integer[][] inicializaMar(int tamanhoMar) {
        Integer[][] mar = new Integer[tamanhoMar][tamanhoMar];

        for (int linha = 0; linha < mar.length; linha++) {
            for (int coluna = 0; coluna < mar[linha].length; coluna++) {
                mar[linha][coluna] = 0;
            }
        }

        return mar;
    }

    public static String lerNomeJogador() {
        String nomeJogador = lerString("Jogador, digite seu nome: ");
        nomeJogador = nomeJogador.trim();
        return nomeJogador.isBlank() ? "Jogador 1" : nomeJogador;
    }

    public static void posicionarBarco(Integer[][] mar, int indiceBarcoAtual, int qtdBarcos) {
        //receber posição x,y do barco
        int[] posicao;
        boolean deuErroNaLeitura = false;

        do {
            posicao = lerPosicaoValida(
                    mar,
                    "Digite a posição do barco, separando por vírgula (" + indiceBarcoAtual + "/" + qtdBarcos + "): "
            );

            //validar se já existe barco nessa posição
            if (mar[posicao[0]][posicao[1]] != MAR_SIMBOLO_VAZIO) {
                deuErroNaLeitura = true;
            }
        } while (deuErroNaLeitura);




        System.out.println();

        //atribuo a posição ao mar
        mar[posicao[0]][posicao[1]] = MAR_SIMBOLO_NAVIO_INTEIRO;
    }

    public static int[] lerPosicaoValida(Integer[][] mar, String mensagem) {
        int[] posicao = new int[2];
        boolean deuErroNaLeitura;

        do {
            //reiniciando a flag
            deuErroNaLeitura = false;

            String posicaoTemp = lerString(mensagem);

            String[] posicaoTempArray = posicaoTemp.split(",");

            try {
                posicao[0] = Integer.parseInt(posicaoTempArray[0].trim());
                posicao[1] = Integer.parseInt(posicaoTempArray[1].trim());

                //validar se posição x,y é válida dentro dos limites do mar
                for (int indice = 0; indice < posicao.length; indice++) {
                    if (posicao[indice] < 0 || posicao[indice] >= mar.length) {
                        deuErroNaLeitura = true;
                        break;
                    }
                }
            } catch (Exception bola) {
                //mandar repetir a digitação
                deuErroNaLeitura = true;
            }

            if (deuErroNaLeitura) System.out.println("iii... Infelimente você digitou a posição errada :(");
        } while (deuErroNaLeitura);

        return posicao;
    }

    public static void atirarNoMarInimigo(Integer[][] marInimigo) {

        //Validar se posição do tiro está dentro dos limites do mar

        //Validar se atingiu um barco
    }

}
