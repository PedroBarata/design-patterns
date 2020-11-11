package br.com.demo;

import java.util.HashMap;
import java.util.Map;

public class NotasMusicais {

    private static Map<String, Nota> notas = new HashMap<String, Nota>();

    /**Esse é um construtor estático, ou seja
     * ele é executado assim que instanciamos uma classe NotasMusicais.
     * */
    static {
        notas.put("do", new Do());
        notas.put("re", new Re());
        notas.put("mi", new Mi());
        notas.put("fa", new Fa());
        notas.put("sol", new Sol());
        notas.put("la", new La());
        notas.put("si", new Si());
    }

    public Nota pega(String nome) {
        return notas.get(nome);
    }
}
