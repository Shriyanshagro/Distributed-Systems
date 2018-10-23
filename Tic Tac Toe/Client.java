
import java.rmi.*;
import java.io.*;
import java.rmi.registry.*;
import java.util.concurrent.*;

public class Client 
{
    private static final String host = "localhost:2020";
    private static BufferedReader inputLine = null;
    private static String name = "Player";

    public static void main(String[] args)
    {
        try
        {
            System.out.println("Type 'start' to begin playing");
            System.out.println("Type 'leave' to leave client");
            inputLine = new BufferedReader(new InputStreamReader(System.in));
            String rmiObjName = "rmi://"+ host + "/Start";
            // board
            RMI_interfac board = (RMI_interfac) Naming.lookup(rmiObjName);
            while(true){
                
                if(name.equals("Player1")){
                    board.current_player(1);
                    String temp = "";
                    int f = 0;
                        
                    if(board.score('x')){
                        temp = "Player1 wins!";
                        f = 1;
                    }

                    else if(board.score('o'))
                    {
                        temp = "Player2 wins!";
                        f = 1;
                    }
                    if(f == 1)
                        {   
                            System.out.println(temp);
                            //restart game
                            break;
                        }
                    System.out.println("-----------Board-----------");
                    System.out.println(board.getBoard());
                    System.out.println("Your move:   ");
                }
                else if(name.equals("Player2")){
                    board.current_player(2);
                    Boolean won = board.score('o');
                    String temp = "";
                    int f = 0;
                        
                    if(board.score('x')){
                        temp = "Player1 wins!";
                        f = 1;
                    }

                    else if(board.score('o'))
                    {
                        temp = "Player2 wins!";
                        f = 1;
                    }
                    if(f == 1)
                        {
                            System.out.println(temp);
                            //restart game
                            break;
                        }
                    System.out.println("-----------Board-----------");
                    System.out.println(board.getBoard());
                    System.out.println("Your move:   ");
                }
                
                String sendMessage = inputLine.readLine();
                if(sendMessage.toLowerCase().equals("start"))
                {
                    // Registry registry = LocateRegistry.getRegistry(host);
                    Boolean fl = true;
                    

                    while(fl){
                        String sccMssg = board.new_player();
                        if(sccMssg.equals("success"))
                            break;
                    }
                    System.out.println("Waiting!");
                    while(true){    
                        if (board.players() == 2 ){
                            System.out.println("Opponent Found");
                            // TimeUnit.SECONDS.sleep(1);
                            
                            name = "Player"+ Integer.toString(board.setPlayerName());
                            break;
                        }

                    }
                    
                    System.out.println("Player: " + name);
                    
                }
                else if (sendMessage.toLowerCase().equals("leave")){
                    break;
                }
                else{
                    try{
                        int mv_index = Integer.parseInt(sendMessage);
                        if(mv_index>9)
                            System.out.println("Not a valid move!");
                        else{
                            char c = 'x';
                            if(name.equals("Player2"))
                                c = 'o';
                            // System.out.println(name + " "+ mv_index+" "+ c);
                            board.Move(name, mv_index, c);
                            if(board.score(c)){
                                System.out.println("You WON!");
                                break;
                                //restart game
                            }
                            
                        }
                    }
                    catch(NumberFormatException ex){
                        System.out.println("Not a number!");

                    }
                }
            }
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

