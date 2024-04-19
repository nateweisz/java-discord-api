package com.javadiscord.jdi.internal.models.auditlog;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// missing auditLogChanges
@JsonIgnoreProperties(ignoreUnknown = true)
public record AuditLogEntry(
    @JsonProperty("target_id") String targetId,
    @JsonProperty("user_id") long userId,
    @JsonProperty("id") long id,
    @JsonProperty("action_type") AuditLogEvent actionType,
    @JsonProperty("options") OptionalAuditEntryInfo auditEntryInfo,
    @JsonProperty("reason") String reason
) {}
