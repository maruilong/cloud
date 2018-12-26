package com.xinyuan.circle.service;

import com.xinyuan.circle.entity.mysql.Circle;
import com.xinyuan.circle.mapper.mysql.CircleRepository;
import com.xinyuan.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hwz
 */
@Service
public class CircleService extends BaseService<CircleRepository, Circle, Long> {

    @Autowired
    private CircleRepository circleRepository;

    @Transactional
    public void removeCircle(List<Long> ids) {
        for (Long i : ids) {
            super.remove(i);
        }
    }

    public Circle findById(Long id) {
        return circleRepository.findByIdAndDeleted(id,0);
    }
}
