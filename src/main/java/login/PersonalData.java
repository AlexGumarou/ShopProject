package login;

public class PersonalData {
    private String login;
    private String pass;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String phone;

    public PersonalData(String login, String pass, String name, String surname, String address, String email,
                        String phone) {
        this.login = login;
        this.pass = pass;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.phone = phone;
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
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return  "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'';
    }
}
