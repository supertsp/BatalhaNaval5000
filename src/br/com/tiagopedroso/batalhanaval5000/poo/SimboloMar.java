package br.com.tiagopedroso.batalhanaval5000.poo;

public enum SimboloMar {

    VAZIO('~'),
    NAVIO_INTEIRO('#'),
    NAVIO_QUEBRADO('X'),
    TIRO_ERRADO('^');

    private char valor;

    SimboloMar(char valor) {
        this.valor = valor;
    }

    public char getValor() {
        return this.valor;
    }

}
