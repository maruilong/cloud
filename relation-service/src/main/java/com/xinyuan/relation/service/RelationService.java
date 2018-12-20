package com.xinyuan.relation.service;

import com.codingapi.tx.annotation.ITxTransaction;
import com.codingapi.tx.annotation.TxTransaction;
import com.xinyuan.base.service.BaseService;
import com.xinyuan.relation.entity.Relation;
import com.xinyuan.relation.mapper.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hwz
 */
@Service
public class RelationService extends BaseService<RelationRepository, Relation, Long> implements ITxTransaction {
    @Autowired
    private RelationRepository relationRepository;

    @Transactional()
    @TxTransaction
    @Override
    public Relation save(Relation entity) {

        return super.save(entity);
    }

    public Relation find(Long srcUser, String actionType, Long targetId, String targetType) {
        return relationRepository.findBySrcUserAndActionTypeAndTargetIdAndTargetTypeAndDeleted(srcUser, actionType, targetId, targetType, 0);
    }

    void delete(Relation relation) {
        relationRepository.delete(relation);
    }

    @Transactional(rollbackFor = Exception.class)
    public Relation createRelation(Long srcUser, String srcType, String actionType, String targetType, Long TargetId) {
        Relation relation = new Relation();
        relation.setSrcUser(srcUser);
        relation.setSrcType(srcType);
        relation.setActionType(actionType);
        relation.setTargetId(TargetId);
        relation.setTargetType(targetType);

        return relation;
    }

    public List<Relation> findByTargetId(Long targetId) {
        return relationRepository.findByTargetIdAndDeleted(targetId, 0);
    }

    public List<Relation> findByTargetIdAndTargetType(Long targetId, String targetType) {
        return relationRepository.findByTargetIdAndTargetTypeAndDeleted(targetId, targetType, 0);
    }

    public List<Relation> findBySrcUserAndActionTypeAndTargetType(Long srcUser, String actionType, String targetType) {
        return relationRepository.findBySrcUserAndActionTypeAndTargetTypeAndDeleted(srcUser, actionType, targetType, 0);
    }

    public List<Relation> findLatestNew(Long srcUser, String actionType1, String actionType2, String targetType1, String targetType2) {
        return relationRepository.findBySrcUserAndActionTypeOrActionTypeAndTargetTypeOrTargetTypeAndDeleted(srcUser, actionType1, actionType2, targetType1, targetType2, 0);
    }

    public List<Relation> findLatestNews(Long srcUser, String actionType1, String actionType2, String targetType1, String targetType2) {

        List<String> actionType = new ArrayList<>();
        actionType.add(actionType1);
        actionType.add(actionType2);

        List<String> targetType = new ArrayList<>();
        targetType.add(targetType1);
        targetType.add(targetType2);

        return relationRepository.findBySrcUserAndActionTypeInAndTargetTypeInAndDeletedOrderByIdDesc(srcUser, actionType, targetType, 0);
    }

    public void removeRelation(Long id, String targetType) {
        List<Relation> relations = findByTargetIdAndTargetType(id, targetType);
        if (relations.size() > 0) {
            for (Relation relation : relations) {
                if (relation != null) {
                    remove(relation.getId());
                }
            }
        }
    }
}
