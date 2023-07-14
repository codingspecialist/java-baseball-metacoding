package model;

import lombok.*;

import java.sql.Timestamp;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Stadium {
    private Integer id;
    private String name;
    private Timestamp createdAt;
}
