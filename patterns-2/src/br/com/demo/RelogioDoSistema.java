package br.com.demo;

import java.util.Calendar;
import java.util.Date;

public class RelogioDoSistema implements Relogio {
    @Override
    public Date hoje() {
        return Calendar.getInstance().getTime();
    }
}
