package exercicio2;

import com.exercicio2.calculadorComposicao.CalculaComposicao;
import com.exercicio2.calculadorComposicao.TabelaComposicoes;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TabelaComposicoesTest {
    TabelaComposicoes tabelaComposicoes = new TabelaComposicoes();
    CalculaComposicao calculaComposicao = new CalculaComposicao();
    // nomes dos testes definido no formato metodoTestado_estadoTestado_valorEsperado

    @Test
    void geraTabelaDeComposicoes_listaVaziaDeComposicoes_textoVazio() {
        JSONArray composicoes = new JSONArray();

        String textoTabelaDeComposicoes = tabelaComposicoes.geraTabelaDeComposicoes(
                composicoes, calculaComposicao);
        String textoEsperado = "";

        assertEquals(textoEsperado, textoTabelaDeComposicoes);

    }

    @Test
    void calculaComposicao_listaComItensDeUmaComposicao_textoDaComposicao()
            throws IOException, ParseException {
        Object composicoesGenerico = new JSONParser().parse(
                new FileReader("test/exercicio2/itens-de-uma-composicao.json"));
        JSONArray composicoes = (JSONArray) composicoesGenerico;
        String textoComposicao =
                tabelaComposicoes.geraTabelaDeComposicoes(composicoes, calculaComposicao);

        String textoEsperado = "94793 REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, 1 1/4, " +
                "COM ACABAMENTO E CANOPLA CROMADOS, INSTALADO EM RESERVAÇÃO DE ÁGUA DE " +
                "EDIFICAÇÃO QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO FORNECIMENTO E " +
                "INSTALAÇÃO. AF_06/2016 UN 128.61\n";

        assertEquals(textoEsperado, textoComposicao);
    }

    @Test
    void calculaComposicao_listaComItensVariasComposicoes_textoComComposicoes()
            throws IOException, ParseException {
        Object composicoesGenerico = new JSONParser().parse(
                new FileReader("test/exercicio2/itens-de-varias-composicoes.json"));
        JSONArray composicoes = (JSONArray) composicoesGenerico;
        String textoComposicao =
                tabelaComposicoes.geraTabelaDeComposicoes(composicoes, calculaComposicao);

        String textoEsperado = "94793 REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, 1 1/4, " +
                "COM ACABAMENTO E CANOPLA CROMADOS, INSTALADO EM RESERVAÇÃO DE ÁGUA DE " +
                "EDIFICAÇÃO QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO FORNECIMENTO E " +
                "INSTALAÇÃO. AF_06/2016 UN 128.61\n" +
                "98561 IMPERMEABILIZAÇÃO DE PAREDES COM ARGAMASSA DE CIMENTO E AREIA, " +
                "COM ADITIVO IMPERMEABILIZANTE, E = 2CM. AF_06/2018 M2 21.5\n";

        assertEquals(textoEsperado, textoComposicao);
    }


}
