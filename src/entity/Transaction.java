package entity;

import java.util.Date;
import java.util.Objects;

public class Transaction extends AbstractEntity {
    private Long timestamp;
    private String memo;
    private Account inAccount;
    private Double amount;

    public Transaction(Long id, String memo, Account inAccount, Double amount) {
        super(id);
        this.memo = memo;
        this.inAccount = inAccount;
        this.amount = amount;
        this.timestamp = new Date().getTime();
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getMemo() {
        return memo;
    }

    public Account getInAccount() {
        return inAccount;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return timestamp.equals(that.timestamp) &&
                memo.equals(that.memo) &&
                inAccount.equals(that.inAccount) &&
                amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, memo, inAccount, amount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "timestamp=" + timestamp +
                ", memo='" + memo + '\'' +
                ", inAccount=" + inAccount +
                ", amount=" + amount +
                '}';
    }
}
