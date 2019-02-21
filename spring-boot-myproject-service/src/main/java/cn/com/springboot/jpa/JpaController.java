package cn.com.springboot.jpa;

import cn.com.springboot.common.HttpResult;
import cn.com.springboot.common.aop.LoggerManage;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sj
 * @date 2018/10/18
 */
@Api(tags = "JPA模板")
@AllArgsConstructor
@RequestMapping("/jpa")
@RestController
public class JpaController {

    private SoccerService soccerService;

    @GetMapping("/getAllTeam")
    public HttpResult getAllTeamPlayers() {
        List<Player> players = soccerService.getAllTeamPlayers(1);
        return HttpResult.success(players);
    }

    @LoggerManage(description = "JpaController-addBarcelonaPlayer")
    @PostMapping("/add")
    public HttpResult addBarcelonaPlayer(@RequestParam("name") String name,
                                         @RequestParam("position") String position,
                                         @RequestParam("number") int number) {
        soccerService.addBarcelonaPlayer(name, position, number);
        return HttpResult.success();
    }

    @PostMapping("/update_name/")
    public HttpResult updatePlerNameByID(@RequestParam("name") String name,
                                         @RequestParam("id") Long id) {
        soccerService.updatePlayerNameByID(name, id);
        return HttpResult.success();
    }
}
