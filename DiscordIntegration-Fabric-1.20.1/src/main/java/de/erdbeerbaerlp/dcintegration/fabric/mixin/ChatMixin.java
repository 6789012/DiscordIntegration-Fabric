package de.erdbeerbaerlp.dcintegration.fabric.mixin;

import de.erdbeerbaerlp.dcintegration.fabric.DiscordIntegrationMod;
import me.vetustus.server.simplechat.api.event.PlayerChatCallback;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import net.minecraft.entity.Entity;
import de.erdbeerbaerlp.dcintegration.common.DiscordIntegration;
import de.erdbeerbaerlp.dcintegration.common.minecraftCommands.MCSubCommand;
import de.erdbeerbaerlp.dcintegration.common.minecraftCommands.McCommandRegistry;
import de.erdbeerbaerlp.dcintegration.common.storage.Configuration;
import de.erdbeerbaerlp.dcintegration.common.storage.Localization;
import de.erdbeerbaerlp.dcintegration.common.util.DiscordMessage;
import de.erdbeerbaerlp.dcintegration.common.util.MessageUtils;
import de.erdbeerbaerlp.dcintegration.common.util.MinecraftPermission;
import de.erdbeerbaerlp.dcintegration.fabric.util.FabricServerInterface;

@Mixin(value = ServerPlayNetworkHandler.class)
public class ChatMixin {
    /**
     * Handle chat messages
     */
    @Redirect(method = "handleDecoratedMessage", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/PlayerManager;broadcast(Lnet/minecraft/network/message/SignedMessage;Lnet/minecraft/server/network/ServerPlayerEntity;Lnet/minecraft/network/message/MessageType$Parameters;)V"))
    public void chatMessage(PlayerManager instance, SignedMessage signedMessage, ServerPlayerEntity sender, MessageType.Parameters params) {
        // Создаем сообщение чата с помощью коллбека Simple Chat
        //PlayerChatCallback.ChatMessage chatMessage = new PlayerChatCallback.ChatMessage(sender, signedMessage.getContent().getString());

        // Вызываем коллбек для обработки сообщения
        //PlayerChatCallback.ChatMessage result = PlayerChatCallback.EVENT.invoker().result(sender, chatMessage.getMessage());

        // Проверяем, было ли сообщение отменено
        //if (result.isCancelled()) {
        //    return;
        //}
		
		//Entity sourceEntity = sender;
        // Обрабатываем сообщение чата с помощью Discord Integration
        //SignedMessage handledMessage = DiscordIntegrationMod.handleChatMessage(signedMessage, sender);

        //DiscordIntegration.INSTANCE.sendMessage("test", sourceEntity != null ? sourceEntity.getUuidAsString() : "0000000", new DiscordMessage(null, handledMessage.getContent().getString(), true), DiscordIntegration.INSTANCE.getChannel(Configuration.instance().advanced.chatOutputChannelID));


        // Передаем обработанное сообщение на вещание
        //instance.broadcast(handledMessage, sender, params);
    }
}