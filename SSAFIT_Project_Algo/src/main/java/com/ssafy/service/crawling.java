package com.ssafy.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import com.ssafy.mvc.dto.BTC;

public class crawling {
    public static List<BTC> search(String N) {
        List<BTC> list = new ArrayList<>();
        try {
            String URL = "https://colory.mooo.com/catalogue";
            Document doc = Jsoup.connect(URL).get();
            for (int i = 1; i <= 159; i++) {
                String levelSelector = "#theme-button-1 > table > tbody > tr:nth-child(" + i + ") > td.info-4";
                Elements level = doc.select(levelSelector);
                if (level.text().equals(N)) {
                    String nameSelector = "#theme-button-1 > table > tbody > tr:nth-child(" + i + ") > td.info-2";
                    Elements name = doc.select(nameSelector);
                    String gradeSelector = "#theme-button-1 > table > tbody > tr:nth-child(" + i + ") > td.info-3";
                    Elements grade = doc.select(gradeSelector);
                    String rvCntSelector = "#theme-button-1 > table > tbody > tr:nth-child(" + i + ") > td.info-5";
                    Elements rvCnt = doc.select(rvCntSelector);
                    String shopSelector = "#theme-button-1 > table > tbody > tr:nth-child(" + i + ") > td.info-1";
                    Elements shop = doc.select(shopSelector);
                    if (shop.text().equals("")) {
                        int idx = i;
                        while (shop.text().equals("")) {
                            idx--;
                            shopSelector = "#theme-button-1 > table > tbody > tr:nth-child(" + idx + ") > td.info-1";
                            shop = doc.select(shopSelector);
                        }
                    }
                    BTC btc = new BTC(shop.text(), name.text(), Integer.parseInt(level.text()), Integer.parseInt(rvCnt.text()), Double.parseDouble(grade.text()));
                    list.add(btc);
                }
            }
            Collections.sort(list);
        } catch (Exception e) {
            System.out.println("크롤링 실패 : " + e);
            e.printStackTrace();
        }
        return list;
    }
}
