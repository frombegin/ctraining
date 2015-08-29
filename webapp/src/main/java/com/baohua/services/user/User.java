package com.baohua.services.user;

import com.baohua.common.account.Account;
import java.util.Date;

/**
 *
 * @author $Id$
 */
public class User {

    private int Id;
    private Account account;
    private String name;
    private Date createdAt;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" + "Id=" + Id + ", name=" + name + '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
