package dao;

import entity.PersonalData;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.List;

public class UserDao {
    Transaction transaction = null;

    public List<PersonalData> getAllUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<PersonalData> list = session.createQuery("from PersonalData", PersonalData.class).list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } return null;
    }

    public boolean isUser(String login, String pass) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<PersonalData> list = getAllUsers();
            for (PersonalData personalData : list){
                String log = personalData.getLogin();
                String pas = personalData.getPass();
                if (log.equals(login) && pas.equals(pass)){
                    return true;
                }
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } return false;
    }

    public List<PersonalData> getCurrentUser(String login, String pass) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<PersonalData> list = session.createQuery("from PersonalData p where p.login = :login and p.pass = :pass")
                    .setParameter("login", login)
                    .setParameter("pass", pass).list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } return null;

    }

    public void deleteUser(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            PersonalData personalData = session.get(PersonalData.class, id);
            session.delete(personalData);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public void addUser(String login, String pass, String name, String surname) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(new PersonalData(login,pass,name,surname));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAdditionalFields(int id, String address, String email, String phone) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            PersonalData personalData = session.get(PersonalData.class, id);
            personalData.setAddress(address);
            personalData.setEmail(email);
            personalData.setPhone(phone);
            session.update(personalData);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
