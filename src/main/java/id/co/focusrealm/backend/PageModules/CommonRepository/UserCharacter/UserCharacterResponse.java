package id.co.focusrealm.backend.PageModules.CommonRepository.UserCharacter;

import id.co.focusrealm.backend.CommonResponse.BaseResponse;
import lombok.Data;

@Data
public class UserCharacterResponse extends BaseResponse {
    UserCharacterModel userCharacterModel;
}
