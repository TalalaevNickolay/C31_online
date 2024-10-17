package main.lesson19;

import main.lesson18.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Main extends Shape {
    public static void main(String[] args) throws IOException {
        //------------------------Java 8------------------------
        NewMethods<String> newMethods = x -> x.startsWith("Hello");

        newMethods.print();
        System.out.println(NewMethods.getString());

        Supplier<User> supplier = User::new;

        System.out.println(String.join(", ", "a", "b", "c", "d"));

        doPeriodicCleanup();

        //------------------------Java 9------------------------
        List<String> list = List.of("one", "two", "three");
        Set<String> set = Set.of("one", "two", "three");
        Map<String, String> map = Map.of("foo", "one", "bar", "two");

        List<String> strings = Stream.iterate("", s -> s + "0")
                .takeWhile(s -> s.length() < 10).toList();
        System.out.println(strings);

        Optional<User> user = Optional.ofNullable(null);
        user.ifPresentOrElse(User::getFirstName, () -> System.out.println("Empty user"));

        //было
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/romeo_and_juliett.txt"))) {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // стало
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/romeo_and_juliett.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/write.txt"));
        try (reader; writer) {
            while (null != (line = reader.readLine())) {
                writer.write(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //--------------------Java 10------------------------
        // Pre-Java 10
        String myName = "Marco";
        // With Java 10
        var myNameAlso = "Marco";
        var mapOfLists = Map.of("1", Arrays.asList("one", "1", "I"), "2", Arrays.asList("two", "2", "II"));

        //--------------------Java 11------------------------
        System.out.println("\n");
        System.out.println("Blank string - " + " ".isBlank());
        System.out.println("Lines of string - " + "Mar\nco\nPolo".lines().toList());
        System.out.println("Strip string - " + "     Marco".strip());

        Path path = Files.writeString(Files.createTempFile("helloworld", ".txt"), "Hi, my name is!");
        String s = Files.readString(path);
        System.out.println("Reading from file - " + s);

        list.stream().map(String::toLowerCase).collect(Collectors.toList());
        list.stream().map((var str) -> str.toLowerCase()).collect(Collectors.toUnmodifiableList());

        //--------------------Java 12------------------------
        //было
        Day day = Day.FRIDAY;
        switch (day) {
            case SATURDAY:
            case SUNDAY: {
                System.out.println("Enjoy the weekend!");
                break;
            }
            case FRIDAY:
            case MONDAY:
            case TUESDAY:
            case THURSDAY: {
                System.out.println("A weekday!");
                break;
            }
            case WEDNESDAY: {
                System.out.println("It's Wednesday my dudes!");
                break;
            }
        }
        //стало
        switch (day) {
            case FRIDAY, MONDAY, TUESDAY, THURSDAY -> System.out.println("A weekday!");
            case SATURDAY, SUNDAY -> System.out.println("Enjoy the weekend!");
            case WEDNESDAY -> System.out.println("It's Wednesday my dudes!");
        }

        //--------------------Java 13------------------------

        boolean isItOkayToDrinkBeer = switch (day) {
            case SATURDAY, SUNDAY -> true;
            case FRIDAY, MONDAY, TUESDAY,WEDNESDAY, THURSDAY -> false;
            default -> {
                String dayString = day.toString();
                int result = dayString.length();
                yield result > 5;
            }
        };

        String htmlBeforeJava13 = "<html>\n" +
                "    <body>\n" +
                "        <p>Hello, world</p>\n" +
                "    </body>\n" +
                "</html>\n";

        String htmlWithJava13 = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;

        //--------------------Java 14------------------------
        Triangle triangle = new Triangle(3,4,5);
        System.out.println(" \nTriangle:" + triangle.a());
        System.out.println(triangle);

        //было
        Object object = new Violin();
        if(object instanceof Violin){
            System.out.println(((Violin) object).getMaster());
        }

        //стало
        if(object instanceof Violin instrument) {
            System.out.println(instrument.getMaster());
        }

        //--------------------Java17------------------------

    }

    @Schedule(dayOfMonth = "last")
    @Schedule(dayOfWeek = "Fri", hour = 23)
    public static void doPeriodicCleanup() {
        System.out.println("cleaning up something");
    }

    public static String test(Object obj) {

        return switch(obj) {

            case Integer i -> "An integer";

            case String s -> "A string";

            case Violin c -> "A Violin";

            default -> "I don't know what it is";
        };
    }
}
