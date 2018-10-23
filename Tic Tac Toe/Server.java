// package kakka;

import java.rmi.*;
import java.rmi.registry.*;
import java.io.*;

public class Server {

    private static final String host = "localhost:2020";
    private static BufferedReader inputLine = null;


    public static void start(String rmiObjName){
        try
        { 
            // System.out.println(rmiObjName);
            while(true){
                
                String sendMessage = inputLine.readLine();
  
            }
        }
        catch (RemoteException conEx)
        {
            System.out.println("Unable to connect to server!");
            System.exit(1);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) throws Exception {    
        try
        {
            inputLine = new BufferedReader(new InputStreamReader(System.in));

            LocateRegistry.createRegistry(2020);
            String rmiObjName = "rmi://" + host + "/Start";
            Board temp = new Board();       
            Naming.rebind(rmiObjName, temp);      
            System.out.println("Binding complete...\n");
            start(rmiObjName);
        }
        catch (ConnectException conEx)
        {
            System.out.println("Unable to connect to server!");
            System.exit(1);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.exit(1);
        }
    }

}