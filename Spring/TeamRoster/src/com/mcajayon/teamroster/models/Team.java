package com.mcajayon.teamroster.models;
import java.util.*;

public class Team {
	
	private String teamName;
	private ArrayList<Player> players;
	
	public Team(String name) {
		teamName = name;
		players = new ArrayList<>();
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public int getTeamSize() {
		return players.size();
	}
	
	public Player getPlayer(int index) {
		return players.get(index);
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void removePlayer(int index) {
		players.remove(index);
	}
}
