package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.yandex.practicum.filmorate.validation.constraints.FilmReleaseDateConstraint;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class Film {
    private Integer id;
    @NotBlank
    private String name;
    @Size(min = 1, max = 200, message = "Description length must be not more 200 characters")
    private String description;
    @FilmReleaseDateConstraint
    private LocalDate releaseDate;
    @Positive
    private Integer duration;
    private Set<Integer> likes = new HashSet<>();

    public Integer getLikesCount() {
        return getLikes().size();
    }
}
