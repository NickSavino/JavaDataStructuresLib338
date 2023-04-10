package mylib;

import mylib.datastructures.linear.DLL;
import mylib.datastructures.linear.SLL;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        DLL<Integer> list = new DLL<Integer>();
        list.insertHead(10);
        list.insertHead(30);
        list.insertHead(20);


        list.print();

    }

}
