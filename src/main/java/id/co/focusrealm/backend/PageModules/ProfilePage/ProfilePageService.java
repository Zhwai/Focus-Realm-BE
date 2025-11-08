package id.co.focusrealm.backend.PageModules.ProfilePage;

import id.co.focusrealm.backend.CommonFunctions.Utility;
import id.co.focusrealm.backend.DataBaseModules.Analytics.AnalyticsRepository;
import id.co.focusrealm.backend.DataBaseModules.FocusSession.FocusSessionRepository;
import id.co.focusrealm.backend.PageModules.LoginPage.LoginPageRepository;
import id.co.focusrealm.backend.PageModules.LoginPage.LoginPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProfilePageService {

    @Autowired
    private ProfilePageRepository profilePageRepository;

    @Autowired
    private AnalyticsRepository analyticsRepository;

    @Autowired
    private FocusSessionRepository focusSessionRepository;

    @Autowired
    private LoginPageRepository loginPageRepository;

    @Autowired
    private LoginPageService loginPageService;

    @Autowired
    private Utility utility;

    public ProfilePageResponse fetchProfilePageData(ProfilePageModel profilePageModel){

        ProfilePageResponse profilePageResponse = new ProfilePageResponse();

        try {
            ProfilePageModel temporary = profilePageRepository.fetchUserData(profilePageModel);
            profilePageModel.setUsername(temporary.getUsername());
            profilePageModel.setEmail(temporary.getEmail());
            profilePageModel.setProfile_picture_file_name(temporary.getProfile_picture_file_name());

            profilePageModel.setAllTimeUserStatistics(analyticsRepository.fetchAnalyticsDataByUserId(profilePageModel.getUser_id()));
            profilePageModel.setAllUserFocusSessionList(focusSessionRepository.fetchAllFocusSession(profilePageModel.getUser_id(), profilePageModel.getAllTimeUserStatistics().getAnalytics_id()));

            profilePageResponse.setErrorCode("200");
            profilePageResponse.setErrorMessage("SUCCESS");

            profilePageResponse.setProfilePageModel(profilePageModel);
            return profilePageResponse;

        } catch (Exception e) {
            profilePageResponse.setErrorCode("400");
            profilePageResponse.setErrorMessage("ERROR");
            log.error("ERROR AT ProfilePageService, fetchProfilePageData");
            throw new RuntimeException(e);
        }
    }

    public ProfilePageResponse changeUserName(ProfilePageModel profilePageModel){

        ProfilePageResponse profilePageResponse = new ProfilePageResponse();

        try {

            boolean checkUserNameTaken = loginPageRepository.checkUserNameExists(profilePageModel.getUsername());
            if(checkUserNameTaken == true) {
                profilePageResponse.setProfilePageModel(profilePageModel);
                profilePageResponse.setErrorCode("400");
                profilePageResponse.setErrorMessage("USERNAME TAKEN");
                return profilePageResponse;
            }

            profilePageRepository.updateUserName(profilePageModel);
            fetchProfilePageData(profilePageModel);

            profilePageResponse.setErrorCode("200");
            profilePageResponse.setErrorMessage("SUCCESS");
            profilePageResponse.setProfilePageModel(profilePageModel);

            return profilePageResponse;

        } catch (Exception e) {
            profilePageResponse.setErrorCode("400");
            profilePageResponse.setErrorMessage("ERROR AT CHANGING USERNAME");
            log.error("ERROR AT ProfilePageService, changeUserName");
            throw new RuntimeException(e);
        }
    }

    public ProfilePageResponse changePassword(ProfilePageModel profilePageModel){

        ProfilePageResponse profilePageResponse = new ProfilePageResponse();

        try {

            if(loginPageRepository.checkUserNameExists(profilePageModel.getUsername()) == false){
                profilePageResponse.setErrorCode("204");
                profilePageResponse.setErrorMessage("User Not Found");
            } else if (loginPageService.checkPasswordCorrect(profilePageModel.getUsername(), profilePageModel.getOld_password()) == false){
                profilePageResponse.setErrorCode("204");
                profilePageResponse.setErrorMessage("Wrong Password");
            } else {
                String hashedPassword = utility.passwordEncoder().encode(profilePageModel.getNew_password());
                profilePageModel.setNew_password(hashedPassword);

                profilePageRepository.updateUserPassword(profilePageModel);
                fetchProfilePageData(profilePageModel);

                profilePageResponse.setErrorCode("200");
                profilePageResponse.setErrorMessage("SUCCESS");
                profilePageResponse.setProfilePageModel(profilePageModel);
            }

            return profilePageResponse;

        } catch (Exception e) {
            profilePageResponse.setErrorCode("400");
            profilePageResponse.setErrorMessage("ERROR AT CHANGING PASSWORD");
            log.error("ERROR AT ProfilePageService, changeUserName");
            throw new RuntimeException(e);
        }
    }

    public ProfilePageResponse changeEmail(ProfilePageModel profilePageModel){

        ProfilePageResponse profilePageResponse = new ProfilePageResponse();

        try {

            boolean checkEmailTaken = loginPageRepository.checkEmailTaken(profilePageModel.getEmail());
            if(checkEmailTaken == true){
                profilePageResponse.setProfilePageModel(profilePageModel);
                profilePageResponse.setErrorCode("400");
                profilePageResponse.setErrorMessage("EMAIL TAKEN");
                return profilePageResponse;
            }

            profilePageRepository.updateEmail(profilePageModel);
            fetchProfilePageData(profilePageModel);

            profilePageResponse.setErrorCode("200");
            profilePageResponse.setErrorMessage("SUCCESS");
            profilePageResponse.setProfilePageModel(profilePageModel);

            return profilePageResponse;

        } catch (Exception e) {
            profilePageResponse.setErrorCode("400");
            profilePageResponse.setErrorMessage("ERROR AT CHANGING PASSWORD");
            log.error("ERROR AT ProfilePageService, changeUserName");
            throw new RuntimeException(e);
        }
    }

}
