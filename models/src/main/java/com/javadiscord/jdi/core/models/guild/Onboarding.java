package com.javadiscord.jdi.core.models.guild;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Onboarding(
    @JsonProperty("guild_id") long guildId,
    @JsonProperty("prompts") List<OnboardingPrompt> prompts,
    @JsonProperty("default_channel_ids") List<Long> defaultChannelIds,
    @JsonProperty("enabled") boolean enabled,
    @JsonProperty("mode") OnboardingMode mode
) {}
