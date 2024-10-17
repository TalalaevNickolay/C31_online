package main.lesson19;

@FunctionalInterface
public interface NewMethods<T> {

    boolean chech(T arg);

    default void print() {
        System.out.println("Hello, i'm default method!");
        privateMethod();
    }

    static String getString() {
        privateStaticMethod();
        return "Hello, i'm static method!";
    }

    private void privateMethod(){
        System.out.println("I'm private method!");
    }

    private static void privateStaticMethod(){
        System.out.println("I'm private static method!");
    }
}
