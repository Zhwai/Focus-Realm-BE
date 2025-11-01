package id.co.focusrealm.backend.DataBaseModules.Analytics;

import id.co.focusrealm.backend.CommonFunctions.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AnalyticsService {

    @Autowired
    private AnalyticsRepository analyticsRepository;

    public void insertAnalytics(AnalyticsModel analyticsModel){

        try {

            analyticsModel.setAnalytics_id(generateAnalyticsId());
            analyticsRepository.insertAnalytics(analyticsModel);

        } catch (Exception e) {
            log.error("Error at AnalyticsService insertAnalytics", e);
            throw new RuntimeException(e);
        }

    }

    public String generateAnalyticsId(){
        String newAnalyticsId = null;

        try {

            if(analyticsRepository.checkHasValue() == false){
                newAnalyticsId = "AN001";
            } else {
                String lastAnalyticsId = analyticsRepository.getLastAnalyticsId();
                newAnalyticsId = Utility.generateNextId(lastAnalyticsId);
            }

        } catch (Exception e) {
            log.error("Error at AnalyticsService generateAnalyticsId");
            throw new RuntimeException(e);
        }

        return newAnalyticsId;
    }
}
