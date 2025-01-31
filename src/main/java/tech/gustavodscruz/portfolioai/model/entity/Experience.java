package tech.gustavodscruz.portfolioai.model.entity;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String jobRole;
    
    @NotNull
    private LocalDate start;
    
    private LocalDate end;

    @NotNull
    private String company;
    
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @PrePersist
    public void PrePersist() {
        if (end == null) {
            end = LocalDate.now();
        }
    }
}
