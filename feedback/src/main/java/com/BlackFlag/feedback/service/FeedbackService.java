package com.BlackFlag.feedback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BlackFlag.feedback.model.Feedback;
import com.BlackFlag.feedback.repository.FeedbackRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

	private final FeedbackRepository feedbackRepository;

	@Autowired
	public FeedbackService(FeedbackRepository feedbackRepository) {
		this.feedbackRepository = feedbackRepository;
	}

	public Feedback saveFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

	public List<Feedback> getAllFeedback() {
		return feedbackRepository.findAll();
	}

	public Optional<Feedback> getFeedbackById(Long id) {
		return feedbackRepository.findById(id);
	}

	public void deleteFeedback(Long id) {
		feedbackRepository.deleteById(id);
	}
}
