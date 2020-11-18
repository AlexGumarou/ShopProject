import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfThePersons {

    static Map<String,String> map = new HashMap<>();
    static List<PersonalData> list = new ArrayList<>();
    static final String login = "A24";
    static final String pass = "A24";
    public static void addAdmin(){
        map.put(login, pass);
        list.add(new PersonalData(login,pass, "Alexey", "Humarou"));
    }
    public static void addUsersMap(String login, String pass){
        map.put(login, pass);
    }
    public static void addUsersList(String login, String pass, String name, String surname){
        list.add(new PersonalData(login, pass, name,surname));
    }
}
