package db;
import Goods.Goods;
import Order.Order;
import Order.Orders;
import login.PersonalData;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.sql.SQLException;
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
            String sql = "SELECT id, name, description, quantity, price FROM goods";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int quantity = resultSet.getInt("quantity");
                int price = resultSet.getInt("price");
                listOfGoods.add(new Goods(id, name, description, quantity, price));
            }
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfGoods;
    }

    //получаем все заказы пользователей
    public List<Orders> getAllOrders(String user) {
        connection = ConnectionDB.getInstance().getConnection();
        List<Orders> listOfOrders = new ArrayList<>();
        try {
            String sql = "SELECT id, orders, date FROM orders WHERE users = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, user);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String orders = resultSet.getString("orders");
                String time = resultSet.getString("date");
                listOfOrders.add(new Orders(id,user,orders,time));
            }
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfOrders;
    }

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

    //в этом методе получаем максимальный id из таблицы с заказами
    public int getIdOfOrders() {
        connection = ConnectionDB.getInstance().getConnection();
        int id = 0;
        try {
            String sql = "SELECT MAX(id) FROM orders";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    // этот метод преобразует дату из util в sql
    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    // этот метод для добавления товара в 1 заказ
    public void addOrders(String user, String order) {
        int size = ConnectionDB.getInstance().getIdOfOrders();
        connection = ConnectionDB.getInstance().getConnection();
        try {
            String sql = "INSERT INTO orders(id, orders, users, date) VALUES (?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, size + 1);
            statement.setString(2, order);
            statement.setString(3, user);
            statement.setDate(4, getCurrentDate());
            statement.execute();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //этот метод удаляет товар из БД
    public void deleteGoods(String name) {
        connection = ConnectionDB.getInstance().getConnection();
        try {
            String sql = "DELETE FROM goods WHERE name = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.executeUpdate();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // этот метод добавляет товары
    public void addGoods(String name, String description, int quantity, int price) {
        int id = getIdOfGoods() + 1;
        connection = ConnectionDB.getInstance().getConnection();
        try {
            String sql = "INSERT INTO goods (id, name, description, quantity, price) VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, description);
            statement.setInt(4, quantity);
            statement.setInt(5, price);
            statement.executeUpdate();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // в этом методе получаем максимальный id из БД товаров
    public int getIdOfGoods() {
        connection = ConnectionDB.getInstance().getConnection();
        int id = 0;
        try {
            String sql = "SELECT MAX(id) FROM goods";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    // в этом методе изменяем товары
    public void editGoods(int id, String name, String description, int quantity, int price) {
        connection = ConnectionDB.getInstance().getConnection();
        try {
            String sql = "UPDATE goods SET id = ?, name = ?, description = ?, quantity = ?, price = ? WHERE (id = ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, description);
            statement.setInt(4, quantity);
            statement.setInt(5, price);
            statement.setInt(6, id);
            statement.executeUpdate();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
