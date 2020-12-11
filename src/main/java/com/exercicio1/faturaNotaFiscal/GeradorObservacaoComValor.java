package com.exercicio1.faturaNotaFiscal;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class GeradorObservacaoComValor implements FaturaNotaFiscal<Map<Integer, Double>> {
    private static final String TEXTO_TOTAL = "Total = ";
    private static final String TEXTO_VALOR_ITEM = " cujo valor é ";
    NumberFormat formatadorNumeroParaReal = NumberFormat.getCurrencyInstance(
            new Locale("pt", "BR"));

    public String geraObservacao(Map<Integer, Double> valoresComPrecos) {
        if (valoresComPrecos.size() == 0)
            return NOTA_VALOR_VAZIO;
        else if (valoresComPrecos.size() < QUANTIDADE_DE_VALORES_PLURAL)
            return this.geraFaturaSingular(valoresComPrecos);
        else
            return this.geraFaturaPlural(valoresComPrecos);


    }

    private String geraFaturaSingular(Map<Integer, Double> valorComPreco) {
        Map.Entry<Integer, Double> item =
                valorComPreco.entrySet().iterator().next();

        String descricaoItemNaFatura =
                item.getKey() + TEXTO_VALOR_ITEM +
                        formatadorNumeroParaReal.format(item.getValue()) +
                        ". " + TEXTO_TOTAL +
                        formatadorNumeroParaReal.format(item.getValue());

        return NOTA_SINGULAR + descricaoItemNaFatura;
    }

    private String geraFaturaPlural(Map<Integer, Double> valoresComPrecos) {
        List<String> valoresComPrecoFormatados = new ArrayList<>();
        Double precoTotal = 0.;

        for (Map.Entry<Integer, Double> item : valoresComPrecos.entrySet()) {
            precoTotal += item.getValue();
            String descricaoItemNaFatura = item.getKey() + TEXTO_VALOR_ITEM +
                    formatadorNumeroParaReal.format(item.getValue());
            valoresComPrecoFormatados.add(descricaoItemNaFatura);

        }

        StringBuilder faturaNotaFiscal = new StringBuilder();
        String separador;
        for (int i = 1; i <= valoresComPrecoFormatados.size(); i++) {
            if (i < valoresComPrecoFormatados.size() - 1)
                separador = ", ";
            else if (i < valoresComPrecoFormatados.size())
                separador = " e ";
            else
                separador = ". ";

            String valorComPrecoFormatado = valoresComPrecoFormatados.get(i - 1);
            faturaNotaFiscal.append(valorComPrecoFormatado).append(separador);
        }

        String precoTotalEmReal = formatadorNumeroParaReal.format(precoTotal);
        faturaNotaFiscal.append(TEXTO_TOTAL).append(precoTotalEmReal).append(".");

        return NOTA_PLURAL + faturaNotaFiscal;

    }
}

