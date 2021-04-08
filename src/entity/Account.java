package entity;

import java.util.Objects;

public class Account extends AbstractEntity {
    private String name;
    private Double balance;
    private User holder;

    public Account(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public User getHolder() {
        return holder;
    }

    public void setHolder(User holder) {
        this.holder = holder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return name.equals(account.name) &&
                balance.equals(account.balance) &&
                Objects.equals(holder, account.holder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance, holder);
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", holder=" + holder +
                '}';
    }
}
