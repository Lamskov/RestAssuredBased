package org.example;

public class Example {

        public static void main(String[] args) {
            MyObject obj = new MyObject();
            obj.value = 10;
            System.out.println(obj.value);// value = 10 heap
            modifyObject(obj);              //
            System.out.println(obj.value);


            int num = 0;

            for (int i = 0; i <100; i++) {
                num = num++;
            }
            System.out.println(num);


        }

        public static void modifyObject(MyObject obj) {
            obj.value = 20;                             // value = 20
        }
    }

    class MyObject {
        int value;
    }

