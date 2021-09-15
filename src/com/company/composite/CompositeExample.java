package com.company.composite;

import java.util.ArrayList;
import java.util.List;


interface Component {
    void print();
}

class Folder implements Component {
    private String name;
    private List<Component> mChildComponents = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("=== " + name + " folder ===");
        for (Component component : mChildComponents) {
            component.print();
        }
    }

    public void add(Component component) {
        mChildComponents.add(component);
    }

    public void remove(Component component) {
        mChildComponents.remove(component);
    }
}

class File implements Component {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("ㄴ" + name);
    }
}

public class CompositeExample {
    public static void main(String[] args) {
        File file1 = new File("test1.txt");
        File file2 = new File("test2.txt");
        File file3 = new File("test3.txt");
        File file4 = new File("buzz.mp3");

        Folder home = new Folder("home");
        Folder doc = new Folder("doc");
        Folder music = new Folder("music");

        // doc folder
        doc.add(file1);
        doc.add(file2);
        doc.add(file3);

        // music folder
        music.add(file4);

        // home folder
        home.add(doc);
        home.add(music);

        home.print();
    }
}