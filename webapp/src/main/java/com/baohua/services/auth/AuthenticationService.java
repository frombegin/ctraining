package com.baohua.services.auth;

import com.baohua.common.account.Account;

/**
 *
 * @author $id$
 */
public interface AuthenticationService {

    public boolean authenticate(Account account, String password);
}
