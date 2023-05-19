import java.util.Set;

public class HomeWorkLesson13 {
    public static void main(String[] args) {
        initBankWithClientsAccounts();
    }
    private static void initBankWithClientsAccounts() {
        Bank bank = new Bank();
        bank.addClient(new Client("Петров", 31));
        bank.addAccountToClient(new Account("40817810900000000001"), new Client("Петров", 31));
        bank.addAccountToClient(new Account("42301810400000000001"), new Client("Петров", 31));

        bank.addClient(new Client("Иванов", 25));
        bank.addAccountToClient(new Account("40817810900000000002"), new Client("Иванов", 25));

        bank.addClient(new Client("Смирнов", 38));
        bank.addAccountToClient(new Account("40817810900000000003"), new Client("Смирнов", 38));

        bank.addClient(new Client("Кузнецов", 16));
        bank.addAccountToClient(new Account("40817810900000000004"), new Client("Кузнецов", 16));

        bank.addClient(new Client("Сидоров", 53));
        bank.addAccountToClient(new Account("40817810900000000005"), new Client("Сидоров", 53));

        Set<Account> accountSet = bank.getClientAccount(new Client("Петров", 31));
        System.out.println("Поиск счёта по клиенту " + new Client("Петров", 31).getName() + ":");
        if (accountSet == null) {
            System.out.println("Не найдены счета по клиенту " + new Client("Петров", 31).getName());
        } else {
            for (Account s : accountSet) {
                System.out.println(s.getAccountNumber());
            }
        }
        Account account = new Account("40817810900000000003");
        Client client = bank.getClientByAccountFast(account);
        System.out.println("Поиск клиента по счёту " + account.getAccountNumber() + ":");
        if (client == null) {
            System.out.println("Не найден клиент по счету " + account.getAccountNumber());
        } else {
            System.out.println(client.getName());
        }
    }
}
