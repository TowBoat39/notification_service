package faang.school.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LikeDto {
    private Long userId;
    private Long commentId;
    private Long postId;
    private ZonedDateTime createdAt;
}
