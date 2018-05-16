package br.com.munieri.banco.horas.entity;

import br.com.munieri.banco.horas.util.DateUtil;

public class Summary {

    private String balance;

    public Summary(int sum) {
        this.balance = DateUtil.formatBalance(sum);
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
