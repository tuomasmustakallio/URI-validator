/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uri.validator;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

/**
 *
 * @author Tuomas
 */
public class ValidateURI {
    private URI uri;
    private String scheme;
    private String path;
    private String param;
    private String source;
    private String payment_number;
    private UUID doc_uuid;
    private final String valid_scheme = "visma-identity";
    private final String[] valid_paths = {"login", "confirm", "sign"};
    private String[] param_list;
    
    
    public boolean validate(String input) {
        try{
            uri = new URI(input);
        }catch (URISyntaxException e) {
            System.out.println("The URI '" + input + "' is not valid.");
        }
        if(!uri.isAbsolute()){
            System.out.println("The URI '" + input + "' is not valid.");
            return false;
        }
        try{
            scheme = uri.getScheme();
        }catch(Exception e){
            System.out.print("Couldn't find a scheme\n" + e);
        }
        //Check that scheme=visma-identity
        if(!scheme.equals(valid_scheme)){
            System.out.println("'"+ scheme + "'-scheme is not valid.");
            return false;
        }
        try{
            path = uri.getAuthority();
        }catch(Exception e){
            System.out.print("Couldn't find a path\n" + e);
        }
        // Path=login
        if(path.equals(valid_paths[0])){
            try{
                param = uri.getQuery();
            }catch(Exception e){
                System.out.print("Couldn't find a parameters\n" + e);
            }
            
            param_list = param.split("=");
            if(param_list[0].equals("source")){
                source = param_list[1];
            }
            else{
                System.out.println("Invalid parameters.");
                return false;
            }
        }
        //Path=confirm
        else if(path.equals(valid_paths[1])){
            try{
                param = uri.getQuery();
            }catch(Exception e){
                System.out.print("Couldn't find a parameters\n" + e);
            }
            param_list = param.split("&");
            for(String i : param_list){
                String[] mem = i.split("=");
                if(mem[0].equals("source")){
                    source = mem[1];
                }
                else if(mem[0].equals("paymentnumber")){
                    payment_number = mem[1];
                }
                else{
                    System.out.println("Invalid parameters.");
                    return false;
                }
            }
        }
        //Path=sign
        else if(path.equals(valid_paths[2])){
            try{
                param = uri.getQuery();
            }catch(Exception e){
                System.out.print("Couldn't find a parameters\n" + e);
            }
            param_list = param.split("&");
            for(String i : param_list){
                String[] mem = i.split("=");
                if(mem[0].equals("source")){
                    source = mem[1];
                }
                else if(mem[0].equals("documentid")){
                    doc_uuid = UUID.fromString(mem[1]);
                }
                else{
                    System.out.println("Invalid parameters.");
                    return false;
                }
            }
        }
        //Path is not valid
        else{
            System.out.println("'"+ path + "'-path is not valid.");
            return false;
        }
        System.out.println("URI is valid!");
        return true;
        
    }
    
    public String getAction(){
        return path;
    }
    public String getPaymentNumber(){
        return payment_number;
    }
    public UUID getUUID(){
        return doc_uuid;
    }
}
