package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.vod.service.FileService;
import com.atguigu.ggkt.vod.utils.QiNiuUtil;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Override
    public String upload(MultipartFile file) {
        String name = UUID.randomUUID().toString().replaceAll("-","")+ file.getOriginalFilename();
        String dateUrl = new DateTime().toString("yyyy/MM/dd");
        String fileName = "ggkt/"+dateUrl+"/"+name;

        try {
            String url = QiNiuUtil.saveFile(file, fileName);
            return url;
        } catch (IOException e) {
            log.error("上传文件出错");
        }
        return null;
    }
}
