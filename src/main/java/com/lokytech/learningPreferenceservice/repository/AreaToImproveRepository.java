package com.lokytech.learningPreferenceservice.repository;

import com.lokytech.learningPreferenceservice.entity.AreaToImprove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaToImproveRepository extends JpaRepository<AreaToImprove, Long> {
}
