package com.xinyuan.upload.service;


import com.xinyuan.base.service.BaseService;
import com.xinyuan.upload.entity.FileInfor;
import com.xinyuan.upload.mapper.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hwz
 */
@Service
public class FileService extends BaseService<FileRepository, FileInfor, Long> {
    @Autowired
    FileRepository fileRepository;
}
