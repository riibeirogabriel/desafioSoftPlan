package com.exercicio2.main;

import com.exercicio2.calculadorComposicao.CalculaComposicao;
import com.exercicio2.calculadorComposicao.CalculadorComposicao;
import com.exercicio2.calculadorComposicao.TabelaComposicoes;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static String DIRETORIO_COMPOSICAO_JSON =
            "src/com/exercicio2/dados-entrada-servicos-composicoes.json";

    public static void main(String[] args) throws ParseException, IOException {

        Object composicoesGenerico = new JSONParser().parse(new FileReader(DIRETORIO_COMPOSICAO_JSON));
        JSONArray composicoes = (JSONArray) composicoesGenerico;

        CalculadorComposicao calculadorComposicao = new CalculaComposicao();
        TabelaComposicoes tabelaComposicoes = new TabelaComposicoes();
        String tabelaDeComposicoes =
                tabelaComposicoes.geraTabelaDeComposicoes(composicoes, calculadorComposicao);

        System.out.print(tabelaDeComposicoes);
    }

}
