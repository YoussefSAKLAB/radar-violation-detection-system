package org.miaad.registrationservice.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OwnerResponseDTO {
    private Long id;
    private String name;
    private Date birthDate;
    private String email;
}
