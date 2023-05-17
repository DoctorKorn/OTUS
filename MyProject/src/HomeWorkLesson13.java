import java.util.List;

public class HomeWorkLesson13 {
    public static void main(String[] args) {
        initBankWithClientsAccounts();
    }
    private static void initBankWithClientsAccounts() {
        Bank bank = new Bank();
        Client petrov = new Client("Петров", 31);
        bank.addClient(petrov);
        bank.addAccountToClient(new Account("40817810900000000001"), petrov);
        bank.addAccountToClient(new Account("42301810400000000001"), petrov);

        Client ivanov = new Client("Иванов", 25);
        bank.addClient(ivanov);
        bank.addAccountToClient(new Account("40817810900000000002"), ivanov);

        Client smirnov = new Client("Смирнов", 38);
        bank.addClient(smirnov);
        bank.addAccountToClient(new Account("40817810900000000003"), smirnov);

        Client kuznetsov = new Client("Кузнецов", 16);
        bank.addClient(kuznetsov);
        bank.addAccountToClient(new Account("40817810900000000004"), kuznetsov);

        Client sidorov = new Client("Сидоров", 53);
        bank.addClient(sidorov);
        bank.addAccountToClient(new Account("40817810900000000005"), sidorov);

        List<Account> accountList = bank.getClientAccount(petrov);
        System.out.println("Поиск счёта по клиенту " + petrov.getName() + ":");
        if (accountList == null) {
            System.out.println("Не найдены счета по клиенту " + petrov.getName());
        } else {
            for (Account s : accountList) {
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
