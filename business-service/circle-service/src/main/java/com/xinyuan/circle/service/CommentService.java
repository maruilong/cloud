package com.xinyuan.circle.service;

import com.xinyuan.circle.entity.mysql.Comment;
import com.xinyuan.circle.mapper.mysql.CommentRepository;
import com.xinyuan.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hwz
 */
@Service
public class CommentService extends BaseService<CommentRepository, Comment, Long> {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private AnswerService answerService;

    @Autowired
    private TopicService topicService;

    public void removeComment(List<Long> ids) {
        for (Long i : ids) {

            Comment comment = findById(i);
            remove(i);

        }
    }

    /**
     * 评论保存
     *
     * @param comment
     * @return
     */
    @Transactional
    public Comment saveComment(Comment comment) {
        comment = save(comment);

        return comment;
    }

    public Comment findById(Long id) {
        return commentRepository.findByIdAndDeleted(id, 0);
    }

    /**
     * 评论点赞
     *
     * @param id
     * @return
     */
    public void commentLikes(Long id) {

        Comment comment = findById(id);

    }



    public List<Comment> findByPid(Long pid) {
        return commentRepository.findByPidAndDeleted(pid, 0);
    }

    public List<Comment> findByAnswerId(Long id) {
        return commentRepository.findByAnswerIdAndDeleted(id, 0);
    }

    //查找顶级节点
    public List<Comment> findComment(Long answerId , Long id) {
        List<Comment> commentList = findByAnswerId(answerId);
        List<Comment> comments = new ArrayList<>();
        if (commentList.size() > 0) {
            for (Comment comment : commentList) {
                if (comment.getPid() != 0) {
                    Comment c = findTopLevel(comment.getPid());
                    if (c != null) {
                        if (c.getId() == id) {
                            comments.add(comment) ;
                        }
                    }
                }
            }
        }

        return comments;
    }

    //查找顶级节点
    public Comment findTopLevel(Long id) {
        Comment comment = findById(id);
        if (comment != null) {
            if (comment.getPid() != 0) {
                return findTopLevel(comment.getPid());
            }
        }

        return comment;
    }

}
