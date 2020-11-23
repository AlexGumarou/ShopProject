package Goods;
//класс-хранилище для товаров и доступ к ним
import java.util.ArrayList;
import java.util.List;

public class GoodsStorage {
    private static List<Goods> listOfGoods;
    private GoodsStorage() {
    }
    public static List<Goods> getListOfGoods(){
        if (listOfGoods == null){
            listOfGoods = new ArrayList<>();
        }
        return listOfGoods;
    }

    static public void addGoods(){
        listOfGoods.add(new Goods(listOfGoods.size()+1,"Fish", "This is very tasty fish",
                5, 100, 0));
        listOfGoods.add(new Goods(listOfGoods.size()+1,"Milk", "This is very tasty milk",
                10, 15,0));
        listOfGoods.add(new Goods(listOfGoods.size()+1,"Meat", "This is very tasty meat",
                1, 80,0));
        listOfGoods.add(new Goods(listOfGoods.size()+1,"Bread", "This is very tasty bread",
                100, 12,0));
        listOfGoods.add(new Goods(listOfGoods.size()+1,"Sugar", "This is very tasty sugar",
                10, 6,0));
    }
    static public void addNewGoods(int id, String name, String description, int quantity, int price,
                                   int idPreOrder){
        listOfGoods.add(new Goods(id, name,description,quantity,price,0 ));
    }
    static public void editNewGoods(int id, String name, String description, int quantity, int price, int idPreOrder){
        listOfGoods.set(id-1, new Goods(id, name,description,quantity,price, 0));

    }
}
