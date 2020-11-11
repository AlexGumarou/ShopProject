import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfThePersons {
    static List<PersonalData> list = new ArrayList<>();
    static Map<String,String> map = new HashMap<>();

    public static List<PersonalData> getList() {
        return list;
    }

    public static void setList(List<PersonalData> list) {
        ListOfThePersons.list = list;
    }

    public static void addAdmin(){
        map.put("admin", "admin");
        list.add(new PersonalData("admin","admin","Alex","Humarou",2018));
    }
    public static void addUsers(String login, String pass, String name, String surname, int year){
        map.put(login, pass);
        list.add(new PersonalData(login, pass, name, surname, year));
    }
}
