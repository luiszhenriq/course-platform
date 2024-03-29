package br.com.luis.courseplatform.models;

import br.com.luis.courseplatform.dtos.course.CourseRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private Integer price;

    private LocalDate createdAt;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Module> modules = new ArrayList<>();

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Course(CourseRequestDto courseRequestDto) {
        this.title = courseRequestDto.title();
        this.description = courseRequestDto.description();
        this.price = courseRequestDto.price();
        this.createdAt = LocalDate.now();
    }
}
