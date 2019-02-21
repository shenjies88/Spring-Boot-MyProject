package cn.com.springboot.jpa;

import java.util.List;

public interface SoccerService {
    public List<Player> getAllTeamPlayers(long teamId);

    public void addBarcelonaPlayer(String name, String position, int number);

    public void updatePlayerNameByID(String name, Long id);
}
