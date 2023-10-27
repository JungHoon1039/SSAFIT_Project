package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.User;

public interface UserDao {
    User selectOne(String id);

    int insertUser(User user);

    public List<String> bookmarkSelectAll(String userId);

    public int bookmarkAdd(String userId, String youtubeId);

    public int bookmarkRemove(int id);

    List<String> followSelectAll(String userId);

    int followAdd(String userId, String followId);

    int followRemove(int id);

    List<String> followBookmarkSelectAll(String userId);
}