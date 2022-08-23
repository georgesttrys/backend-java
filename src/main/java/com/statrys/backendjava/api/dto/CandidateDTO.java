package com.statrys.backendjava.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CandidateDTO {
    private UUID internalIdentifier;
    private String firstName;
    private String lastName;
    private int yearsOfExperience;
    private String previousJobRole;
    private String cvURL;
    private UUID applicationId;
    private LocalDateTime applicationTs;
}
