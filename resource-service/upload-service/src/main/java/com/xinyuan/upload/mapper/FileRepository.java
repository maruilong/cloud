package com.xinyuan.upload.mapper;

import com.xinyuan.base.mapper.BaseJpaRepository;
import com.xinyuan.upload.entity.FileInfor;
import org.springframework.stereotype.Repository;

/**
 * @author liang
 */
@Repository
public interface FileRepository extends BaseJpaRepository<FileInfor,Long> {


}
