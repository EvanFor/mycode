package com.ruoran.zero;

interface DemoX {
    default void doSth() {
        System.out.println("111");
    }
}

interface DemoY {
    default void doSth() {
        System.out.println("222");
    }
}

interface DemoZ extends DemoY {
    default void doSth() {
        System.out.println("333");
    }
}

public class InterfaceNew implements DemoX, DemoY {

    @Override
    public void doSth() {
        System.out.println("444");
    }

    public static void main(String[] args) {
        InterfaceNew demo = new InterfaceNew();
        demo.doSth();
    }
}
