package vn.scrip.buoi21.service;

import vn.scrip.buoi21.entity.User;

public interface UserService {
    User findByUsername(String username);
}
