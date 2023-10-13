package com.lokytech.learningPreferenceservice.repository;

import com.lokytech.learningPreferenceservice.entity.Strength;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrengthRepository extends JpaRepository<Strength, Long> {
}
