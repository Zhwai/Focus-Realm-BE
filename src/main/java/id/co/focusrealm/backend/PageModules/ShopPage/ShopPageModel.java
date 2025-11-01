package id.co.focusrealm.backend.PageModules.ShopPage;

import id.co.focusrealm.backend.PageModules.CommonModels.CharacterSceneryModelPackage.ObtainedCharacterModel;
import id.co.focusrealm.backend.PageModules.CommonModels.CharacterSceneryModelPackage.ObtainedSceneryModel;
import id.co.focusrealm.backend.PageModules.CommonModels.CharacterSceneryModelPackage.UnobtainedCharacterModel;
import id.co.focusrealm.backend.PageModules.CommonModels.CharacterSceneryModelPackage.UnobtainedSceneryModel;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ShopPageModel {

    private String user_id;
    private String scenery_id;
    private String character_id;
    private int user_coins;

    private ArrayList<UnobtainedCharacterModel> unobtainedCharacter;
    private ArrayList<UnobtainedSceneryModel>  unobtainedScenery;
    private ArrayList<ObtainedCharacterModel> obtainedCharacter;
    private ArrayList<ObtainedSceneryModel> obtainedScenery;

}
