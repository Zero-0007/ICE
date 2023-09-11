package com.cssl.icewkment.controller;


import com.cssl.icewkment.entity.DispositionCarousel;
import com.cssl.icewkment.entity.Setting;
import com.cssl.icewkment.mapper.DispositionCarouselMapper;
import com.cssl.icewkment.mapper.SettingMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@io.swagger.annotations.Api(tags = "Web设置接口")
@RestController
@RequestMapping("/WebSitting")
public class WebSettingController {

    @Autowired
    private DispositionCarouselMapper disposition_carouselMapper;

    @Autowired
    private SettingMapper settingMapper;

    @ApiOperation(value = "获取首页轮播图")
    @GetMapping("/getCarousel")
    public List<DispositionCarousel> getCarousel(

    ) {
        return this.disposition_carouselMapper.selectAll();
    }

    @ApiOperation(value = "获取所有设置")
    @GetMapping("/getSetting")
    public Setting getSetting(
    ) {
        return settingMapper.selectOne(null);
    }


}

