package cn.com.springboot.controller;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author shenjies88
 * @since 2019-04-16-15:52
 */
public class DownLoadController {

    public void downLoad(HttpServletResponse response) throws UnsupportedEncodingException {

        response.setContentType("application/x-download;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("文件名.xlsx", StandardCharsets.UTF_8));
//        Files.copy(path, response.getOutputStream()); 写入输出流

    }
}
