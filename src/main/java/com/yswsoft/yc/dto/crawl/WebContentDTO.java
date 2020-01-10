package com.yswsoft.yc.dto.crawl;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Description: <br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yushengwei on 2020/1/7 18:11<br>
 */
@Data
public class WebContentDTO implements Serializable {
    String n_id;//: "196881",
    String m_webid;//: "877",
    String m_cateid;//: "152",
    String title;//: "2019年11月全市主要经济指标",
    String orders;//: "0",
    String vc_number;//: "011100314/2020-00002",
    String vc_fielid;//: "",
    String vc_gid;//: "14",
    String vc_ztfl;//: "统计,经济建设",
    String vc_department;//: "宜昌市统计局",
    String vc_classes;//: "综合科",
    String vc_opentype;//: "主动公开",
    String vc_opentimetype;//: "长期公开",
    String vc_begintime;//: "",
    String vc_endtime;//: "长期公开",
    String vc_orders;//: "2",
    String vc_inputtime;//: "2020-01-02 14:32:26",
    String vc_editor;//"4779",
    String status;//"3",
    String createtime;//"2020-01-02 14:34:56",
    String del_status;//"0",
    String sort;//"0",
    String fujian;//"http://img.xxgk.yichang.gov.cn/image/20200102/e012272578c64721e797107b99b0189b.docx",
    String fujian_sh;// "",
    String dl;//"1",
    String content;
    String deptname;//"市统计局",
    String keywords;
    List<WebMenuDTO> menu;
}
