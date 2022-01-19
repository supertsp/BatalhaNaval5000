package br.com.tiagopedroso.batalhanaval5000.poo;

public class Mar {

    //atributos
    private char[][] tabuleiro;

    //construtores
    public Mar() {
        //é a regra para quando dou: new Mar()
        tabuleiro = new char[5][5];

        for (int linha = 0; linha < tabuleiro.length; linha++) {
            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
                tabuleiro[linha][coluna] = SimboloMar.VAZIO.getValor();
            }
        }
    }


    //métodos
    public String desenhar() {
        var divisorTabela = new StringBuilder("--- ");
        for (int cont = 0; cont < tabuleiro.length; cont++) {
            divisorTabela.append("--- ");
        }
        divisorTabela.append("\n");

        var desenho = new StringBuilder("   |");

        for (int cont = 0; cont < tabuleiro.length; cont++) {
            desenho.append(" ");
            desenho.append(cont);
            desenho.append(" |");
        }
        desenho.append("\n");
        desenho.append(divisorTabela);


        return desenho.toString();
    }


}
