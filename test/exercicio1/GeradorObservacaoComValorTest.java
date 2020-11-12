package exercicio1;

import static org.junit.jupiter.api.Assertions.*;

import com.exercicio1.faturaNotaFiscal.GeradorObservacaoComValor;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class GeradorObservacaoComValorTest {
    private final GeradorObservacaoComValor geradorObservacaoComValor =
            new GeradorObservacaoComValor();

    // nomes dos testes definido no formato metodoTestado_estadoTestado_ValorEsperado
    @Test
    void geraObservacao_semValor_textoVazio() {
        String textoEsperado = "";
        HashMap<Integer, Double> valorComPreco = new HashMap<>();

        assertEquals(textoEsperado, geradorObservacaoComValor.geraObservacao(valorComPreco));
    }

    @Test
    void geraObservacao_unicoValor_textoNoSingular() {
        String textoEsperado =
                "Fatura da nota fiscal de simples remessa:" +
                        " 1 cujo valor é R$ 10,00." +
                        " Total = R$ 10,00";
        HashMap<Integer, Double> valorComPreco = new HashMap<>();
        valorComPreco.put(1, 10.00);

        assertEquals(textoEsperado, geradorObservacaoComValor.geraObservacao(valorComPreco));
    }

    @Test
    void geraObservacao_doisValores_textoNoPluralComSeparadorE() {
        String textoEsperado =
                "Fatura das notas fiscais de simples remessa:" +
                        " 1 cujo valor é R$ 10,00" +
                        " e 5 cujo valor é R$ 0,30." +
                        " Total = R$ 10,30.";
        HashMap<Integer, Double> valoresComPrecos = new HashMap<>();
        valoresComPrecos.put(1, 10.00);
        valoresComPrecos.put(5, 0.30);

        assertEquals(textoEsperado, geradorObservacaoComValor.geraObservacao(valoresComPrecos));
    }

    @Test
    public void geraObservacao_multiplosValores_textoNoPlural() {

        String textoEsperado =
                "Fatura das notas fiscais de simples remessa:" +
                        " 1 cujo valor é R$ 10,00," +
                        " 2 cujo valor é R$ 35,00," +
                        " 3 cujo valor é R$ 5,00," +
                        " 4 cujo valor é R$ 1.500,00" +
                        " e 5 cujo valor é R$ 0,30." +
                        " Total = R$ 1.550,30.";
        HashMap<Integer, Double> valoresComPrecos = new HashMap<>();
        valoresComPrecos.put(1, 10.00);
        valoresComPrecos.put(2, 35.00);
        valoresComPrecos.put(3, 5.00);
        valoresComPrecos.put(4, 1500.00);
        valoresComPrecos.put(5, 0.30);

        assertEquals(textoEsperado, geradorObservacaoComValor.geraObservacao(valoresComPrecos));


    }
}
