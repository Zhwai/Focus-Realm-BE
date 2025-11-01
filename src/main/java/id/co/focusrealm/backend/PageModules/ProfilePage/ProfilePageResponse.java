package id.co.focusrealm.backend.PageModules.ProfilePage;

import id.co.focusrealm.backend.CommonResponse.BaseResponse;
import lombok.Data;

@Data
public class ProfilePageResponse extends BaseResponse {
    private ProfilePageModel profilePageModel;
}
