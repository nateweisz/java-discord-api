package com.javadiscord.jdi.internal.api.guild;

import java.util.Optional;

import com.javadiscord.jdi.internal.api.DiscordRequest;
import com.javadiscord.jdi.internal.api.DiscordRequestBuilder;

public record ListGuildMembersRequest(
    long guildId,
    Optional<Integer> limit,
    Optional<Long> after
) implements DiscordRequest {

    @Override
    public DiscordRequestBuilder create() {
        DiscordRequestBuilder discordRequestBuilder =
            new DiscordRequestBuilder().get().path("/guilds/%s/members".formatted(guildId));

        limit.ifPresent(val -> discordRequestBuilder.queryParam("limit", val));
        after.ifPresent(val -> discordRequestBuilder.queryParam("after", val));

        return discordRequestBuilder;
    }
}
