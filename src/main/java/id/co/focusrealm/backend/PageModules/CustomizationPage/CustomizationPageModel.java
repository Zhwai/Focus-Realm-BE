package id.co.focusrealm.backend.PageModules.CustomizationPage;

import id.co.focusrealm.backend.PageModules.CommonModels.CharacterSceneryModelPackage.ObtainedCharacterModel;
import id.co.focusrealm.backend.PageModules.CommonModels.CharacterSceneryModelPackage.ObtainedSceneryModel;
import id.co.focusrealm.backend.PageModules.CommonModels.CharacterSceneryModelPackage.UnobtainedCharacterModel;
import id.co.focusrealm.backend.PageModules.CommonModels.CharacterSceneryModelPackage.UnobtainedSceneryModel;
import lombok.Data;

import java.util.ArrayList;

@Data
public class CustomizationPageModel {

    private String user_id;
    private String newUsedCharacterId;
    private String newUsedSceneryId;

    private ObtainedCharacterModel currentlyUsedCharacter;
    private ObtainedSceneryModel currentlyUsedScenery;

    private ArrayList<UnobtainedCharacterModel> unobtainedCharacter;
    private ArrayList<UnobtainedSceneryModel>  unobtainedScenery;
    private ArrayList<ObtainedCharacterModel> obtainedCharacter;
    private ArrayList<ObtainedSceneryModel> obtainedScenery;

}
