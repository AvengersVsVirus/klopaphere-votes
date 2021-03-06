package de.klopaphere.voting.model;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "vote")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoteEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column private String product;

  @Column private String location;

  @Column(name = "creation_date", nullable = false)
  private OffsetDateTime creationDate;

  @Column
  @Enumerated(EnumType.STRING)
  private Availability availability;

  @PrePersist
  protected void onCreate() {
    creationDate = OffsetDateTime.now();
  }
}
