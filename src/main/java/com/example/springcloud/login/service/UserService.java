package com.example.springcloud.login.service;

import java.util.List;
import java.util.Map;

public interface UserService {

    List  selectAllUser(Map map)throws Exception;
}
