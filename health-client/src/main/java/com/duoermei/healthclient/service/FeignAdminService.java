package com.duoermei.healthclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author GoldFu
 * @Date 2019/8/16
 * @Version V1.0
 **/
@FeignClient(value = "health-manage")
public interface FeignAdminService {
    @RequestMapping("/admin/name")
    Object findAdminByNickName(@RequestParam(value = "name", required = false) String name);
}
