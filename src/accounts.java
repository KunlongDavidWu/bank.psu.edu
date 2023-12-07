import java.util.Map;

public class accounts {
    authentication auth=new authentication();
    private Map<String,Double> balance=Map.of("KunlongWu",1000.00,"ChrisGambino",2000.00,"MyPhuongDuong",3000.00);
    public Double getBalance(String username){
        return balance.get(username);
    }
    public void makeTransaction(String fromWhom,String toWhom,double amount){
        balance.put(fromWhom,balance.get(fromWhom)-amount);
        balance.put(toWhom,balance.get(toWhom)+amount);
    }
}