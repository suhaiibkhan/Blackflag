package com.BlackFlag.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.BlackFlag.feedback.model.Feedback;
import com.BlackFlag.feedback.service.FeedbackService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

	private final FeedbackService feedbackService;

	@Autowired
	public FeedbackController(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}

	@PostMapping
	public Feedback addFeedback(@RequestBody Feedback feedback) {
		return feedbackService.saveFeedback(feedback);
	}

	@GetMapping
	public List<Feedback> getAllFeedback() {
		return feedbackService.getAllFeedback();
	}

	@GetMapping("/{id}")
	public Optional<Feedback> getFeedbackById(@PathVariable Long id) {
		return feedbackService.getFeedbackById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteFeedback(@PathVariable Long id) {
		feedbackService.deleteFeedback(id);
	}
}
