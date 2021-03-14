package com.example.interfaces.impl;

import com.example.interfaces.TokenService;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


@Service
public class TokenServiceImpl implements TokenService {
    
    @Autowired
    private RedisUtil redisUtil;

    public String createToken() {
        String uuid = UUID.randomUUID().toString();
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("token-").append(uuid);
            redisUtil.set(sb.toString(), sb.toString());
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkToken(HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        if (redisUtil.exists(token)) {
            return true;
        }
        return false;
    }
}
