package id.co.focusrealm.backend.DataBaseModules.Analytics;

import id.co.focusrealm.backend.CommonResponse.BaseResponse;
import lombok.Data;

@Data
public class AnalyticsResponse extends BaseResponse {
    private  AnalyticsModel analyticsModel;
}
