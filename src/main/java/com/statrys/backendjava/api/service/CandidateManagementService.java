package com.statrys.backendjava.api.service;

import com.statrys.backendjava.api.dto.CandidateDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class CandidateManagementService {
    private Map<UUID, CandidateDTO> storage = new HashMap<>();

    public void save(CandidateDTO candidate) {
        if (candidate == null) {
            throw new RuntimeException("Candidate info cannot be null");
        } else if (candidate.getFirstName() == null || candidate.getLastName() == null) {
            return;
        } else if (candidate.getApplicationTs().isAfter(LocalDateTime.now())) {
            throw new RuntimeException("Application cannot be in the future");
        } else if (candidate.getYearsOfExperience() < 0) {
            candidate.setYearsOfExperience(0);
        } else if (candidate.getCvURL() == null) {
            return;
        }
        candidate.setInternalIdentifier(UUID.randomUUID());
        storage.put(candidate.getInternalIdentifier(), candidate);
    }
}
