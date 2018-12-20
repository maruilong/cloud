package com.xinyuan.circle.service;

import com.xinyuan.base.common.web.Constants;
import com.xinyuan.circle.entity.mysql.Answer;
import com.xinyuan.circle.entity.mysql.Comment;
import com.xinyuan.circle.mapper.mysql.AnswerRepository;
import com.xinyuan.base.service.BaseService;
import com.xinyuan.relation.client.RelationClient;
import com.xinyuan.relation.model.dto.RelationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hwz
 */
@Service
public class AnswerService extends BaseService<AnswerRepository, Answer, Long> {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private CircleService circleService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private RelationClient relationClient;

    public void removeAnswer(List<Long> ids) {
        for (Long i : ids) {
            List<Comment> comments = commentService.findByAnswerId(i);
            if (comments.size() > 0) {
                for (Comment comment : comments) {
                    commentService.remove(comment.getId());
                }
            }

            remove(i);
        }
    }


    public List<Answer> findByTopicId(Long id) {
        return answerRepository.findByTopicIdAndDeleted(id, 0);
    }

    public Answer findTopByTopicIdOrderByLikes(Long id) {
        return answerRepository.findTopByTopicIdAndDeletedOrderByLikesDesc(id, 0);
    }

    @Transactional
    public Answer saveAnswer(Answer answer) {
        long millis = System.currentTimeMillis();

        answer = save(answer);
//        Topic topic = topicService.findById(answer.getTopicId());
//        topic.setAnswers(topic.getAnswers() + 1);
//        topicService.update(topic);

        RelationDTO relation = new RelationDTO();

        relation.setSrcUser((long) 1);
        relation.setSrcType(Constants.USER);
        relation.setActionType(Constants.REPLY);
        relation.setTargetId(answer.getId());
        relation.setTargetType(Constants.ANSWER);

        relationClient.add(relation);
        long milliss = System.currentTimeMillis();

        String str = (milliss - millis) + "";
        System.out.println("耗时:" + str + "毫秒 ");
        return answer;
    }

}
