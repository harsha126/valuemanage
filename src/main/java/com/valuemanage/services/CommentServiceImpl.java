package com.valuemanage.services;

import com.valuemanage.domain.Comment;
import com.valuemanage.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment save(Comment comment) {

        return commentRepository.save(comment);
    }
}
