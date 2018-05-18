package com.company;

import java.util.ArrayList;


public class App {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Directory> dirs = new ArrayList<Directory>();

        dirs.add(new Directory("a"));
        dirs.add(new Directory("b"));
        dirs.add(new Directory("c"));
        Path test = new Path(dirs);


        test.printCurrentDir();
        test.cd("../sdsd");
        test.printCurrentDir();
        test.cd("../../sdsd");
        test.printCurrentDir();
        test.cd("./x");
        test.printCurrentDir();
        test.cd("/");
        test.printCurrentDir();
        test.cd("./a/b/c");
        test.printCurrentDir();
        test.cd("fdf");
        test.printCurrentDir();
        test.cd("89");
        test.printCurrentDir();



    }
}
