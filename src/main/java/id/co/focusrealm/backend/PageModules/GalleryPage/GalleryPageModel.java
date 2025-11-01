package id.co.focusrealm.backend.PageModules.GalleryPage;

import id.co.focusrealm.backend.PageModules.CommonModels.CharacterSceneryModelPackage.ObtainedCharacterModel;
import id.co.focusrealm.backend.PageModules.CommonModels.CharacterSceneryModelPackage.ObtainedSceneryModel;
import id.co.focusrealm.backend.PageModules.CommonModels.CharacterSceneryModelPackage.UnobtainedCharacterModel;
import id.co.focusrealm.backend.PageModules.CommonModels.CharacterSceneryModelPackage.UnobtainedSceneryModel;
import lombok.Data;

import java.util.ArrayList;

@Data
public class GalleryPageModel {

    private String user_id;

    private ArrayList<UnobtainedCharacterModel> unobtainedCharacter;
    private ArrayList<UnobtainedSceneryModel>  unobtainedScenery;
    private ArrayList<ObtainedCharacterModel> obtainedCharacter;
    private ArrayList<ObtainedSceneryModel> obtainedScenery;

}
