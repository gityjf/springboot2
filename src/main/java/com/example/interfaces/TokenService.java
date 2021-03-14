package com.example.interfaces;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {
    public String createToken();

    public boolean checkToken(HttpServletRequest request) throws Exception;
}
