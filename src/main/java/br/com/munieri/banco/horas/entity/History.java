package br.com.munieri.banco.horas.entity;

import br.com.munieri.banco.horas.util.DateUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class History {

    private String day;

    private String balance;

    public History() {
    }

    public History(LocalDate day, Integer balance) {
        this.day = day.format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD));
        this.balance = DateUtil.formatBalance(balance);
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
