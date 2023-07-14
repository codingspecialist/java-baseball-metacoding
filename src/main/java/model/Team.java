package model;

import lombok.*;

import java.sql.Timestamp;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Team {
    private Integer id;
    private Integer stadiumId;
    private String name;
    private Timestamp createdAt;
}
