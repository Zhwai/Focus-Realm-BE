package id.co.focusrealm.backend.PageModules.GachaPage;

import id.co.focusrealm.backend.PageModules.GachaPage.GachaCharacterSceneryModel.CharacterModel;
import id.co.focusrealm.backend.PageModules.GachaPage.GachaCharacterSceneryModel.SceneryModel;
import id.co.focusrealm.backend.PageModules.GachaPage.HistoryModels.CharacterHistoryModel;
import id.co.focusrealm.backend.PageModules.GachaPage.HistoryModels.SceneryHistoryModel;
import lombok.Data;

import java.util.ArrayList;

@Data
public class GachaModel {

    private String user_id;
    private int user_coins;
    private int user_pity;

    private int gacha_amount;

    private CharacterModel currentCharacterBanner;
    private SceneryModel currentSceneryBanner;

    private ArrayList<CharacterHistoryModel> characterHistoryModels;
    private ArrayList<SceneryHistoryModel> sceneryHistoryModels;

    private ArrayList<CharacterModel> obtainedCharacter;
    private ArrayList<SceneryModel> obtainedScenery;

}
