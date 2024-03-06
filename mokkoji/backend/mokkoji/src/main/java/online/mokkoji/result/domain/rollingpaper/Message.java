package online.mokkoji.result.domain.rollingpaper;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rollingpaper_id")
    @JsonBackReference
    private RollingPaper rollingPaper;

    @Column(length = 6, nullable = false)
    private String writer;

    private String text;
    private String voicePath;
    private String videoPath;

    @Builder
    public Message(RollingPaper rollingPaper, String writer, @Nullable String text, @Nullable String voicePath, @Nullable String videoPath) {
        this.rollingPaper = rollingPaper;
        this.writer = writer;
        this.text = text;
        this.voicePath = voicePath;
        this.videoPath = videoPath;
    }
}
