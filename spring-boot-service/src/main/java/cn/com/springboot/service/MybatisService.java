package cn.com.springboot.service;

import cn.com.springboot.entity.MybatisDo;
import cn.com.springboot.mapper.MybatisMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shenjies88
 */
@Slf4j
@AllArgsConstructor
@Service
public class MybatisService {

    private final MybatisMapper mybatisMapper;

    public List<MybatisDo> listEntity() {
        return mybatisMapper.getPage(0, 20);
    }

    public MybatisDo queryByCode(String code) {
        return mybatisMapper.getByCode(code);
    }
}
