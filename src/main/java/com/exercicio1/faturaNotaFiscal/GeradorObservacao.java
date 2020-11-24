package com.exercicio1.faturaNotaFiscal;

import java.util.Iterator;
import java.util.List;

public class GeradorObservacao implements FaturaNotaFiscal<List<Integer>> {

    private static final Integer QUANTIDADE_DE_VALORES_PLURAL = 2;
    private static final String NOTA_SINGULAR = "Fatura da nota fiscal de simples remessa: ";
    private static final String NOTA_PLURAL = "Fatura das notas fiscais de simples remessa: ";
    private static final String NOTA_VALOR_VAZIO = "";


    // geraObservacao recebe uma lista de valores
    public String geraObservacao(List<Integer> valores) {
        if (!valores.isEmpty()) {
            return retornaCodigos(valores);
        }
        return NOTA_VALOR_VAZIO;
    }

    private String retornaCodigos(List<Integer> valores) {
        StringBuilder codigos = new StringBuilder();
        for (Iterator<Integer> iterator = valores.iterator(); iterator.hasNext(); ) {
            Integer codigo = iterator.next();

            String separador;
            if (codigos.toString().length() == 0)
                separador = "";
            else if (iterator.hasNext())
                separador = ", ";
            else
                separador = " e ";

            codigos.append(separador).append(codigo);
        }

        String caractereFinal = ".";
        codigos.append(caractereFinal);

        if (valores.size() >= QUANTIDADE_DE_VALORES_PLURAL) {
            return NOTA_PLURAL + codigos;
        } else {
            return NOTA_SINGULAR + codigos;
        }

    }
}