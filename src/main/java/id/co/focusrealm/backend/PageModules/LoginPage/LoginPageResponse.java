package id.co.focusrealm.backend.PageModules.LoginPage;

import id.co.focusrealm.backend.CommonResponse.BaseResponse;
import lombok.Data;

@Data
public class LoginPageResponse extends BaseResponse {
    private LoginPageModel user;
}
