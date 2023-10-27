package com.ssafy.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ssafit-user")
@Api(tags = "유저 컨트롤러")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "유저 로그인", notes = "유저 로그인을 세션에 저장한다")
    public ResponseEntity<?> login(User user, HttpSession session) {
        User tmp = userService.login(user);
        if (tmp == null)
            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
        session.setAttribute("loginUser", tmp);
        return new ResponseEntity<User>(tmp, HttpStatus.OK);
    }

    @GetMapping("/logout")
    @ApiOperation(value = "유저 로그아웃", notes = "유저 로그인을 세션에서 삭제한다")
    public ResponseEntity<?> logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/signup")
    @ApiOperation(value = "유저 회원가입", notes = "유저를 등록한다")
    public ResponseEntity<?> signup(User user) {
        int result = userService.signup(user);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }

    @GetMapping("/bookmark/{userId}")
    @ApiOperation(value = "찜 전체 조회", notes = "특정 유저의 전체 찜을 조회한다")
    public ResponseEntity<?> bookmarkList(@PathVariable String userId) {
        List<String> list = userService.bookmarkSelectAll(userId);
        if (list == null || list.size() == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @PostMapping("/bookmark")
    @ApiOperation(value = "찜 등록", notes = "찜을 등록한다")
    public ResponseEntity<?> bookmarkAdd(String userId, String youtubeId) {
        int result = userService.bookmarkAdd(userId, youtubeId);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/bookmark/{id}")
    @ApiOperation(value = "찜 삭제", notes = "특정 찜을 삭제한다")
    public ResponseEntity<?> bookmarkRemove(@PathVariable int id) {
        int result = userService.bookmarkRemove(id);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @GetMapping("/follow/{userId}")
    @ApiOperation(value = "팔로우 전체 조회", notes = "특정 유저의 전체 팔로우를 조회한다")
    public ResponseEntity<?> followList(@PathVariable String userId) {
        List<String> list = userService.followSelectAll(userId);
        if (list == null || list.size() == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @PostMapping("/follow")
    @ApiOperation(value = "팔로우 등록", notes = "팔로우를 등록한다")
    public ResponseEntity<?> followAdd(String userId, String followId) {
        System.out.println(userId + " " + followId);
        int result = userService.followAdd(userId, followId);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/follow/{id}")
    @ApiOperation(value = "팔로우 삭제", notes = "특정 팔로우를 삭제한다")
    public ResponseEntity<?> followRemove(@PathVariable int id) {
        int result = userService.followRemove(id);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @GetMapping("/followBookmark/{userId}")
    @ApiOperation(value = "팔로우한 회원들이 찜한 영상 조회", notes = "특정 유저가 팔로우한 회원들의 찜한 영상을 조회한다")
    public ResponseEntity<?> followBookmarkList(@PathVariable String userId) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> followList = userService.followSelectAll(userId);
        for (String followId : followList) {
            List<String> bookmarkList = userService.bookmarkSelectAll(followId);
            map.put(followId, bookmarkList);
        }
        System.out.println(map.toString());
        if (map == null || map.size() == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<Map<String, List<String>>>(map, HttpStatus.OK);
    }

}