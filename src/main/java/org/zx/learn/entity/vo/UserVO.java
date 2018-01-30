package org.zx.learn.entity.vo;

import org.zx.learn.dto.SysResourceDTO;

import java.util.List;

/**
 * Created on 2017/12/27.
 *
 * @author zeng
 */
public class UserVO {

    private String sysRole;
    private String realName;
    private int age;
    private String sex;
    private String phoneNumber;
    private String address;
    private String accountName;
    private String accountPwd;
    private List<SysResourceDTO> permissionList;

    public UserVO() {
    }

    public UserVO(String sysRole, String realName, int age, String sex, String phoneNumber, String address, String accountName,
                  String accountPwd, List<SysResourceDTO> permissionList) {
        this.sysRole = sysRole;
        this.realName = realName;
        this.age = age;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.accountName = accountName;
        this.accountPwd = accountPwd;
        this.permissionList = permissionList;
    }

    public String getSysRole() {
        return sysRole;
    }

    public void setSysRole(String sysRole) {
        this.sysRole = sysRole;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPwd() {
        return accountPwd;
    }

    public void setAccountPwd(String accountPwd) {
        this.accountPwd = accountPwd;
    }
}
