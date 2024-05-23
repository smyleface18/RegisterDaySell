

package com.mycompany.registerdaysell;

import com.mycompany.registerdaysell.SaveRegister.SaveRegister;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author caleb
 */
public class RegisterDaySell {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
        Scanner read = new Scanner(System.in);
        ArrayList<String[]> ListSells = new ArrayList<>();
        
        
        File file = new File("./archivo.txt");
        SaveRegister saveRegister = new SaveRegister(file);
        boolean value = true;
        while(value){
         

            String list [] = new String[3];
            System.out.println("enter the name of product");
            list[0] = read.nextLine();
            System.out.println("number of units sold");
            list[1] = read.nextLine();
            System.out.println("enter the price per unit ");
            list[2] = read.nextLine();

            
            ListSells.add(list);
            
            System.out.println("Quires salirte?");
            System.out.println("1 si");
            System.out.println("2 No");
            System.out.println("3 ver el contenido del registro que se lleva");
            int in  = read.nextInt();
            if(in == 1){
                value = false;
            }
            else if(in == 3){
                ArrayList <String> dataFile = new ArrayList<> ();

                dataFile = saveRegister.data();

                for (String string : dataFile) {
                    System.out.println(string);
                }           
            }
            read.nextLine();
            
        }
        System.out.println(ListSells.size());
        
        try{
            saveRegister.save(ListSells);
        }
        catch(IOException e){
            System.out.println("no se puedo guardar el registro");
        }
        

        
    }
}
