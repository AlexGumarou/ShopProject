import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfThePersons {
    List<PersonalData> list = new ArrayList<>();
    Map<String,String> map = new HashMap<>();

    public void addAdmin(){
        map.put("admin", "admin");
        list.add(new PersonalData("admin","admin","Alex","Humarou",2018));
    }
    public void addUsers(String login, String pass, String name, String surname, int year){
        map.put(login, pass);
        list.add(new PersonalData(login, pass, name, surname, year));
    }
}
