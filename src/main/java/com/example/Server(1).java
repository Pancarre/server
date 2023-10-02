
package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

    ServerSocket Server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringaModificata = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;

    

    public Socket attendi(){

        try{

            System.out.println("server in esecuzione");
            Server = new ServerSocket(3344);
            client = Server.accept();
            Server.close();
            inDalClient = new BufferedReader (new InputStreamReader (client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());




        }
        catch(Exception e){

            System.out.println(e.getMessage());
            System.out.println(e.getMessage());
            System.exit(1);


        }

        return client;

    }


    public void comunica(){
        try{

            System.out.println("scrivi");
            stringaRicevuta = inDalClient.readLine();
            System.out.println("ricevuta" + stringaRicevuta);

            stringaModificata = stringaRicevuta.toUpperCase();
            System.out.println("string modificata");
            outVersoClient.writeBytes(stringaModificata + "\n");
            System.out.println("fine");

            client.close();




        }
        

        catch(Exception e){

            System.out.println(e.getMessage());
            System.out.println(e.getMessage());
            System.exit(1);



        }





    }








}

