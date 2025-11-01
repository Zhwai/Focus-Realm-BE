package id.co.focusrealm.backend.DataBaseModules.FocusSession;

import id.co.focusrealm.backend.CommonResponse.BaseResponse;
import lombok.Data;

@Data
public class FocusSessionResponse extends BaseResponse {
    private FocusSessionModel focusSessionModel;
}
