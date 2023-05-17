//
// This file must be implemented when completing "ChatRobot activity"
//

import utils_rmi.ChatConfiguration;
import faces.IChatMessage;
import faces.IChatServer;
import faces.IChatUser;
import faces.IChatChannel;
import faces.INameServer;
import faces.MessageListener;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;
import impl.*;


/**
 * ChatRobot implementation
 * 
 * <p> Notice ChatRobot implements MessageListener. MUST not extend ChatClient.
 * 
 */

public class ChatRobot implements MessageListener
{

    private ChatConfiguration conf;
    private IChatServer server = null;   // We just connect to one single server
    private ChatUserImpl user = null;

    public ChatRobot (ChatConfiguration conf) {
        this.conf = conf;
    }
    
   @Override
   public void messageArrived (IChatMessage msg) {
        try {
            // Get the message sender
            //
            IChatUser src = msg.getSender();
            
            // Get the message destination: it can be IChatUser or IChatChannel.
            //
            Remote dst = msg.getDestination();
            
            // Get the message contents.

            // if (isPrivate() is true) this is a user message: private message 
            // sent to me            
            //
            if (msg.isPrivate()) {
                doSendPrivateMessage(src.getNick(), "1+1 son 7");
                return;
            }
            else{
                doSendChannelMessage (conf.getServerName(), "Priimero que nada COMO ESTAN LOS MAQUINAS");
                return;
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
   }

   public void doSendChannelMessage (String dst, String msg) throws Exception
   {
       try {
           IChatChannel c_dst = server.getChannel (dst);
           IChatMessage c_msg = new ChatMessageImpl(user, c_dst, msg);
           
           // Send the message to the destination channel. 
           //
           c_dst.sendMessage(c_msg);
           
       } catch (RemoteException e) {
           throw new Exception ("Cannot send message", e);
       }
   }

   public void doSendPrivateMessage (String dst, String msg) throws Exception
   {
       try {
           // From server, get the user with the specified nick
           IChatUser u_dst = server.getUser (dst);
           
           // Create a ChatMessageImpl object.
           IChatMessage c_msg = new ChatMessageImpl(user, u_dst, msg);
           if (u_dst == null) throw new Exception ("User '" + dst + "' disconnected");
           
           // Send the message to the destination user  
           //	  
           u_dst.sendMessage(c_msg);
           
       } catch (Exception e) {
           throw new Exception ("Cannot send message", e);
       }
       
   }
   
   private void work () {
       
        String channelName = conf.getChannelName();
        if (channelName == null) channelName = "#Linux";
        System.out.println ("Robot will connect to server: '" + conf.getServerName() + "'" + 
                ", channel: '" + channelName + "'" + 
                ", nick: '" + conf.getNick() + "'" +        
                ", using name server: '" + conf.getNameServerHost() + ":" + conf.getNameServerPort() + "'");
        try {
            INameServer reg = INameServer.getNameServer(conf.getNameServerHost(), conf.getNameServerPort());
            server = (IChatServer) reg.lookup(conf.getServerName());       

            user = new ChatUserImpl("bot#" + this.hashCode(), this);
            server.connectUser(user);

            IChatChannel[] channels = server.listChannels();
            if (channels == null || channels.length == 0){
                throw new Exception("Server has no channels");
            }
            
            for (IChatChannel channel : channels) {
                channel.join(user);
            }
            System.out.println("Joined all channels. Ready!");
            }
        catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        }
   }

   public static void main (String args [])  {
       ChatRobot cr = new ChatRobot (ChatConfiguration.parse (args));
       cr.work ();
   }
}
