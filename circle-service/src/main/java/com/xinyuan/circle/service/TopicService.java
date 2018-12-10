package com.xinyuan.circle.service;

import com.xinyuan.circle.entity.Answer;
import com.xinyuan.circle.entity.Topic;
import com.xinyuan.circle.mapper.TopicRepository;
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

    @Transactional
    public Topic saveTopic(Topic topic) {
        topic = save(topic);

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
