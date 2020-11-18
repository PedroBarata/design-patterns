package br.com.demo;

import java.util.Date;

public class TesteDoPadraoBridgeEAdapter {


    /**
     * No padrao brigdge, fazemos uma ponte
     * entre a nossa aplicacao e a aplicacao de terceiros
     * atraves de uma interface que será implementada
     * (no caso, o google maps)
     */
    public static void main(String[] args) {
        MapaBridge mapaBridge = new MapaGoogle();
        String localizacao = mapaBridge.obtemLocalizacao("Endereco");


        /**
         * No padrao adapter, adaptamos um código legado
         * para o código novo, através de uma interface.
         * Ela "esconde" o código legado, e refatoramos
         * para o código novo quando tivermos tempo.
         * */
        Relogio relogio = new RelogioDoSistema();
        Date dataDeHoje = relogio.hoje();
    }
}
