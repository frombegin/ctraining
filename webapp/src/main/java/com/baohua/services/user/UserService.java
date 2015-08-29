package com.baohua.services.user;

import com.baohua.common.account.Account;
import java.util.Map;

/**
 *
 * @author $id$
 */
public interface UserService {

    User registerUser(Account account, String password, String promotionCode);

    User getUser(int userId);
    
    User getUserByAccount(Account account);

    void resetPassword(int userId, String password, String newPassword);
    
    void updateUser(int userId, Map<String, Object> values);
}
