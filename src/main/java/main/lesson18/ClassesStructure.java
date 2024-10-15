package main.lesson18;

public class ClassesStructure {

    static class Computer {

        private Soundcard soundcard;

        public Soundcard getSoundcard() {
            return this.soundcard;
        }
    }

    static class Soundcard {

        private USB usb;

        public USB getUsb() {
            return this.usb;
        }
    }

    static class USB {

        private String version;

        public String getVersion() {
            return this.version;
        }
    }
}
