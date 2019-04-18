package cn.com.springboot.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
//@AllArgsConstructor
@Service
public class MybatisService {

    private MybatisMapper mybatisMapper;

    public List<MybatisEntity> listEntity() {
        return mybatisMapper.listEntity(0, 20);
    }

    public MybatisEntity queryByCode(String code) {
        return mybatisMapper.queryByCode(code);
    }
}
