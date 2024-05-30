package com.javadiscord.jdi.core.models.message;

import java.util.List;

import com.javadiscord.jdi.core.models.channel.Channel;
import com.javadiscord.jdi.core.models.channel.ChannelMention;
import com.javadiscord.jdi.core.models.guild.ResolvedData;
import com.javadiscord.jdi.core.models.guild.RoleSubscriptionData;
import com.javadiscord.jdi.core.models.message.embed.Embed;
import com.javadiscord.jdi.core.models.ready.Application;
import com.javadiscord.jdi.core.models.user.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Message(
    @JsonProperty("guild_id") long guildId,
    @JsonProperty("id") long id,
    @JsonProperty("channel_id") long channelId,
    @JsonProperty("author") User author,
    @JsonProperty("content") String content,
    @JsonProperty("timestamp") String timestamp,
    @JsonProperty("edited_timestamp") String editedTimestamp,
    @JsonProperty("tts") boolean tts,
    @JsonProperty("mention_everyone") boolean mentionEveryone,
    @JsonProperty("mentions") List<User> mentions,
    @JsonProperty("mention_roles") List<String> mentionRoles,
    @JsonProperty("mention_channels") List<ChannelMention> mentionChannels,
    @JsonProperty("attachments") List<MessageAttachment> messageAttachments,
    @JsonProperty("embeds") List<Embed> embeds,
    @JsonProperty("reactions") List<MessageReaction> messageReactions,
    @JsonProperty("nonce") Object nonce,
    @JsonProperty("pinned") boolean pinned,
    @JsonProperty("webhook_id") long webhookId,
    @JsonProperty("type") MessageType type,
    @JsonProperty("activity") MessageActivity activity,
    @JsonProperty("application") Application application,
    @JsonProperty("application_id") String applicationId,
    @JsonProperty("message_reference") MessageReference messageReference,
    @JsonProperty("flags") int flags,
    @JsonProperty("referenced_message") Message referencedMessage,
    @JsonProperty("interaction_metadata") MessageInteractionMetadata interactionMetadata,
    @JsonProperty("interaction") MessageInteraction interaction,
    @JsonProperty("thread") Channel thread,
    @JsonProperty("components") List<Component> components,
    @JsonProperty("sticker_items") List<StickerItem> stickerItems,
    @JsonProperty("stickers") List<Sticker> stickers,
    @JsonProperty("position") int position,
    @JsonProperty("role_subscription_data") RoleSubscriptionData roleSubscriptionData,
    @JsonProperty("resolved") ResolvedData resolved
) {

    public boolean fromBot() {
        return author.bot();
    }

    public boolean fromUser() {
        return !author.bot();
    }
}
