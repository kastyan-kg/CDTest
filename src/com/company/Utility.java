package com.company;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kos on 08-May-18.
 */
public class Utility {

    public void checkInput(ArrayList<Directory> dirs) throws IOException{

        for (Directory dir : dirs) {

            if(!dir.getDirectoryName().matches("\\.{1,2}||[A-z]{1,10}")){
                throw new IOException("Directory names consist only of English aiphabet letters (A-Z and a-z)");
            }
        }

    }

}
