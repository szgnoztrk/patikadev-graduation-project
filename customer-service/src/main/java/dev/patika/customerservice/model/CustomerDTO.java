package dev.patika.customerservice.model;

import dev.patika.customerservice.model.enums.Gender;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    @ApiModelProperty(example = "Sezgin Öztürk")
    @NotBlank
    private String fullName;
    @ApiModelProperty(example = "29776973134")
    @Length(min = 11, max = 11)
    @NotBlank
    private String ssid;
    @ApiModelProperty(example = "szgnoztrk@gmail.com")
    @Email
    @NotBlank
    private String email;
    @ApiModelProperty(example = "905343697677")
    @NotBlank
    private String phone;
    @ApiModelProperty(example = "5000")
    @NotNull
    private double salary;
    @ApiModelProperty(example = "MALE OR FEMALE")
    @NotNull
    private Gender gender;
}
