package br.com.caelum.leilao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatematicaMalucaTest {

    @Test
    public void maiorQue30_deveRetornar_numeroVezes4() {
        //cenario
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
        //execucao
        double numero = matematicaMaluca.contaMaluca(40);

        //assercao
        assertEquals(160.0,  numero, 0.0001);
    }

    @Test
    public void igual30_deveRetornar_numeroVezes3() {
        //cenario
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
        //execucao
        double numero = matematicaMaluca.contaMaluca(30);

        //assercao
        assertEquals(90.0, numero, 0.0001);
    }

    @Test
    public void entre10e30_deveRetornar_numeroVezes3() {
        //cenario
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
        //execucao
        double numero = matematicaMaluca.contaMaluca(15);

        //assercao
        assertEquals(45.0, numero, 0.0001);
    }

    @Test
    public void igual10_deveRetornar_numeroVezes2() {
        //cenario
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
        //execucao
        double numero = matematicaMaluca.contaMaluca(10);

        //assercao
        assertEquals(20.0, numero, 0.0001);
    }

    @Test
    public void menorQue10_deveRetornar_numeroVezes2() {
        //cenario
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
        //execucao
        double numero = matematicaMaluca.contaMaluca(5);

        //assercao
        assertEquals(10.0, numero, 0.0001);
    }

}