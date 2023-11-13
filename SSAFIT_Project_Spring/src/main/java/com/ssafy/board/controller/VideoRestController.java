package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Review;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.dto.Video;
import com.ssafy.board.model.service.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/ssafit")
@Api(tags = "게시판 컨트롤러")
public class VideoRestController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/video")
    @ApiOperation(value = "영상 조회", notes = "검색조건 삽입 가능")
    public ResponseEntity<?> list(SearchCondition condition) {
        List<Video> list = videoService.search(condition);
        if (list == null || list.size() == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
    }

    @GetMapping("/review/{youtubeId}")
    @ApiOperation(value = "댓글 전체 조회", notes = "특정 영상의 전체 댓글을 조회한다")
    public ResponseEntity<?> reviewList(@PathVariable String youtubeId) {
        List<Review> list = videoService.reviewSelectAll(youtubeId);
        if (list == null || list.size() == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
    }

    @GetMapping("/review/detail/{id}")
    @ApiOperation(value = "댓글 상세 조회", notes = "특정 댓글 하나를 조회한다")
    public ResponseEntity<?> reviewDetail(@PathVariable int id) {
        Review review = videoService.reviewSelect(id);
        if (review == null)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<Review>(review, HttpStatus.OK);
    }

    @PostMapping("/review")
    @ApiOperation(value = "댓글 등록", notes = "댓글을 등록한다")
    public ResponseEntity<?> reviewAdd(Review review) {
        int result = videoService.reviewAdd(review);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }

    @PutMapping("/review")
    @ApiOperation(value = "댓글 수정", notes = "특정 댓글 하나를 수정한다")
    public ResponseEntity<?> reviewUpdate(Review review) {
        int result = videoService.reviewModify(review);
        System.out.println(review.toString());
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @DeleteMapping("/review/{id}")
    @ApiOperation(value = "댓글 삭제", notes = "특정 댓글 하나를 삭제한다")
    public ResponseEntity<?> reviewDelete(@PathVariable int id) {
        int result = videoService.reviewRemove(id);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }
}
