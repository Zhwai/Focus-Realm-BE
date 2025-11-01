package id.co.focusrealm.backend.PageModules.TimerPage;

import id.co.focusrealm.backend.PageModules.TimerPage.TimerPageAmbientMusicModels.AmbientModel;
import id.co.focusrealm.backend.PageModules.TimerPage.TimerPageAmbientMusicModels.MusicModel;
import lombok.Data;

import java.util.ArrayList;

@Data
public class TimerPageModel {

    // Yang diperlukan dari database User
    private String user_id;

    // Yang diperlukan dari UserScenery
    private String scenery_id;
    private String scenery_name;
    private String scenery_file_name;

    // Yang diperlukan dari UserCharacter
    private String character_id;
    private String character_name;
    private String character_file_name;

    // Yang diperlukan dari Music (Default User Music)
    private MusicModel currentMusicModel;

    // Yang diperlukan dari Ambient (Default User Ambient)
    private AmbientModel currentAmbientModel;

    // All Music
    private ArrayList<MusicModel> allMusicList;

    // All Ambients
    private ArrayList<AmbientModel> allAmbientList;
}
