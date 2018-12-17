package com.xinyuan.circle.mapper.mysql;

import com.xinyuan.circle.entity.mysql.Comment;
import com.xinyuan.base.mapper.BaseJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author liang

 */
@Repository
public interface CommentRepository extends BaseJpaRepository<Comment,Long> {

    Comment findByIdAndDeleted(Long id, int deleted);

    List<Comment> findByPidAndDeleted(Long pid, int deleted);

    List<Comment> findByAnswerIdAndDeleted(Long id, int deleted);
}
