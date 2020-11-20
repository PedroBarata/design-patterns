public enum Cargo {
    DESENVOLVEDOR(new DezOuVintePorCento()),
    DBA(new QuinzeOuVinteECincoPorCento()),
    TESTER(new QuinzeOuVinteECincoPorCento());


    private final RegraDeSalario regraDeSalario;

    Cargo(RegraDeSalario regraDeSalario) {
        this.regraDeSalario = regraDeSalario;
    }

    public RegraDeSalario getRegraDeSalario() {
        return regraDeSalario;
    }
}
