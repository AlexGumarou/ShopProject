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
                5, 100));
        listOfGoods.add(new Goods(listOfGoods.size()+1,"Milk", "This is very tasty milk",
                10, 15));
        listOfGoods.add(new Goods(listOfGoods.size()+1,"Meat", "This is very tasty meat",
                1, 80));
        listOfGoods.add(new Goods(listOfGoods.size()+1,"Bread", "This is very tasty bread",
                100, 12));
        listOfGoods.add(new Goods(listOfGoods.size()+1,"Sugar", "This is very tasty sugar",
                10, 6));
    }
}
