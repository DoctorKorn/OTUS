import java.util.Objects;

public class Account {
    private final String number;
    public Account(String accountNumber) {
        this.number = accountNumber;
    }

    public String getAccountNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(number, account.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
