package org.miaad.registrationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OwnerRequestDTO {
    private String name;
    @DateTimeFormat(pattern = "")
    private Date birthDate;
    private String email;
    public void setBirthDate(String birthDate) {
        // Check if birthDate is a string and parse it to Date if needed
        if (birthDate != null && !birthDate.isEmpty()) {
            try {
                this.birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
