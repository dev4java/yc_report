package com.yswsoft.yc.dto.storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description: <br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yushengwei on 2020/1/8 12:08<br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class YcEconomicDTO implements Serializable {
    String id;
    String name;
    String unit;
    String val;
    String speed;
}
