package com.sudaotech.comment.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.sudaotech.comment.service.CommentService;
import com.sudaotech.comment.service.CommentService.Comment;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BlackWordsService;
import com.sudaotech.event.NotifyEvent;
import com.sudaotech.event.NotifyEventListener;
import com.sudaotech.util.JsonUtil;

public class CommentEventListener implements NotifyEventListener {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Inject
    private CommentService commentService;
    @Inject
    private BlackWordsService blackWordsService;
    
    @Override
    public void onReceive(NotifyEvent notifyEvent) {
        if (notifyEvent instanceof CreatingCommentEvent) {
            handle((CreatingCommentEvent) notifyEvent);
        }
    }

    private void handle(CreatingCommentEvent notifyEvent) {
        Comment comment = notifyEvent.getComment();
        if (blackWordsService.isBlack(comment.getContent())) {
            this.logger.warn("Black words: {}", JsonUtil.toJsonQuietly(comment.getContent()));
            comment.setStatus(Status.DELETED);
        }
        this.commentService.create(comment);
    }
}
