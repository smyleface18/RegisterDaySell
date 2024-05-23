

package com.mycompany.registerdaysell.SaveRegister;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class SaveRegister {

    File file;
    FileReader fileReader;
    BufferedReader buffereadReader;

    public SaveRegister(File file) throws FileNotFoundException {
        this.file = file;
        try{
                this.fileReader = new FileReader(file);
                this.buffereadReader = new BufferedReader(fileReader);
        }
        catch(FileNotFoundException e){
            System.out.println("el archivo no existe");
        }
    }
    
    
    public void save(ArrayList<String[]> arrayList) throws IOException{
        
        try{
           FileWriter write = new FileWriter(file);  
           PrintWriter pw = new PrintWriter(write);
                pw.println("PRODUCTO   CANTIDAD   PRECIO UNIDAD");
                int accumulator=0;
                for (int i = 0; i < arrayList.size(); i++) {
                    String list [] = arrayList.get(i);
                     pw.println(list[0]+"      "+list[1]+"      "+list[2]);
                     accumulator += Integer.parseInt(list[2])*Integer.parseInt(list[1]);

                }
                pw.println("La venta total es: "+accumulator);

                pw.close();
            }
        catch(IOException e){
            System.out.println("noo se pudo escribir el archivo");
        }
       

           
    }

}
    
   
    

