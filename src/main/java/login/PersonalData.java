package login;

public class PersonalData {
    private String login;
    private String pass;
    private String name;
    private String surname;

    public PersonalData(String login, String pass, String name, String surname) {
        this.login = login;
        this.pass = pass;
        this.name = name;
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }
    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "PersonalData{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
