package exercicio1;

import com.exercicio1.faturaNotaFiscal.GeradorObservacao;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeradorObservacaoTest {
    private final GeradorObservacao geradorObservacao = new GeradorObservacao();

    //  nomes dos testes definido no formato metodoTestado_estadoTestado_ValorEsperado
    @Test
    void geraObservacao_semValor_textoVazio() {
        String textoEsperado = "";
        List<Integer> valor = Arrays.asList();

        assertEquals(textoEsperado, geradorObservacao.geraObservacao(valor));

    }

    @Test
    void geraObservacao_unicoValor_textoNoSingular() {
        String textoEsperado =
                "Fatura da nota fiscal de simples remessa: 5.";
        List<Integer> valor = Arrays.asList(5);

        assertEquals(textoEsperado, geradorObservacao.geraObservacao(valor));

    }

    @Test
    void geraObservacao_doisValores_textoNoPluralComSeparadorE() {
        String textoEsperado =
                "Fatura das notas fiscais de simples remessa: 1 e 5.";
        List<Integer> valores = Arrays.asList(1, 5);

        assertEquals(textoEsperado, geradorObservacao.geraObservacao(valores));
    }

    @Test
    void geraObservacao_mutiplosValores_textoNoPlural() {
        String textoEsperado =
                "Fatura das notas fiscais de simples remessa: 1, 2, 3, 4 e 5.";
        List<Integer> valores = Arrays.asList(1, 2, 3, 4, 5);

        assertEquals(textoEsperado, geradorObservacao.geraObservacao(valores));
    }
}
