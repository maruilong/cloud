package com.xinyuan.circle.mapper;

import com.xinyuan.circle.entity.Comment;
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
