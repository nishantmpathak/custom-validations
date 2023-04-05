package com.form.validationdemo.model;

import com.form.validationdemo.validator.ValidDate;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Form {

    @NotEmpty
    @Size(max = 10)
    private String firstName;

    @NotNull(message = "mandatory")
    @Size(max = 10)
    private String middleName;

    @NotEmpty
    @Size(max = 10)
    private String lastName;

    @ValidDate(allowEmpty = true)
    private String dateOfBirth;

    private Integer age;

}
