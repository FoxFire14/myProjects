package org.academiadecodigo.bootcamp.containers;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> stringList = new LinkedList<>();

        stringList.add("lindo");
        stringList.add("Naice");
        stringList.add("dsfgdg");
        stringList.add("dfsgjyi");

        for (String i : stringList){
            System.out.println(i);

        }


        LinkedList<Integer> listInt = new LinkedList<>();
        listInt.add(14);
        listInt.add(14);

        for (Integer i : listInt){
            System.out.println(i);
        }
        LinkedList list = new LinkedList<>();
        list.add("catorze");
        list.add(14);

        for (Object i : list){
            System.out.println(i);
        }












    }
}
