import java.lang.System;
import java.util.ArrayList;
import java.util.List;


public class RobotPrinter {
    // Hint 1:
    // List adalah interface Java yang merupakan subinterface dari interface Collection
    // Deklarasi tipe generic `List` di Java yang sudah tersedia adalah:
    // `public interface List<E> extends Collection<E>`
    // 
    // Seperti dapat dilihat, List bisa menggunakan variabel tipe (T) generic saat digunakan. Contoh penggunaannya:
    // List<Integer> integerList = ...;   

    // Hint 2:
    // Iterasi melalui seluruh elemen list dapat digunakan dengan loop for-each, yang di Java bisa dilakukan dengan sintaks:
    // for (E element : elementList){
        //operasi pada element
    // }

    public static void printListOfRobot(List<? extends Robot> listRobot) {
        for (Robot robot : listRobot) {
            System.out.println(robot.getName());
        }
    }

    public static void printListOfTransformer(List<? extends Transformer> listTransformer) {
        for (Transformer transformer : listTransformer) {
            System.out.println(transformer.getWeapons());
        }
    }

    public static void printClassNameOfList(List<? extends Object> listObject) {
        for (Object obj : listObject) {
            System.out.println(obj.getClass().getName());
        }
    }

    public static void printObjectClassName(Object object) {
        System.out.println(object.getClass().getName());
    }
}

class Robot {
    private String name;
  
    public Robot(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

class Transformer extends Robot{
    private int weapons;
    public Transformer(String name, int weapons){
        super(name);
        this.weapons = weapons;
    }

    public int getWeapons(){
        return this.weapons;
    }
}

class Bumblebee extends Transformer{
    public Bumblebee(String name, int weapons){
        super(name,weapons);
    }
}

class Baymax extends Robot{
    public Baymax(String name){
        super(name);
    }
}