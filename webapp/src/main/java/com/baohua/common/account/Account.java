package com.baohua.common.account;

/**
 *
 * @author $Id$
 */
public class Account {

    private final AccountType type;
    private final String identity;

    public Account() {
        this(AccountType.email, "");
    }

    public Account(AccountType type, String identity) {
        this.type = type;
        this.identity = identity;
    }

    public boolean equals(Account other) {
        return this.type == other.type && this.identity.equals(other.identity);
    }

    @Override
    public String toString() {
        return this.type.name() + this.identity;
    }

}
