package main.lesson18;

import java.util.Arrays;
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
//        tmsName = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);

        Integer year = 2023;
        Optional<Integer> yearOptional = Optional.of(year);
        Integer getResult = yearOptional.get();
        boolean is2016 = yearOptional.filter(y -> y == 2023).isPresent();
        System.out.println("Year = " + getResult + "; is it 2016? - " + is2016);

        List<String> companyNames = Arrays.asList("TMS", "Oracle", "Microsoft");
        Optional<List<String>> listOptional = Optional.of(companyNames);
        int size = listOptional.map(list -> list.size()).orElse(0);
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
                .map(Computer::getSoundcard)
                .map(Soundcard::getUsb)
                .map(USB::getVersion)
                .orElse("UNKNOWN");
        System.out.println(version3);
    }
}
