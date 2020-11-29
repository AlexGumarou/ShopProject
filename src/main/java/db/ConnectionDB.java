package db;
import Goods.Goods;
import Order.Order;
import login.PersonalData;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDB {

    private ConnectionDB() {
    }
    private static ConnectionDB instance = null;
    public static ConnectionDB getInstance(){
        if (instance==null)
            instance = new ConnectionDB();
        return instance;
    }

    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;

    public Connection getConnection() {
        Context ctx;
        Connection c = null;
        try {
            ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/poolDB");
            c = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    //этот метод достает всех пользователей из БД
    public List<PersonalData> getAllUsers() {
        connection = ConnectionDB.getInstance().getConnection();
        List<PersonalData> listOfUsers = new ArrayList<>();
        try {
            String sql = "SELECT login, pass, name, surname, address, email, phone FROM users";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String login = resultSet.getString("login");
                String pass = resultSet.getString("pass");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                listOfUsers.add(new PersonalData(login, pass, name, surname, address, email, phone));
            }
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfUsers;
    }

    //этот метод проверяет есть ли пользователь (а именно логин и пароль) в БД
    public boolean isUser(String login, String pass) {
        connection = ConnectionDB.getInstance().getConnection();
        try {
            String sql = "SELECT login, pass FROM users WHERE login = ? AND pass = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, pass);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String loginDB = resultSet.getString("login");
                String passDB = resultSet.getString("pass");
                if (loginDB.equals(login) && passDB.equals(pass)) {
                    return true;
                }
            }
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //этот метод проверяет текущего пользователя
    public List<PersonalData> isCurrentUser(String login, String pass) {
        connection = ConnectionDB.getInstance().getConnection();
        List<PersonalData> listOfCurrentUser = new ArrayList<>();

        try {
            String sql = "SELECT login, pass, name, surname, address, email, phone FROM users WHERE login = ? " +
                    "AND pass = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, pass);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String loginDB = resultSet.getString("login");
                String passDB = resultSet.getString("pass");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                if (loginDB.equals(login) && passDB.equals(pass)) {
                    listOfCurrentUser.add(new PersonalData(login, pass, name, surname, address, email, phone));
                }
            }
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfCurrentUser;
    }

    //этот метод удаляет существущего пользователя
    public void deleteUser(String login, String pass) {
        connection = ConnectionDB.getInstance().getConnection();
        try {
            String sql = "DELETE FROM users WHERE login = ? and pass = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, pass);
            statement.executeUpdate();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // этот метод добавляет пользователя
    public void addUser(String login, String pass, String name, String surname) {
        connection = ConnectionDB.getInstance().getConnection();
        try {
            String sql = "INSERT INTO users (login, pass, name, surname) VALUES (?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, pass);
            statement.setString(3, name);
            statement.setString(4, surname);
            statement.executeUpdate();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //этот метод достает все товары магазина
    public List<Goods> getAllGoods() {
        connection = ConnectionDB.getInstance().getConnection();
        List<Goods> listOfGoods = new ArrayList<>();
        try {
            String sql = "SELECT id, name, description, quantity, price, idPreOrder FROM goods";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int quantity = resultSet.getInt("quantity");
                int price = resultSet.getInt("price");
                int idPreOrder = resultSet.getInt("idPreOrder");
                listOfGoods.add(new Goods(id, name, description, quantity, price, idPreOrder));
            }
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfGoods;
    }

//    //получаем все заказы пользователей
//    public List<Order> getAllOrders(String user) {
//        connection = ConnectionDB.getInstance().getConnection();
//        List<Order> listOfOrders = new ArrayList<>();
//
//        try {
//            String sql = "SELECT id, orders, date FROM orders";
//            statement = connection.prepareStatement(sql);
//            resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                String id = resultSet.getString("id");
//                String orders = resultSet.getString("orders");
//                String time = resultSet.getString("date");
//                listOfOrders.add(new Order(id,user,orders,time,id));
//            }
//            connection.close();
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return listOfOrders;
//    }

    //этот метод для отображения заказа в корзине
    public List<Order> getOneOrder() {
        connection = ConnectionDB.getInstance().getConnection();
        List<Order> listOfOneOrder = new ArrayList<>();
        try {
            String sql = "SELECT name, price, quantity, sum FROM orderone";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                int sum = resultSet.getInt("sum");
                int id = listOfOneOrder.size();
                listOfOneOrder.add(new Order(id+1,name,price,quantity,sum));
            }
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfOneOrder;
    }

    // этот метод для добавления товара в 1 заказ
    public void addOneOrder(String name, int price, int quantity, int sum) {
        connection = ConnectionDB.getInstance().getConnection();
        try {
            String sql = "INSERT INTO orderone (name, price, quantity, sum) VALUES (?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, price);
            statement.setInt(3, quantity);
            statement.setInt(4, sum);
            statement.executeUpdate();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //этот метод очищает БД с одним текущим заказом
    public void deleteOneOrder() {
        connection = ConnectionDB.getInstance().getConnection();
        try {
            String sql = "TRUNCATE TABLE orderone";
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    // этот метод для добавления товара в 1 заказ
//    public void addOrders(String user, String order) {
//        connection = ConnectionDB.getInstance().getConnection();
//        int size = ConnectionDB.getInstance().getAllOrders(user).size();
//        String time = LocalDateTime.now().toString();
//        try {
//            String sql = "INSERT INTO orders (id, users, orders, date) VALUES (?,?,?,?)";
//            statement = connection.prepareStatement(sql);
//            statement.setInt(1, size+1);
//            statement.setString(2, user);
//            statement.setString(3, order);
//            statement.setString(4, time);
//            statement.executeUpdate();
//            connection.close();
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
