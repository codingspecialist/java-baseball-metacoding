package dto;

import lombok.*;

import java.sql.Timestamp;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class OutPlayerRespDto {
    private int pId;
    private String pName;
    private String pPosition;
    private String opReason;
    private Timestamp opCreatedAt;
}
