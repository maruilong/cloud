package com.xinyuan.upload.web.controller;

import com.xinyuan.base.common.util.ResultUtil;
import com.xinyuan.base.common.web.Message;
import com.xinyuan.upload.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hwz
 * @Date: Created in 15:15 2018/4/10.
 */
@Api(description = "图片上传")
@RestController
public class UploadController {
    @Autowired
    private FileService fileService;

    @ApiOperation(value = "上传图片", notes = "上传图片")
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public ResponseEntity<List<Message>> fileUpload(HttpServletRequest request) throws Exception {
        MultiValueMap<String, MultipartFile> multiFileMap = ((MultipartHttpServletRequest) request).getMultiFileMap();
        List<Message> messages = new ArrayList<>();
        if (multiFileMap.size() > 0) {
            for (List<MultipartFile> files : multiFileMap.values()) {
                for (MultipartFile file : files) {
                    Message message = fileService.upload(file);
                    messages.add(message);
                }
            }
        } else {
            Message message = ResultUtil.error(1007, "未选中图片为空");
            messages.add(message);
        }
        return ResponseEntity.ok(messages);
    }

}
