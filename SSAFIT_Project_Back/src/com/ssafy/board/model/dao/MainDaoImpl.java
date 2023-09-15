package com.ssafy.board.model.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ssafy.board.model.dto.Video;

public class MainDaoImpl implements MainDao {

    private static MainDao instance;

    private static List<Video> list;

    private MainDaoImpl() {
        list = new ArrayList<Video>();
        list.add(new Video("전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]", "전신", "gMaB-fG4u4g", "ThankyouBUBU"));
        list.add(new Video("하루 15분! 전신 칼로리 불태우는 다이어트 운동", "전신", "swRNeYw1JkY", "ThankyouBUBU"));
        list.add(new Video("상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]", "상체", "54tTYO-vU2E", "ThankyouBUBU"));
        list.add(new Video("상체비만 다이어트 최고의 운동 [상체 핵매운맛]", "상체", "QqqZH3j_vH0", "ThankyouBUBU"));
        list.add(new Video("하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]", "하체", "tzN6ypk6Sps", "김강민"));
        list.add(new Video("저는 하체 식주의자 입니다", "하체", "u5OgcZdNbMo", "GYM종국"));
        list.add(new Video("11자복근 복부 최고의 운동 [복근 핵매운맛]", "복부", "PjGcOP-TQPE", "ThankyouBUBU"));
        list.add(new Video("(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)", "복부", "7TLk7pscICk", "SomiFit"));
    }

    public static List<Video> selectVideoAll() {
        return list;
    }

    public static MainDao getInstance() {
        if (instance == null) {
            instance = new MainDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Video> selectInterestViewFitVideo() {
        List<Video> videoList = new ArrayList<>(list);
        Collections.sort(videoList, new ListComparator());
        return videoList;

    }

    class ListComparator implements Comparator<Video> {
        @Override
        public int compare(Video v1, Video v2) {
            int vcnt1 = v1.getViewCnt();
            int vcnt2 = v2.getViewCnt();
            if (vcnt1 > vcnt2) {
                return -1;
            } else if (vcnt1 < vcnt2) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public List<Video> selectPartFitVideo(String part) {
        List<Video> videoList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFitPartName().equals(part)) {
                videoList.add(list.get(i));
            }
        }
        return videoList;
    }

}
