package id.co.focusrealm.backend.CommonResponse;

import lombok.Data;

@Data
public class BaseResponse {
    private String errorCode;
    private String errorMessage;
}
