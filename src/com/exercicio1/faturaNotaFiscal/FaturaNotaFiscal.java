package com.exercicio1.faturaNotaFiscal;

public interface FaturaNotaFiscal<Tipo> {
    //Gera observações, com texto pre-definido
    String geraObservacao(Tipo valores);
}
