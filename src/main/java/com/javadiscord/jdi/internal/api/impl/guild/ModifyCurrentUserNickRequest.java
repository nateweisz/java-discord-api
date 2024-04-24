package com.javadiscord.jdi.internal.api.impl.guild;

import com.javadiscord.jdi.internal.api.DiscordRequest;
import com.javadiscord.jdi.internal.api.DiscordRequestBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/** Deprecated in favor of ModifyCurrentMemberRequest */
@Deprecated
public record ModifyCurrentUserNickRequest(long guildId, Optional<String> nick)
        implements DiscordRequest {

    @Override
    public DiscordRequestBuilder create() {
        Map<String, Object> body = new HashMap<>();
        nick.ifPresent(val -> body.put("nick", val));

        return new DiscordRequestBuilder()
                .patch()
                .path("/guilds/%s/members/@me/nick".formatted(guildId))
                .body(body);
    }
}
