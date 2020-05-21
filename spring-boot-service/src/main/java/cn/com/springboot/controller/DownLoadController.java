package cn.com.springboot.controller;

import cn.com.springboot.vo.ExcelVo;
import com.alibaba.fastjson.JSON;
import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author shenjies88
 * @since 2019-04-16-15:52
 */
@Slf4j
@Api(tags = "上传下载")
@RestController
public class DownLoadController {

    @ApiOperation("上传下载")
    @PostMapping("upload-download")
    public void downLoad(@RequestParam(value = "file") MultipartFile file,
                         HttpServletResponse response) {
        try {
            String fileName = file.getOriginalFilename();
            List<ExcelVo> excelVos = ExcelUtils.getInstance().readExcel2Objects(file.getInputStream(), ExcelVo.class);
            if (CollectionUtils.isEmpty(excelVos)) {
                throw new RuntimeException("转换对象失败或无数据");
            }
            excelVos.forEach(e -> log.info(JSON.toJSONString(e)));
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
            response.setContentType("application/x-download;charset=UTF-8");
            ExcelUtils.getInstance().exportObjects2Excel(excelVos, ExcelVo.class, response.getOutputStream());
        } catch (IOException | Excel4JException e) {
            log.info("读取文件流异常", e);
        }
    }
}
