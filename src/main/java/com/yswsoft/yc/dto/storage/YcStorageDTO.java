package com.yswsoft.yc.dto.storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: <br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yushengwei on 2020/1/7 19:47<br>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YcStorageDTO {
    String id;
    String year;
    String month;
    String title;
    String content;
    String docUrl;
}
