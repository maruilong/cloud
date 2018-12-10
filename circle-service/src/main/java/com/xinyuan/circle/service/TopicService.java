package com.xinyuan.circle.service;

import com.xinyuan.base.common.web.Constants;
import com.xinyuan.base.entity.Relation;
import com.xinyuan.circle.client.RelationClient;
import com.xinyuan.circle.entity.Answer;
import com.xinyuan.circle.entity.Topic;
import com.xinyuan.circle.mapper.TopicRepository;
import com.xinyuan.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author hwz
 */
@Service
public class TopicService extends BaseService<TopicRepository, Topic, Long> {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private RelationClient relationClient;

    @Transactional
    public Topic saveTopic(Topic topic) {
        topic = save(topic);

        Relation relation = new Relation();

        relation.setSrcUser((long) 1);
        relation.setSrcType(Constants.USER);
        relation.setActionType(Constants.ISSUE);
        relation.setTargetId(topic.getId());
        relation.setTargetType(Constants.TOPIC);
        relation.setDeleted(0);

        relationClient.add(relation);

        return topic;
    }

    public void removeTopic(List<Long> ids) {
        for (Long i : ids) {
            remove(i);

            List<Answer> answerList = answerService.findByTopicId(i);
            for (Answer answer : answerList) {
                answerService.remove(answer.getId());

            }
        }
    }

    public Topic findById(Long id) {
        return topicRepository.findByIdAndDeleted(id, 0);
    }


}
