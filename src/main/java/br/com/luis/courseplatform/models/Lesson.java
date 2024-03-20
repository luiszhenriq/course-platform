package br.com.luis.courseplatform.models;


import br.com.luis.courseplatform.dtos.lesson.LessonRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "lessons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String videoUrl;

    @Column(nullable = false)
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    public Lesson(LessonRequestDto lessonRequestDto) {
        this.title = lessonRequestDto.title();
        this.videoUrl = lessonRequestDto.videoUrl();
        this.duration = lessonRequestDto.duration();
    }
}
