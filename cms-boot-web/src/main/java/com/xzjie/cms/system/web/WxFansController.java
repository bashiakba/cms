package com.xzjie.cms.system.web;

import com.xzjie.cms.core.utils.MapUtils;
import com.xzjie.cms.wechat.dto.WxAccountFansDto;
import com.xzjie.cms.wechat.model.WxAccountFans;
import com.xzjie.cms.wechat.service.WxAccountFansService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/wx-fans")
@Api(value = "管理端-微信公众号粉丝管理",tags = "管理端-微信公众号粉丝管理")
public class WxFansController {

    @Autowired
    private WxAccountFansService accountFansService;

    @GetMapping(value = "/list")
    public Map<String, Object> articleList(WxAccountFansDto fans) {
        Page<WxAccountFans> accountFansPage = accountFansService.getAccountFans(fans.getPage(), fans.getSize(), fans.toAccountFans(), fans.getTagId());
        return MapUtils.success(accountFansPage.getContent(), accountFansPage.getTotalElements());
    }

    @GetMapping(value = "/data")
//    @PreAuthorize("hasAuthority('user')")
    public Map<String, Object> getAccountFansList(WxAccountFansDto fans) {
        List<WxAccountFans> accountFans = accountFansService.getAccountFans(fans.toAccountFans());
        return MapUtils.success(accountFans);
    }

    @PostMapping(value = "sync")
    public Map<String, Object> syncAccountFans() {
        accountFansService.syncAccountFans("");
        return MapUtils.success();
    }

    @PostMapping(value = "send/message")
    public Map<String, Object> sendMessage() {
        return MapUtils.success();
    }

    @DeleteMapping(value = "/delete/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        accountFansService.delete(id);
        return MapUtils.success();
    }
}
