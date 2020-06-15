package com.booking.epam.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@ApiModel
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FullUserDto  extends UserDto implements Serializable {

    private static final long serialVersionUID = -5843439348357446061L;

    @ApiModelProperty(example = "4d562101-c393-4526-928b-f11bcc557333", required = true)
    private UUID id;
}
