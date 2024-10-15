package main;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.function.Predicate;

public class lesson17 {
    public static void main(String[] args) {
        dateTimeMethodsDemonstration();
        lambdaDemonstration();
    }

    private static void dateTimeMethodsDemonstration() {
        System.out.println(ZoneId.systemDefault());
        System.out.println(ZoneId.getAvailableZoneIds());
        LocalDate now = LocalDate.now();

        //parse a string
        LocalTime time1 = LocalTime.parse("20:15:30");
        LocalTime.of(20, 15, 30);
        LocalDate localDate = LocalDate.parse("2015-02-20");
        LocalDate.of(2015, 2, 20);
        System.out.println("time1: " + time1 + " date1: " + localDate);

        LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        LocalDate tomorrow = LocalDate.now().plusDays(1);

        //12 december 2014
        LocalDate date4 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date4: " + date4);

        DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();
        int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();

        boolean notBefore = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"));
        System.out.println("12 before 11: " + notBefore);
        boolean isAfter = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"));
        System.out.println("12 after 11: " + isAfter);

        //22 hour 15 minutes
        LocalTime localTime = LocalTime.of(22, 15);
        System.out.println("localTime: " + localTime);

        LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
        System.out.println("sevenThirty: " + sevenThirty);


        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime.parse("2015-02-20T06:30:00");
        System.out.println("Current DateTime: " + currentTime);

        LocalDate date2 = currentTime.toLocalDate();
        System.out.println("date2: " + date2);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("Month: " + month +"day: " + day +"seconds: " + seconds);

        LocalDateTime date3 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date3: " + date3);

        System.out.println("Current DateTime Formatted: " + currentTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
    }

    private static void lambdaDemonstration() {
        Predicate<Integer> isEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x % 2 == 0;
            }
        };
        Predicate<Integer> isEvenLambda = x -> x % 2 == 0;
        System.out.println(isEven.test(4));
        System.out.println(isEvenLambda.test(7));
    }
}
