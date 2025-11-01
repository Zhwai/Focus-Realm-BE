package id.co.focusrealm.backend.PageModules.LoginPage;

import id.co.focusrealm.backend.DataBaseModules.Analytics.AnalyticsModel;
import id.co.focusrealm.backend.DataBaseModules.Analytics.AnalyticsService;
import id.co.focusrealm.backend.CommonFunctions.Utility;
import id.co.focusrealm.backend.PageModules.CommonRepository.UserCharacter.UserCharacterModel;
import id.co.focusrealm.backend.PageModules.CommonRepository.UserCharacter.UserCharacterRepository;
import id.co.focusrealm.backend.PageModules.CommonRepository.UserCharacter.UserCharacterService;
import id.co.focusrealm.backend.PageModules.CommonRepository.UserScenery.UserSceneryModel;
import id.co.focusrealm.backend.PageModules.CommonRepository.UserScenery.UserSceneryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@Slf4j
public class LoginPageService {

    @Autowired
    private LoginPageRepository loginPageRepository;

    @Autowired
    private UserCharacterService  userCharacterService;

    @Autowired
    private UserSceneryService userSceneryService;

    @Autowired
    private AnalyticsService  analyticsService;

    private String defaultMusic = "M001";
    private String defaultAmbient = "A001";
    private String defaultCharacter = "CH001";
    private String defaultScenery = "SC001";
    private int defaultCoins = 0;
    private int defaultPity = 100;
    @Autowired
    private UserCharacterRepository userCharacterRepository;

    public LoginPageResponse insertUser(LoginPageModel user){
        LoginPageResponse loginPageResponse = new LoginPageResponse();

        try {

            if(loginPageRepository.checkUserNameExists(user.getUsername()) == true){
                loginPageResponse.setErrorCode("204");
                loginPageResponse.setErrorMessage("Username already exists");
            } else if (loginPageRepository.checkEmailTaken(user.getEmail()) == true){
                loginPageResponse.setErrorCode("204");
                loginPageResponse.setErrorMessage("Email already exists");
            } else {

                // Setting User Data
                user.setUser_Id(generateUserId());
                user.setMusic_Id(defaultMusic);
                user.setAmbient_Id(defaultAmbient);

                Date created_at = (new Timestamp(System.currentTimeMillis()));

                user.setCreated_at(created_at);
                user.setPity(defaultPity);
                user.setCoins(defaultCoins);

                loginPageRepository.insertUser(user);

                // Setting User Character Data
                UserCharacterModel userCharacterModel = new UserCharacterModel();
                userCharacterModel.setUser_id(user.getUser_Id());
                userCharacterModel.setCharacter_id(defaultCharacter);
                userCharacterModel.setAcquire_date(created_at);
                userCharacterModel.setChosen_character(true);
                userCharacterService.insertUserCharacter(userCharacterModel);

                // Setting User Scenery Data
                UserSceneryModel userSceneryModel = new UserSceneryModel();
                userSceneryModel.setUser_id(user.getUser_Id());
                userSceneryModel.setScenery_id(defaultScenery);
                userSceneryModel.setAcquire_date(created_at);
                userSceneryModel.setChosen_scenery(true);
                userSceneryService.insertUserScenery(userSceneryModel);

                // Setting User Analytics Data
                AnalyticsModel analyticsModel = new AnalyticsModel();
                analyticsModel.setUser_id(user.getUser_Id());
                analyticsModel.setTotal_focus_duration(0);
                analyticsModel.setTotal_focus_session(0);
                analyticsModel.setTotal_coins_made(0);
                analyticsService.insertAnalytics(analyticsModel);

                loginPageResponse.setUser(user);
                loginPageResponse.setErrorCode("200");
                loginPageResponse.setErrorMessage("Success");
            }

        } catch (Exception e) {
            log.error("Error at UserService.insertUser");
            loginPageResponse.setErrorCode("500");
            loginPageResponse.setErrorMessage("Error");

            throw new RuntimeException(e);
        }

        return loginPageResponse;
    }

    public String generateUserId(){
        String newUserId = null;

        try {

            if(loginPageRepository.checkHasValue() == false){
                newUserId = "U001";
            } else {
                String lastUserId = loginPageRepository.getLastUserId();
                newUserId = Utility.generateNextId(lastUserId);
            }

        } catch (Exception e) {
            log.error("Error at UserService.generateUserId");
            throw new RuntimeException(e);
        }

        return newUserId;
    }

    public LoginPageResponse fetchUser(LoginPageModel user){
          LoginPageResponse loginPageResponse = new LoginPageResponse();
          try {

              int getFetchUserCode = loginPageRepository.fetchUser(user);

              if(getFetchUserCode == 1){

                  loginPageResponse.setErrorCode("204");
                  loginPageResponse.setErrorMessage("User Not Found");

              } else if (getFetchUserCode == 2){

                  loginPageResponse.setErrorCode("204");
                  loginPageResponse.setErrorMessage("Wrong Password");

              } else if  (getFetchUserCode == 3){

                  loginPageResponse.setUser(user);
                  loginPageResponse.setErrorCode("200");
                  loginPageResponse.setErrorMessage("Success");

              }

          } catch (Exception e) {
              loginPageResponse.setErrorCode("500");
              loginPageResponse.setErrorMessage("Error");
              log.error("Error at UserService.fetchUser");
              throw new RuntimeException(e);
          }

          return loginPageResponse;
    }

}
