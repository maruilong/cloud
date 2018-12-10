package com.xinyuan.circle.service;

import com.xinyuan.base.common.web.Constants;
import com.xinyuan.base.entity.Relation;
import com.xinyuan.circle.client.RelationClient;
import com.xinyuan.circle.entity.Answer;
import com.xinyuan.circle.entity.Comment;
import com.xinyuan.circle.entity.Topic;
import com.xinyuan.circle.mapper.AnswerRepository;
import com.xinyuan.base.service.BaseService;
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
        return answerRepository.findByTopicIdAndDeleted(id,0);
    }

    public Answer findTopByTopicIdOrderByLikes(Long id) {
        return answerRepository.findTopByTopicIdAndDeletedOrderByLikesDesc(id,0);
    }

    @Transactional
    public Answer saveAnswer(Answer answer) {
        answer = save(answer);
        Topic topic = topicService.findById(answer.getTopicId());
        topic.setAnswers(topic.getAnswers() + 1);
        topicService.update(topic);

        Relation relation = new Relation();

        relation.setSrcUser((long) 1);
        relation.setSrcType(Constants.USER);
        relation.setActionType(Constants.REPLY);
        relation.setTargetId(answer.getId());
        relation.setTargetType(Constants.ANSWER);

        relationClient.add(relation);


        return answer;
    }

}