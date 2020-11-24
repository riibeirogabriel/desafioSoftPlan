package com.exercicio2.calculadorComposicao;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class TabelaComposicoes {
    private static final String SEPARADOR_COMPOSICOES = "\n";

    public String geraTabelaDeComposicoes(JSONArray composicoes, CalculadorComposicao calculadorComposicao) {
        Map<Integer, JSONArray> itemsPorComposicao = separaItemsPorComposicao(composicoes);

        StringBuilder tabelaDeComposicoes = new StringBuilder();

        itemsPorComposicao.forEach((codigo, itens) ->
                tabelaDeComposicoes.append(
                        calculadorComposicao.calculaComposicao(itens)).append(SEPARADOR_COMPOSICOES));

        return tabelaDeComposicoes.toString();
    }


    private static Map<Integer, JSONArray> separaItemsPorComposicao(JSONArray composicoes) {
        Map<Integer, JSONArray> itemsPorComposicao = new LinkedHashMap<>();

        composicoes.forEach(itemGenerico -> {
            JSONObject item = (JSONObject) itemGenerico;
            Integer codigoComposicao = Integer.parseInt(item.get("codigoComposicao").toString());

            if (itemsPorComposicao.get(codigoComposicao) == null) {
                JSONArray listaDeItens = new JSONArray();
                listaDeItens.add(item);
                itemsPorComposicao.put(codigoComposicao, listaDeItens);
            } else
                itemsPorComposicao.get(codigoComposicao).add(item);
        });

        return itemsPorComposicao;
    }
}
