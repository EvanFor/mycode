package com.ruoran.zero;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FinalOrNot {

    private static final String str = "abc";
    private final String str2 = "efg";

    public void test1() throws Exception {
        System.out.println(str); // abc
        System.out.println(str2); // efg

        Field field = FinalOrNot.class.getDeclaredField("str");
        field.setAccessible(true);

        field.set(this, "cba"); // java.lang.IllegalAccessException: Can not set static final
        System.out.println(str);
    }

    public void test2() throws Exception {
        System.out.println(str); // abc
        System.out.println(str2); // efg

        Field field = FinalOrNot.class.getDeclaredField("str2");
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(this, "gfe");

        System.out.println(str2); // efg
    }

    public static void main(String[] args) throws Exception {
        FinalOrNot demo = new FinalOrNot();
        // demo.test1();
        demo.test2();
    }
}
