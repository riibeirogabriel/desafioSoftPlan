package com.exercicio1.faturaNotaFiscal;

public interface FaturaNotaFiscal<Tipo> {
    Integer QUANTIDADE_DE_VALORES_PLURAL = 2;
    String NOTA_SINGULAR =
            "Fatura da nota fiscal de simples remessa: ";
    String NOTA_PLURAL =
            "Fatura das notas fiscais de simples remessa: ";
    String NOTA_VALOR_VAZIO = "";

    String geraObservacao(Tipo valores);
}
