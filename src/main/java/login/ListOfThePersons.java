//package login;
//
//import entity.Order;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ListOfThePersons {
//
//    static Map<String,String> map = new HashMap<>();
//    static List<PersonalData> list = new ArrayList<>();
//    static final String login = "A24";
//    static final String pass = "A24";
//    static final String name = "Alexey";
//    static final String surname = "Humarou";
//    static final String address = "Minsk city";
//    static final String email = "bonus_me@mail.ru";
//    static final String phone = "375296691066";
//
//    public static void addAdmin(){
//        map.put(login, pass);
//        map.put("1", "A24");
//        list.add(new PersonalData(login, pass, name, surname, address, email, phone));
//        list.add(new PersonalData("login","A24", "name", "surname",
//                "","",""));
//        list.add(new PersonalData("1","A24", "name", "surname",
//                "","",""));
//        list.add(new PersonalData("2","A24", "name", "surname",
//                "","",""));
//        list.add(new PersonalData("3","A24", "name", "surname",
//                "","",""));
//    }
//    public static void addUsersMap(String login, String pass){
//        map.put(login, pass);
//    }
//    public static void addUsersList(String login, String pass, String name, String surname, String address,
//                                    String email, String phone){
//        list.add(new PersonalData(login, pass, name, surname, address, email, phone));
//    }
//    public static List<PersonalData> getList() {
//        return list;
//    }
//
//    public static void removeUsersMap(String login, String pass){
//        map.remove(login,pass);
//    }
//
//
//
//}
