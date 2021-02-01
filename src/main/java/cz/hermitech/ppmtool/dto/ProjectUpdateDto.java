package cz.hermitech.ppmtool.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectUpdateDto {
    @NotBlank(message = "Project name is required")
    String projectName;
    @NotBlank(message = "Project identifier is required")
    String projectIdentifier;
    @NotBlank(message = "Project description is required")
    String description;
    Date start_date;
    Date end_date;
}
