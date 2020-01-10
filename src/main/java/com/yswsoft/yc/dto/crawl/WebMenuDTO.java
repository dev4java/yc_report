package com.yswsoft.yc.dto.crawl;

import lombok.Data;

import java.io.Serializable;

/**
 * Description: <br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yushengwei on 2020/1/7 18:12<br>
 */
@Data
public class WebMenuDTO implements Serializable {
    String mname;
    String parentid;
}
