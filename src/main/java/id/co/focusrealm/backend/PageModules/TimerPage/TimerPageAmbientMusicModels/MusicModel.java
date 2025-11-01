package id.co.focusrealm.backend.PageModules.TimerPage.TimerPageAmbientMusicModels;

import lombok.Data;

@Data
public class MusicModel {

    // Yang diperlukan dari Music
    private String music_id;
    private String music_title;
    private String music_file_name;
    private int music_duration;

}
