package com.Richard.NoteHaven.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "note", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column( name = "name", nullable = false, unique = true)
    @Size(min = 3, max = 30, message = "The name must be between 3 and 50 characters.")
    @NotNull(message = "The name cannot be null.")
    private String name;

    @Lob
    @Column(name = "content")
    private String content;

}
