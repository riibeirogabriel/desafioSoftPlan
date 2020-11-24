package com.exercicio2.calculadorComposicao;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.DecimalFormat;


public class CalculaComposicao implements CalculadorComposicao {

    private static final Integer INDICE_ITEM_NA_COMPOSICAO = 0;
    private static final String VALOR_UNITARIO_CASO_NULO = "0";
    private static final String QUANTIDADE_COMPOSICAO_CASO_NULO = "0";
    private static final String SEPARADOR_ITENS_TEXTO_COMPOSICAO = " ";
    private static final String RESPOSTA_CASO_ENTRADA_VAZIA = "";
    public String calculaComposicao(JSONArray composicao) {
        if(composicao.size() == 0)
            return RESPOSTA_CASO_ENTRADA_VAZIA;

        JSONObject itemDaComposicao = (JSONObject) composicao.get(INDICE_ITEM_NA_COMPOSICAO);

        String codigoComposicao = itemDaComposicao.get("codigoComposicao").toString();
        String descricaoComposicao = itemDaComposicao.get("descricaoComposicao").toString();
        String unidadeComposicao = itemDaComposicao.get("unidadeComposicao").toString();

        double valorTotalComposicao = 0.;

        for (Object itemTipoGenerico : composicao) {
            JSONObject item = (JSONObject) itemTipoGenerico;

            String quantidadeComposicao = item.get("quantidadeComposicao").toString();
            String valorUnitario = item.get("valorUnitario").toString();

            quantidadeComposicao = quantidadeComposicao.replace(",", ".");
            valorUnitario = valorUnitario.replace(",", ".");

            if (quantidadeComposicao.equals(""))
                quantidadeComposicao = QUANTIDADE_COMPOSICAO_CASO_NULO;
            if (valorUnitario.equals(""))
                valorUnitario = VALOR_UNITARIO_CASO_NULO;

            valorTotalComposicao += Double.parseDouble(quantidadeComposicao) *
                    Double.parseDouble(valorUnitario);
        }

        DecimalFormat formatadorValorTotal = new DecimalFormat("#.##");
        return String.join(
                SEPARADOR_ITENS_TEXTO_COMPOSICAO,
                codigoComposicao,
                descricaoComposicao,
                unidadeComposicao,
                formatadorValorTotal.format(valorTotalComposicao));


    }

}
