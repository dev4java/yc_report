package com.yswsoft.yc.impl.crawl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yswsoft.yc.api.CrawlService;
import com.yswsoft.yc.dto.crawl.WebContentDTO;
import com.yswsoft.yc.dto.crawl.WebMenuDTO;
import com.yswsoft.yc.dto.storage.YcEconomicDTO;
import com.yswsoft.yc.dto.storage.YcStorageDTO;
import com.yswsoft.yc.util.HttpClientUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Description: <br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yushengwei on 2020/1/7 20:08<br>
 */
@Service
public class CrawlServiceImpl implements CrawlService {

    @Autowired
    public RedisTemplate<String, Object> redisTemplate;


    @Override
    public YcStorageDTO crawl(String url) {
        String response = HttpClientUtil.getInstance().sendHttpGet(url);
        if(null == response){
            return null;
        }
        String year  = null;
        String month = null;
        String html = response.substring(response.indexOf("{"),response.lastIndexOf("}")+1);
        JSONObject json = JSONObject.parseObject(html);
        String content = json.getString("content");
        String fujian  = json.getString("fujian");
        String title   = json.getString("title");
        if(StringUtils.isNoneBlank(title)){
            year  = title.substring(0,title.indexOf("年"));
            month = title.substring(title.indexOf("年")+1,title.indexOf("月"));
        }

        //redis hash存储
        YcStorageDTO yc = YcStorageDTO
                .builder()
                .id(UUID.randomUUID().toString().replace("-",""))
                .title(title)
                .year(year)
                .month(month)
                .content(content)
                .docUrl(fujian)
                .build();
        return yc;
    }

    @Override
    public void main() {
        String url = "https://xxgkapi.yichang.gov.cn/show/detail?jsoncallback=jQuery112402094835571008744_1578390982787&areaid=1&id=196881&cache=on&_=1578390982788";
        YcStorageDTO yc = crawl(url);
        if(null == yc){
            return;
        }
        htmlAnalysis(null,yc.getContent());
    }

    public static void main(String[] args) {
        String url = "https://xxgkapi.yichang.gov.cn/show/detail?jsoncallback=jQuery112402094835571008744_1578390982787&areaid=1&id=196881&cache=on&_=1578390982788";
        CrawlServiceImpl crawlService = new CrawlServiceImpl();
        YcStorageDTO yc = crawlService.crawl(url);
        if(null == yc){
            return;
        }
        String dateTime = yc.getYear()+yc.getMonth();
        crawlService.htmlAnalysis(dateTime,yc.getContent());
    }

    public void htmlAnalysis(String dateTime,String html){
        try {
            Document document = Jsoup.parse(html);
            Elements hang     = document.select("table").select("tr");
            StringBuilder sb  = new StringBuilder();
            int rows = hang.size();
            for (int i = 1; i < rows; i++) {
                Elements lie = hang.get(i).select("td");
                int lines = lie.size();
                sb.append(dateTime);
                for(int j = 0;j < lines;j++) {
                    String texts = lie.get(j).text();
                    System.out.print(" "+texts);
                    sb.append(" " + texts );
                }
                sb.append("\n");
                System.out.println(sb.toString());
            }
            FileUtils.writeStringToFile(new File("D:\\yc\\test.txt"),sb.toString(),"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
