package main.lesson18;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static main.lesson18.ClassesStructure.*;

public class OptionalEx {
    public static void main(String[] args) {
        String name = "Alex";
        Optional<String> empty = Optional.empty();
        Optional<String> optionalOf = Optional.of(name);
        Optional<String> ofNullable = Optional.ofNullable(name);

        if (ofNullable.isPresent()) {
            System.out.println(ofNullable);
        }
        if (!ofNullable.isEmpty()) {
            System.out.println(ofNullable);
        }

        ofNullable.ifPresent(opt -> System.out.println(opt.length()));
        String nullName = null;
        String tmsName = Optional.ofNullable(nullName).orElse("TMS");
        tmsName = Optional.ofNullable(nullName).orElseGet(() -> "TMS");
//        tmsName = Optional.ofNullable(nullName).orElseThrow(() -> new IllegalArgumentException("Name is null"));

        Integer year = 2023;
        Optional<Integer> yearOptional = Optional.ofNullable(year);
        Integer getResult = yearOptional.get();
        boolean is2016 = yearOptional.filter(y -> y == 2021).isPresent();
        System.out.println("Year = " + getResult + "; is it 2023? - " + is2016);

        List<String> companyNames = null;
        Optional<List<String>> listOptional = Optional.ofNullable(companyNames);
        int size = listOptional.map(list -> list.size()).get();
        System.out.println("Company names list size = " + size);

        // EXAMPLES Optional

        Computer computer = new Computer();

        // possible NullPointerException
        String version = computer.getSoundcard().getUsb().getVersion();

        // null-safe
        String version2 = "UNKNOWN";
        if (computer != null) {
            Soundcard soundcard = computer.getSoundcard();
            if (soundcard != null) {
                USB usb = soundcard.getUsb();
                if (usb != null && usb.getVersion() != null) {
                    version2 = usb.getVersion();
                }
            }
        }
        System.out.println(version2);

        //Optional
        String version3 = Optional.ofNullable(computer)
                .map(computer1 -> computer1.getSoundcard())
                .map(soundCard -> soundCard.getUsb())
                .map(usb -> usb.getVersion())
                .orElse("UNKNOWN");
        System.out.println(version3);
    }
}
