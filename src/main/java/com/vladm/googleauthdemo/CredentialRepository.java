package com.vladm.googleauthdemo;

import com.warrenstrange.googleauth.ICredentialRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CredentialRepository implements ICredentialRepository {

    private final Map<String, UserTOTP> usersKeys = new HashMap<String, UserTOTP>() {{
        put("kek@kek.com", null);
        put("alice@gmail.com", null);
    }};

    @Override
    public String getSecretKey(String userName) {
        return usersKeys.get(userName).getSecretKey();
    }

    @Override
    public void saveUserCredentials(String userName,
                                    String secretKey,
                                    int validationCode,
                                    List<Integer> scratchCodes) {
        usersKeys.put(userName, new UserTOTP(userName, secretKey, validationCode, scratchCodes));
    }

    public UserTOTP getUser(String username) {
        return usersKeys.get(username);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class UserTOTP {
        private String username;
        private String secretKey;
        private int validationCode;
        private List<Integer> scratchCodes;
    }
}
