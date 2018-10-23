import java.rmi.*;
import java.rmi.server.*;
import java.rmi.*;

public interface RMI_interfac extends Remote
{
    public String getBoard() throws RemoteException;
    public Boolean Move(String player, int num, char fill) throws RemoteException;
    public int setPlayerName() throws RemoteException;
    public int players() throws RemoteException;
    public String new_player() throws RemoteException;
    public void current_player(int p) throws RemoteException;
    public Boolean score(char c) throws RemoteException;
    // public int GameOver() throws RemoteException;
    
}