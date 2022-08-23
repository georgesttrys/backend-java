package com.statrys.backendjava.api;

import com.statrys.backendjava.api.dto.CandidateDTO;
import com.statrys.backendjava.api.service.CandidateManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppApi {
    @Autowired
    private CandidateManagementService candidateManagementService;

    @PostMapping(path = "/candidates")
    public ResponseEntity<Void> saveCandidateInfo(CandidateDTO candidate) {
        if (candidate == null) {
            return ResponseEntity.badRequest().build();
        }

        candidateManagementService.save(candidate);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
