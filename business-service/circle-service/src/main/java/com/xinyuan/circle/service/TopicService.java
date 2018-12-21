package com.xinyuan.circle.service;

import com.alibaba.fastjson.JSONObject;
import com.codingapi.tx.annotation.TxTransaction;
import com.xinyuan.base.common.web.Constants;
import com.xinyuan.circle.entity.mysql.Answer;
import com.xinyuan.circle.entity.mysql.Topic;
import com.xinyuan.circle.entity.pgsql.Book;
import com.xinyuan.circle.mapper.mysql.TopicRepository;
import com.xinyuan.base.service.BaseService;
//import com.xinyuan.circle.mapper.pgsql.BookRepository;
import com.xinyuan.circle.mapper.pgsql.BookRepository;
import com.xinyuan.elasticsearch.AddDataDTO;
import com.xinyuan.relation.model.dto.RelationDTO;
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
    private RelationService relationService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RedisService redisService;

    @Autowired
    private ElasticSearchService elasticSearchService;

    @Transactional
    @TxTransaction(isStart = true)
    public Topic saveTopic(Topic topic) {
        topic = save(topic);

        RelationDTO relationDTO = new RelationDTO();

        relationDTO.setSrcUser((long) 1);
        relationDTO.setSrcType(Constants.USER);
        relationDTO.setActionType(Constants.ISSUE);
        relationDTO.setTargetId(topic.getId());
        relationDTO.setTargetType(Constants.TOPIC);
        relationDTO.setDeleted(0);

        relationService.add(relationDTO);

        Book book = new Book();
        book.setContent(topic.getTitle());
        bookRepository.save(book);

//        System.out.println(redisService.getAllKeys().toString());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "shinian");

        AddDataDTO addDataDTO = new AddDataDTO();
        addDataDTO.setJsonObject(jsonObject);
        addDataDTO.setIndex("cloud");
        addDataDTO.setType("person");
//        String addData = elasticSearchService.addData(addDataDTO);
//        System.out.println(addData);
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
