import java.util.*;

public class Bank {
    // для быстрого поиска счетов по клиенту
    private Map<Client, List<Account>> cliacc = new HashMap<>();
    // для быстрого поиска клиента по счету
    private Map<Account, Client> acccli = new HashMap<>();

    public void addClient(Client client) {
        this.cliacc.put(client, null);
    }

    public void addAccountToClient(Account account, Client client){
        this.cliacc.putIfAbsent(client, new ArrayList<>());
        this.cliacc.get(client).add(account);
        this.acccli.put(account, client);
    }
    // получение счетов по клиенту
    public List<Account> getClientAccount (Client client) {
        return this.cliacc.get(client);
    }
    // получение клиента по счету (не самый быстрый поиск по значению!!!)
    public Client getClientByAccountSlow (Account account) {
        for (Map.Entry<Client, List<Account>> entry : this.cliacc.entrySet()) {
            List<Account> accountList = entry.getValue();
            if (accountList.isEmpty()) {
                return null;
            } else {
                for (int i = 0; i < accountList.size(); i++ ) {
                    if (Objects.equals(account, accountList.get(i))) {
                        return entry.getKey();
                    }
                }
            }
        }
        return null;
    }
    // получение клиента по счету (быстрый поиск по ключу!)
    public Client getClientByAccountFast(Account account){
        return this.acccli.get(account);
    }
}
