package exercicio2;

import com.exercicio2.calculadorComposicao.CalculadorComposicao;
import com.exercicio2.calculadorComposicao.Composicao;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class CalculaComposicaoTest {
    Composicao calculaComposicao = new CalculadorComposicao();

    // nomes dos testes definido no formato metodoTestado_estadoTestado_valorEsperado

    @Test
    void calculaComposicao_listaDeComposicoesVazia_textoVazio() {
        JSONArray composicaoSemItens = new JSONArray();

        String textoComposicao =
                calculaComposicao.calcular(composicaoSemItens);
        String textoEsperado = "";

        assertEquals(textoEsperado, textoComposicao);
    }

    @Test
    void calculaComposicao_listaComItensDeUmaComposicao_textoDaComposicao()
            throws IOException, ParseException {
        Object composicoesGenerico = new JSONParser().parse(
                new FileReader("./target/test-classes/itens-de-uma-composicao.json"));
        JSONArray composicoes = (JSONArray) composicoesGenerico;

        String textoComposicao = calculaComposicao.calcular(composicoes);
        String textoEsperado = "94793 REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, 1 1/4, " +
                "COM ACABAMENTO E CANOPLA CROMADOS, INSTALADO EM RESERVAÇÃO DE ÁGUA DE " +
                "EDIFICAÇÃO QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO FORNECIMENTO E " +
                "INSTALAÇÃO. AF_06/2016 UN 128.61";

        assertEquals(textoEsperado, textoComposicao);
    }


}
