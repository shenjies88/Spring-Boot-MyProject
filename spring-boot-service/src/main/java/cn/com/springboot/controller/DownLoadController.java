package cn.com.springboot.controller;

import cn.com.springboot.vo.ExcelVo;
import cn.com.springboot.vo.HttpResult;
import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author shenjies88
 * @since 2019-04-16-15:52
 */
@Slf4j
@Api(tags = "上传下载")
@RequestMapping("/file")
@RestController
public class DownLoadController {

    @ApiOperation("解析")
    @PostMapping("/parsing")
    public HttpResult<List<ExcelVo>> parsing(@RequestParam(value = "file") MultipartFile file) throws IOException, Excel4JException {
        List<ExcelVo> result = ExcelUtils.getInstance().readExcel2Objects(file.getInputStream(), ExcelVo.class);
        return HttpResult.success(result);
    }

    @ApiOperation("上传文件")
    @PostMapping("/upload")
    public HttpResult<Void> upload(@RequestParam(value = "file") MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        Assert.hasText(filename, "文件名不能为空");
        Assert.isTrue(file.getBytes().length != 0, "文件内容不能为空");
        Path path = Paths.get("./spring-boot-service/src/main/resources/" + filename);
        Files.copy(file.getInputStream(), path);
        return HttpResult.success();
    }

    @ApiOperation("下载")
    @GetMapping("/download")
    public void downLoad(HttpServletResponse response) throws IOException {
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "上传下载测试.xlsx");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), StandardCharsets.UTF_8));
        response.setContentType("application/x-download;charset=UTF-8");
        Files.copy(file.toPath(), response.getOutputStream());
    }
}
