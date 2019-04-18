package cn.com.springboot.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sj
 * @date 2018/10/18
 */
@Slf4j
//@AllArgsConstructor
@Service
public class SoccerServiceImpl implements SoccerService {

    private PlayerRepository playerRepository;

    private TeamRepository teamRepository;

    @Override
    public List<Player> getAllTeamPlayers(long teamId) {

        return playerRepository.findByTeamId(teamId);
    }

    @Override
    public void addBarcelonaPlayer(String name, String position, int number) {
        var barcelona = teamRepository.findById(1L);
        var newPlayer = new Player();
        newPlayer.setName(name);
        newPlayer.setPosition(position);
        newPlayer.setNum(number);
        newPlayer.setTeam(barcelona);
        playerRepository.save(newPlayer);
    }

    @Transactional
    @Override
    public void updatePlayerNameByID(String name, Long id) {
        var result = playerRepository.findById(id);
        if (result.isPresent()) {
            Player player = result.get();
            player.setName(name);
            playerRepository.save(player);
        }
    }


}
