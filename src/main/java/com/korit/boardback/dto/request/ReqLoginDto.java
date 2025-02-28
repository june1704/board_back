package com.korit.boardback.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "로그인 정보 DTO")
public class ReqLoginDto {
    @Schema(description = "사용자 이름")
    private String username;
    @Schema(description = "비밀번호")
    private String password;
}
