package com.voidcitymc.plugins.Chat;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class Chat implements Listener {
	@EventHandler
	public void mentionChat (AsyncPlayerChatEvent event) {
		
        String[] tempArray;

        tempArray = event.getMessage().split(" ");
        
        String[] newMessageA = new String[tempArray.length];
        String newMessage;
        
        
        for (int i = 0; i < tempArray.length; i++) {
        	//check if a player is in the message ^
        	if (Bukkit.getPlayer(tempArray[i]) != null) {
            	newMessageA[i] = ChatColor.AQUA+tempArray[i]+ChatColor.WHITE;
            	//tell the player they got mentioned and tell the sender they mentioned a player
            	if (Bukkit.getPlayer(tempArray[i]) != null) {
            		Bukkit.getPlayer(tempArray[i]).sendMessage(ChatColor.AQUA+event.getPlayer().getName()+" has mentioned you!");
            		event.getPlayer().sendMessage(ChatColor.AQUA+"You mentioned "+tempArray[i]+"!");
            	}
        	} else {
        		newMessageA[i] = tempArray[i];
        	}
        }
        
        newMessage = newMessageA[0];
        for (int i = 1; i < newMessageA.length; i++) {
        	newMessage = newMessage+" "+newMessageA[i];
        }
        
		event.setMessage(newMessage);
	}
    
    
    
}    
