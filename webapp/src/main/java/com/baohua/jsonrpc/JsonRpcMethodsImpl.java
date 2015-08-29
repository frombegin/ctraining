package com.baohua.jsonrpc;


public class JsonRpcMethodsImpl implements JsonRpcMethods {

    @Override
    public int user_register(String name, String password) {
        return (name + password).length();
    }
    
}
