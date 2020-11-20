package SRP;

public class CalculadoraDeSalario {
    public double calcula(Funcionario funcionario) {
        return funcionario.calculaSalario();
    }
}



/*========================= COMO ERA ===================================*/
/*
public class SRP.CalculadoraDeSalario {
    public double calcula(SRP.Funcionario funcionario) {
        if(SRP.Cargo.DESENVOLVEDOR.equals(funcionario.getCargo())) {
            return dezOuVintePorcento(funcionario);
        }

        if(SRP.Cargo.DBA.equals(funcionario.getCargo()) || SRP.Cargo.TESTER.equals(funcionario.getCargo())) {
            return quinzeOuVinteCincoPorcento(funcionario);
        }

        throw new RuntimeException("funcionario invalido");
    }

    private double dezOuVintePorcento(SRP.Funcionario funcionario) {
        if(funcionario.getSalarioBase() > 3000.0) {
            return funcionario.getSalarioBase() * 0.8;
        }
        else {
            return funcionario.getSalarioBase() * 0.9;
        }
    }

    public double quinzeOuVinteECincoPorCento(SRP.Funcionario funcionario) {
        if(funcionario.getSalarioBase() > 2000.0) {
            return funcionario.getSalarioBase() * 0.75;
        }
        else {
            return funcionario.getSalarioBase() * 0.85;
        }
    }
}
*/
