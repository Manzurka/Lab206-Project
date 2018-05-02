package com.mcajayon.teamroster.models;
import java.util.*;

public class Team {
	private String team_name;
	private Integer team_id;
	public static ArrayList<Team> teams = new ArrayList<Team>();
	private ArrayList<Player> players = new ArrayList<>();
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public String getTeamName() {
		return team_name;
	}
	public Team() {
	}
	public Team(String team_name) {
		this.team_name = team_name;
		this.setTeam_id(teams.size());
		teams.add(this);
	}
	public void addPlayer(String first_name, String last_name, Integer age) {
		Player NewPlayer = new Player(first_name, last_name, age);
		this.getPlayers().add(NewPlayer);
	}
	public static ArrayList<Team>getTeams() {
		return teams;
	}
	public static Team findTeam(Integer team_id) {
		for (int i=0; i<teams.size(); i++) {
			Team a = teams.get(i);
			if (a.getTeam_id() == team_id) {
				return a;
			}
		}
		return null;
	}
	public Integer getTeam_id() {
		return team_id;
	}
	public void setTeam_id(Integer team_id) {
		this.team_id = team_id;
	}
}
