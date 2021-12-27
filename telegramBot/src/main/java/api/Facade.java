package api;

import api.bank.MonoAPI;
import api.bank.NbuAPI;
import api.bank.BankResponce;
import api.bank.PrivatAPI;

import java.io.IOException;
import java.util.List;

public class Facade {
    private MonoAPI monoApi = new MonoAPI();
    private NbuAPI nbuAPI = new NbuAPI();
    private PrivatAPI privatAPI = new PrivatAPI();

    public List<BankResponce> getBankInfo(String bankName) throws IOException, InterruptedException {
        return switch (bankName) {
            case "Монобанк" -> monoApi.getCurrencyfromBank();
            case "НБУ" -> nbuAPI.getCurrencyfromBank();
            case "Приватбанк" -> privatAPI.getCurrencyfromBank();
            default -> null;
        };

    }
}