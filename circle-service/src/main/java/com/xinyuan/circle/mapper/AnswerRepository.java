package com.xinyuan.circle.mapper;

import com.xinyuan.circle.entity.Answer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liang

 */
@Repository
public interface AnswerRepository extends BaseJpaRepository<Answer,Long> {

    List<Answer> findByTopicIdAndDeleted(Long id, int deleted);

    Answer findByIdAndDeleted(Long id, int deleted);

    Answer findTopByTopicIdAndDeletedOrderByLikesDesc(Long id, int deleted);

}
