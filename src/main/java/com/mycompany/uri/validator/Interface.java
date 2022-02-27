/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uri.validator;

import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author Tuomas
 */
public class Interface {
    
    public static void main(String[] args) {
        String path;
        boolean valid = false;
        ValidateURI validator = new ValidateURI();
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Enter a URI(0 ends):");
            String input = scan.nextLine();
            if(input.equals("0")){
                break;
            }
            valid = validator.validate(input);
            if(valid){
                path = validator.getAction();
                System.out.println("Action was: " + path);
                if(path.equals("confirm")){
                    System.out.println("Payment number was: " + validator.getPaymentNumber());
                }
                if(path.equals("sign")){
                     System.out.println("Documentid was: " + validator.getUUID());
                }
            }
        }
     
    }
}
