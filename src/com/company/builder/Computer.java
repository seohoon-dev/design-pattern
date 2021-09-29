package com.company.builder;

public class Computer {
    // required
    private String cpu;
    private String ssd;
    private String ram;

    // optional
    private String odd;

    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ssd = builder.ssd;
        this.ram = builder.ram;
        this.odd = builder.odd;
    }

    public static ComputerBuilder builder() {
        return new ComputerBuilder();
    }

    public String getCpu() {
        return cpu;
    }

    public String getSsd() {
        return ssd;
    }

    public String getRam() {
        return ram;
    }

    public String getOdd() {
        return odd;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ssd='" + ssd + '\'' +
                ", ram='" + ram + '\'' +
                ", odd='" + odd + '\'' +
                '}';
    }

    public static class ComputerBuilder {
        // required
        private String cpu;
        private String ssd;
        private String ram;

        // optional
        private String odd;

        public ComputerBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public ComputerBuilder setSsd(String ssd) {
            this.ssd = ssd;
            return this;
        }

        public ComputerBuilder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setOdd(String odd) {
            this.odd = odd;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}