package model;

import lombok.*;

import java.sql.Timestamp;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Player {
    private Integer id;
    private Integer teamId;
    private String name;
    private String position;
    private Timestamp createdAt;
}
