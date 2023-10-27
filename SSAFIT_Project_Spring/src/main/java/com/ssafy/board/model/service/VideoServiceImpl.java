package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.dao.VideoDao;
import com.ssafy.board.model.dto.Review;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {

    private VideoDao videoDao;

    @Autowired
    public void setBoardDao(VideoDao boardDao) {
        this.videoDao = boardDao;
    }

    @Override
    public List<Video> search(SearchCondition condition) {
        return videoDao.search(condition);
    }

    @Override
    public List<Review> reviewSelectAll(String youtubeId) {
        return videoDao.reviewSelectAll(youtubeId);
    }

    @Override
    public Review reviewSelect(int id) {
        return videoDao.reviewSelect(id);
    }

    @Transactional
    @Override
    public int reviewAdd(Review review) {
        return videoDao.reviewAdd(review);
    }

    @Transactional
    @Override
    public int reviewModify(Review review) {
        return videoDao.reviewModify(review);
    }

    @Transactional
    @Override
    public int reviewRemove(int id) {
        return videoDao.reviewRemove(id);
    }

}
