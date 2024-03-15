package br.com.luis.courseplatform.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "assessments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

   // private Course course;

   // private User user;

    @Column(nullable = false)
    private String comment;

    private LocalDate createdAt;
}
