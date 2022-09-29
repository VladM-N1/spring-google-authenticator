package com.vladm.googleauthdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class ValidateCodeDto {
    private Integer code;
    private String username;
}
