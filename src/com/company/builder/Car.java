package com.company.builder;

public class Car {
    private String tire;
    private String handle;
    private String tmp;

    public Car() {

    }

    public Car(String tire, String handle) {
        this.tire = tire;
        this.handle = handle;
    }

    public Car(String tire, String handle, String tmp) {
        this.tire = tire;
        this.handle = handle;
        this.tmp = tmp;
    }

    public String getTire() {
        return tire;
    }

    public void setTire(String tire) {
        this.tire = tire;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }
}
