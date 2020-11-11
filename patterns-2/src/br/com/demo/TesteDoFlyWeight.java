package br.com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TesteDoFlyWeight {

    /**
     * Neste padrão, instanciamos as classes apenas uma vez
     */
    public static void main(String[] args) {
        NotasMusicais notas = new NotasMusicais();
        List<Nota> musica = Arrays.asList(
                notas.pega("do"),
                notas.pega("re"),
                notas.pega("mi"),
                notas.pega("fa"),
                notas.pega("fa"),
                notas.pega("fa")
        );

        System.out.println(musica);
    }
}
