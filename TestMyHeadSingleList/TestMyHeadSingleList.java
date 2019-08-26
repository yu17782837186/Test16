package cn.dataStructure2.com;

public class TestMyHeadSingleList {
    public static void main(String[] args) {
        MyHeadSingleList list = new MyHeadSingleList();
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addFirst("4");
        list.addFirst("5");
        list.addLast("6");
        list.addLast("7");
        list.addLast("8");
        list.addFirst("9");

        list.display();
        System.out.println(list.getLength());
        list.addIndex(9,"小红");
        System.out.println(list.getLength());
        list.display();
        System.out.println("-------");
        System.out.println(list.contains("44"));
        list.remove("小红");
        System.out.println(list.getLength());
        list.display();
        list.addFirst("9");
        list.addFirst("9");
        list.addFirst("9");
        list.addLast("9");
        list.addLast("9");
        list.addIndex(7,"9");
        list.display();
        System.out.println("--------");
        list.removeAllKey("9");
        list.display();
        System.out.println(list.getLength());
        list.clear();
        list.display();
        list.addLast("1");
        list.display();
    }
}
