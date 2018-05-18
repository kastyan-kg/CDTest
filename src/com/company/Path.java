package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kos on 08-May-18.
 */
public class Path {
    private ArrayList <Directory> pathDirs;

    public Path(ArrayList<Directory> pathDirs) {
        this.pathDirs = pathDirs;
    }

    public ArrayList<Directory> getPathDirs() {
        return pathDirs;
    }

    public void setPathDirs(ArrayList<Directory> pathDirs) {
        this.pathDirs = pathDirs;
    }

    public void  cd(String changePath){
        ArrayList<Directory> changePathDir = this.convertToDirectory(changePath) ;

        Utility util = new Utility();
        try {
            util.checkInput(changePathDir);


            ArrayList<Directory> currentPath = this.pathDirs;
            if (changePathDir.isEmpty()) {
                currentPath.clear();
                currentPath.add(new Directory(""));
            } else {

                for (int i = 0; i < changePathDir.size(); i++) {

                    if (changePathDir.get(i).getDirectoryName().equals("..")) {

                        currentPath.remove(currentPath.size() - 1);

                    } else if (changePathDir.get(i).getDirectoryName().equals(".")) {
                        changePathDir.remove(i);
                        currentPath.get(currentPath.size() - 1).setDirectoryName(changePathDir.get(i).getDirectoryName());

                    } else {
                        currentPath.add(changePathDir.get(i));
                    }

                }
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());

        }


    }
    public ArrayList <Directory> convertToDirectory(String strPath){
        ArrayList<Directory> result = new ArrayList<Directory>();

        String[] parts = strPath.split("/");
        List<String> strRes = new ArrayList<String>(Arrays.asList(parts));
        for (String s : strRes) {
            result.add(new Directory(s));
        }

        return result;
    }
    public void printCurrentDir(){
        System.out.println();
        for (Directory pathDir : this.pathDirs) {
            System.out.print("/" + pathDir.getDirectoryName());
        }
        System.out.println();

    }
}
