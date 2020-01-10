package com.yswsoft.yc.api;

import com.alibaba.fastjson.JSONObject;
import com.yswsoft.yc.dto.storage.YcStorageDTO;

/**
 * Description: <br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yushengwei on 2020/1/7 20:07<br>
 */
public interface CrawlService {

    //爬取数据
    YcStorageDTO crawl(String url);

    void main();


}
