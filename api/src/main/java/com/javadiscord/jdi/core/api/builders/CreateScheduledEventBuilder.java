package com.javadiscord.jdi.core.api.builders;

import java.time.OffsetDateTime;
import java.util.Optional;

import com.javadiscord.jdi.core.models.guild.EntityMetadata;
import com.javadiscord.jdi.core.models.scheduled_event.ScheduledEntityType;
import com.javadiscord.jdi.internal.api.guild_scheduled_event.CreateScheduledEventRequest;

public class CreateScheduledEventBuilder {
    private long guildId;
    private final String name;
    private final ScheduledEntityType entityType;
    private final int privacyLevel;
    private final OffsetDateTime scheduledStartTime;

    private Optional<Long> channelId;
    private Optional<EntityMetadata> entityMetadata;
    private Optional<OffsetDateTime> scheduledEndTime;
    private Optional<String> description;
    private Optional<String> image;

    public CreateScheduledEventBuilder(
        String name, ScheduledEntityType entityType, OffsetDateTime scheduledStartTime
    ) {
        this.name = name;
        this.entityType = entityType;
        this.privacyLevel = 2;
        this.scheduledStartTime = scheduledStartTime;
        this.channelId = Optional.empty();
        this.entityMetadata = Optional.empty();
        this.scheduledEndTime = Optional.empty();
        this.description = Optional.empty();
        this.image = Optional.empty();
    }

    public CreateScheduledEventBuilder channelId(long channelId) {
        this.channelId = Optional.of(channelId);
        return this;
    }

    public CreateScheduledEventBuilder entityMetadata(EntityMetadata entityMetadata) {
        this.entityMetadata = Optional.of(entityMetadata);
        return this;
    }

    public CreateScheduledEventBuilder scheduledEndTime(OffsetDateTime scheduledEndTime) {
        this.scheduledEndTime = Optional.of(scheduledEndTime);
        return this;
    }

    public CreateScheduledEventBuilder description(String description) {
        this.description = Optional.of(description);
        return this;
    }

    public CreateScheduledEventBuilder image(String image) {
        this.image = Optional.of(image);
        return this;
    }

    public CreateScheduledEventRequest build() {
        return new CreateScheduledEventRequest(
            guildId,
            channelId,
            entityMetadata,
            name,
            privacyLevel,
            scheduledStartTime,
            scheduledEndTime,
            description,
            entityType,
            image
        );
    }

    public CreateScheduledEventBuilder guildId(long guildId) {
        this.guildId = guildId;
        return this;
    }
}
