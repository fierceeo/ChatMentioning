package com.voidcitymc.plugins.Chat;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class Chat implements Listener {
	@EventHandler (priority = EventPriority.HIGHEST)
	public void mentionChat (AsyncPlayerChatEvent event) {
		
        String[] tempArray;

        tempArray = event.getMessage().split(" ");
        
        String[] newMessageA = new String[tempArray.length];
        String newMessage;
        
        
        for (int i = 0; i < tempArray.length; i++) {
        	//check if a player is in the message ^
        	if (Bukkit.getPlayer(tempArray[i]) != null) {
            	newMessageA[i] = ChatColor.AQUA+tempArray[i]+ChatColor.WHITE;
            	if (Bukkit.getPlayer(tempArray[i]) != null) {
            		if (event.getRecipients().contains(Bukkit.getPlayer(tempArray[i]))) {
            			//tell the player they got mentioned, tell sender they mentioned a player and play a ding noise
            			Bukkit.getPlayer(tempArray[i]).playSound(Bukkit.getPlayer(tempArray[i]).getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 0F);
            			Bukkit.getPlayer(tempArray[i]).sendMessage(ChatColor.AQUA+event.getPlayer().getName()+" has mentioned you!");
            			event.getPlayer().sendMessage(ChatColor.AQUA+"You mentioned "+tempArray[i]+"!");
            		} else {
            			//could not mention player because of local chat plugin, etc.
            		}
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
