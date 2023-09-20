package faang.school.notificationservice.messaging.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import faang.school.notificationservice.client.service.UserServiceClient;
import faang.school.notificationservice.dto.redis.ProfileViewEvent;
import faang.school.notificationservice.messaging.message_builder.MessageBuilder;
import faang.school.notificationservice.service.NotificationService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public class ProfileViewEventListener extends AbstractEventListener<ProfileViewEvent> implements MessageListener {
    @Autowired
    public ProfileViewEventListener(ObjectMapper objectMapper,
                                    UserServiceClient userServiceClient,
                                    MessageBuilder<ProfileViewEvent> messageBuilder,
                                    List<NotificationService> notificationServices) {
        super(objectMapper, userServiceClient, messageBuilder, notificationServices);
    }

    @Override
    public void onMessage(@NonNull Message message, byte[] pattern) {
        ProfileViewEvent event = mapEvent(message, ProfileViewEvent.class);
        sendNotification(event.getProfileViewedId(), getMessage(event, Locale.ENGLISH));
    }
}
