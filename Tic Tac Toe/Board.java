// package hi;

import java.rmi.*;
import java.rmi.server.*;

import javax.lang.model.util.ElementScanner6;

import java.rmi.*;
import java.util.*;
import java.util.concurrent.*;

public class Board extends UnicastRemoteObject implements RMI_interfac
{
    private char board[][]={
                                {'1','2','3'},
                                {'4','5','6'},
                                {'7','8','9'}
                           };
    private int MovNum;
    private int CurrPlayer;
    private int num_players;
    private int chooser;
    public Board() throws RemoteException
    {
        super();
        this.MovNum = 0;
        this.CurrPlayer = 1; 
        this.num_players = 0;
        this.chooser = -1;
    }
    
    @Override
    public String getBoard() throws RemoteException
    {
		StringBuilder ConstBoard = new StringBuilder();
		ConstBoard.append("\n---+---+---\n ");
		synchronized (this) {
			ConstBoard.append(board[0][0]).append(" | ").append(board[0][1]).append(" | ").append(board[0][2]).append("\n---+---+---\n ");
			ConstBoard.append(board[1][0]).append(" | ").append(board[1][1]).append(" | ").append(board[1][2]).append("\n---+---+---\n ");
            ConstBoard.append(board[2][0]).append(" | ").append(board[2][1]).append(" | ").append(board[2][2]).append("\n---+---+---\n ");
		}
        return ConstBoard.toString();
    }
    
    @Override
    public Boolean Move(String Player, int num, char fill)
    {   
        System.out.println(CurrPlayer);
        if(this.board[(num-1)/3][(num-1)%3] == 'x' || this.board[(num-1)/3][(num-1)%3] == 'o' )
            return false;
        else{
            this.board[(num-1)/3][(num-1)%3] = fill;
            this.CurrPlayer = (this.CurrPlayer+1);
            if(this.CurrPlayer == 3)
                this.CurrPlayer = 1;
            // System.out.println(this.CurrPlayer);
            return true;
        }

    }
    @Override
    public int setPlayerName() throws RemoteException {

        if(this.chooser == -1){
            System.out.println(this.chooser);
            if( this.chooser == -1){
                this.chooser = new Random().nextInt(2)+1;
                return this.chooser;
            }
        }
        else{
            System.out.println(this.chooser);

            int resul = (this.chooser+1);
            if(resul == 3)
                this.chooser = 1; 

            return this.chooser;
        }
        return this.chooser;
    }

    public int players() throws RemoteException{
        return this.num_players;
    }
    public String new_player() throws RemoteException{
        if(this.num_players<2){
            this.num_players++;
            return "success";
        }
        else
            return "wait";
    }
    public void current_player(int p) throws RemoteException{
        while(p != this.CurrPlayer){
            // this.CurrPlayer = this.CurrPlayer -1 + 1;
            // System.out.println(this.);
            try{
                TimeUnit.SECONDS.sleep(1);
                System.out.println(this.CurrPlayer);
            }
            catch(InterruptedException ie){

            }
        }
    }
    public Boolean score(char c) throws RemoteException{
        int fl = 0;
        for (int i =0; i< 3;i++){
            if(board[i][0] == c && board[i][1] == c && board[i][2]==c)
                fl = 1;
            else if(board[0][i] == c && board[1][i] == c && board[2][i]==c)
                fl = 1;
        }
        if((board[0][0] == c && board[1][1] == c && board[2][2]==c) ||(board[2][0] == c && board[1][1] == c && board[0][2]==c))
            fl = 1;
        
        if(fl == 1)
            return true;
        else
            return false; 
    }   

}
