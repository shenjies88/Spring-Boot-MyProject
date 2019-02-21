package cn.com.springboot.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sj
 * @date 2018/10/18
 */
@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
    Team findById(long playerId);
}
