//
// This file must be implemented when completing "ChatRobot activity"
//

import utils_rmi.ChatConfiguration;
import faces.IChatMessage;
import faces.IChatServer;
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
       //*****************************************************************
       // Activity: implement robot message processing
       
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

            user = new ChatUserImpl("Robotito", this);
            server.connectUser(user);

            IChatChannel[] channels = server.listChannels();
            if (channels == null || channels.length == 0){
                throw new Exception("Server has no channels");
            }

            for (IChatChannel channel : channels) {
                if(channel.getName().equals(channelName)){
                    channel.join(user);
                    ChatMessageImpl message = new ChatMessageImpl(user, channel, "hola a todos");
                    channel.sendMessage(message);
                    break;
                }
            }
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
