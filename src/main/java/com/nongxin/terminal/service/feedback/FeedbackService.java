package com.nongxin.terminal.service.feedback;

import com.nongxin.terminal.entity.feedback.Feedback;

import java.util.List;

public interface FeedbackService {

    boolean add(Feedback feedback);

    List<Feedback> getFeedBack(Integer baseId);

}
