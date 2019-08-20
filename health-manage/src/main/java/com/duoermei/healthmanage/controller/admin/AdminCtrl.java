package com.duoermei.healthmanage.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.duoermei.healthmanage.RespStatus;
import com.duoermei.healthmanage.model.AdminInfo;
import com.duoermei.healthmanage.security.JwtTokenHelper;
import com.duoermei.healthmanage.security.JwtUserFactory;
import com.duoermei.healthmanage.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Description: 管理员入口
 * @Author GoldFu
 * @Date 2019/7/29
 * @Version V1.0
 **/

@RestController
@RequestMapping("admin/")
public class AdminCtrl {
    @Resource
    private AdminInfoService adminInfoService;
    @Autowired
    private EntityManager entityManager;


    @PostMapping("/login")
    public JSONObject login(@Valid @RequestBody AdminInfo request) {
        AdminInfo admin = null;
        if (!StringUtils.isEmpty(request.getPhone())) {
            admin = adminInfoService.findAdminByPhoneAndPassword(request.getPhone(), request.getPassword());
        }
        if (Objects.isNull(admin)) {
            return RespStatus.fail("账号或密码错误");
        }
        String token = JwtTokenHelper.generateToken(JwtUserFactory.create(admin));
        return RespStatus.success(ResponseEntity.ok().header("Authorization", "Bearer " + token).body(admin));
    }

    @GetMapping("get")
    public JSONObject findAdminByAdminId(String adminId) {
        AdminInfo admin = adminInfoService.findAdminByAdminId(adminId);

        if (Objects.isNull(admin)) {
            return RespStatus.fail("查询有误");
        }
        return RespStatus.success(admin);
    }


    @GetMapping("name")
    public JSONObject findAdminByNickName(@RequestParam(value = "name", required = false) String  name) {
        AdminInfo admin = adminInfoService.findAdminByNickName(name);
        if (Objects.isNull(admin)) {
            return RespStatus.fail("查询有误");
        }
        return RespStatus.success(admin);
    }

    @GetMapping("adds")
    public JSONObject adds() {
        AdminInfo aaa = new AdminInfo();
        aaa.setAdminId("123");
        aaa.setPhone("123");
        aaa.setPassword("123");
        AdminInfo admins = entityManager.merge(aaa);
        System.out.println(admins);
        return RespStatus.success(admins);
    }

    @PostMapping("add")
    public JSONObject addAdmin(@Valid @RequestBody AdminInfo adminRequest) {
        AdminInfo admin;
        if (!StringUtils.isEmpty(adminRequest.getAdminId())) {
            admin = adminInfoService.findAdminByAdminId(adminRequest.getAdminId());

        } else {
            admin = new AdminInfo();
            if (!Objects.isNull(adminInfoService.findAdminByPhoneAndIsDelete(adminRequest.getPhone()))) {
                return RespStatus.fail("该手机号已存在了");
            }
            AdminInfo admins = entityManager.merge(adminRequest);
        }

        admin.setPassword(adminRequest.getPassword());
        admin.setJobNumber(adminRequest.getJobNumber());
        admin.setNickName(adminRequest.getNickName());
        admin.setRealName(adminRequest.getRealName());
        admin.setPhone(adminRequest.getPhone());
        admin.setMailbox(adminRequest.getMailbox());
        admin.setAvatar(adminRequest.getAvatar());
        // admin.setSex(adminRequest.getSex());
        admin.setPosition(adminRequest.getPosition());
        admin.setCompanyId(adminRequest.getCompanyId());
        admin.setDepartmentId(adminRequest.getDepartmentId());
        admin.setInviteAdminId(adminRequest.getInviteAdminId());
        admin.setPrivilegeLevel(adminRequest.getPrivilegeLevel());
        admin.setRoleId(adminRequest.getRoleId());
        admin.setIntroduction(adminRequest.getIntroduction());
        // admin.setRecommend(adminRequest.getRecommend());
        admin.setDetail(adminRequest.getDetail());
        return RespStatus.success(adminInfoService.addAdmin(admin));
    }

    @GetMapping("del")
    public JSONObject delAdmin(String[] adminId) {
        List<String> list = new ArrayList<>();
        for (String id : adminId) {
            AdminInfo admin = adminInfoService.delAdmin(id);
            if (!Objects.isNull(admin)) {
                list.add(admin.getNickName());
            }
        }
        return RespStatus.success(list);
    }

    public static void main(String[] args) {

    }

}
