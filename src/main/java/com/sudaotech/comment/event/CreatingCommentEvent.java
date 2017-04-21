package com.sudaotech.comment.event;

import com.sudaotech.comment.service.CommentService.Comment;
import com.sudaotech.event.NotifyEvent;

public class CreatingCommentEvent implements NotifyEvent {
    private Comment comment;
    public Comment getComment() {
        return comment;
    }
    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
