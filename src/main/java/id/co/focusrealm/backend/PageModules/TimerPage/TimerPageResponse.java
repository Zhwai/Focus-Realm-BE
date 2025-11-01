package id.co.focusrealm.backend.PageModules.TimerPage;

import id.co.focusrealm.backend.CommonResponse.BaseResponse;
import lombok.Data;

@Data
public class TimerPageResponse extends BaseResponse {
    private TimerPageModel timerPageModel;
}
