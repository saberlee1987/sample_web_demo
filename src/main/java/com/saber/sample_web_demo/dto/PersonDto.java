package com.saber.sample_web_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String gender;
    private String education;
    private String address;
    private Integer age;
    private String email;
    private String mobile;

    public boolean checkedGender(String flagName) {
        boolean result = false;
        if (gender !=null && flagName!=null) {
            if (flagName.equalsIgnoreCase(gender)) {
                result = true;
            }
        }

        return result;
    }

    public boolean checkedEducation(String flagEducation) {
        boolean result = false;
        if (education != null && flagEducation != null) {
            if (flagEducation.equalsIgnoreCase(education)) {
                result = true;
            }
        }
        return result;
    }

    public List<Constants.EducationEnum> getEducations(){
        return Arrays.stream(Constants.EducationEnum.values()).toList();
    }
}
