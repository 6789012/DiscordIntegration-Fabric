package me.vetustus.server.simplechat.api.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.server.network.ServerPlayerEntity;

public interface ChatMessageEvent {
    Event<ChatMessageEvent> EVENT = EventFactory.createArrayBacked(ChatMessageEvent.class,
        (listeners) -> (playerName, playerUUID, message) -> {
            for (ChatMessageEvent listener : listeners) {
                listener.onMessage(playerName, playerUUID, message);
            }
        }
    );

    void onMessage(String playerName, String playerUUID, String message);
}