package org.example;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Account {
    private String name;
    private HashMap<CurTypes, BigDecimal> currencies;
    private Deque<Command> commands = new ArrayDeque<>();

    private Account(){}
    public Account(String name) {
        this.setName(name);
        this.currencies = new HashMap<>();
    }

    public Account undo() throws NothingToUndo{
        if (commands.isEmpty()) throw new NothingToUndo();
        commands.pop().execute();
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("The Account.name must not be empty");
        String oldName = this.name;
        this.commands.push(()->{this.name = oldName;});
        this.name = name;
    }

    public HashMap<CurTypes, BigDecimal> getcurrencies() {
        return new HashMap<CurTypes, BigDecimal>(this.currencies);
    }

    public void putCurrencies(CurTypes curtype, BigDecimal val) {
        if (val.signum() != 1) throw new IllegalArgumentException("The currencies value must be greater then zero");
        if (currencies.containsKey(curtype)){
            BigDecimal oldVal = this.currencies.get(curtype);
            this.commands.push(()->{this.currencies.put(curtype,oldVal);});
        } else {
            this.commands.push(()->{this.currencies.remove(curtype);});
        }
        this.currencies.put(curtype, val);
    }

    @Override
    public String toString() {
        return "Account{" + "name='" + name + '\'' + ", currencies=" + currencies + '}';
    }

}
