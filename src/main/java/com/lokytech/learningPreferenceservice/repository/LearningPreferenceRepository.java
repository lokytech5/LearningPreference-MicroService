package com.lokytech.learningPreferenceservice.repository;

import com.lokytech.learningPreferenceservice.entity.LearningPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningPreferenceRepository extends JpaRepository<LearningPreference, Long> {
}
