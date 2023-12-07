import java.util.Map;

public class authentication {
    private Map <String,String> accountData=Map.of("KunlongWu","qwertyuiop","ChrisGambino","asdfghjkl;'","MyPhuongDuong","zxcvbnm,./");
    public Boolean auth (String username,String password){
        return accountData.containsKey(username)&&accountData.get(username).equals(password);
    }
}
