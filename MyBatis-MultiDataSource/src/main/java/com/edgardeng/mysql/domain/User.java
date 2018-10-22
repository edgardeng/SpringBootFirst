package com.edgardeng.mysql.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "hs_user")
public class User implements Serializable {

    private static final long serialVersionUID = -4852732617765810959L;
    /**
     * 账户状态
     */
    public static final int STATUS_VALID = 1;

    public static final int STATUS_LOCK = 0;

    public static final String DEFAULT_THEME = "green";

    public static final String DEFAULT_AVATAR = "default.jpg";

    /** 性别 */
    public static final int SEX_MALE = 0;

    public static final int SEX_FEMALE = 1;

    public static final int SEX_UNKNOW = 2;

    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "status")
    private int status = STATUS_VALID;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_from")
    private String createdFrom;

    @Column(name = "updated_at")
   private Date updatedAt;

    @Column(name = "updated_by")
    private Long updatedBy;

    @Column(name = "updated_from")
    private String updatedFrom;

    @Column(name = "gender")
    private int gender;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "description")
    private String description;

    @Transient
    private String roleName;

    /**
     * @return USER_ID
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return USERNAME
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }


    /**
     * @return EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedFrom() {
        return createdFrom;
    }

    public void setCreatedFrom(String createdFrom) {
        this.createdFrom = createdFrom;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedFrom() {
        return updatedFrom;
    }

    public void setUpdatedFrom(String updatedFrom) {
        this.updatedFrom = updatedFrom;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "userid=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", gender='" + gender + '\'' +
                ", avatar='" + avatar + '\'' +
                ", description='" + description + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    @Override

    public boolean equals(Object o) {
        return o instanceof User && (this.username.equals(((User) o).username));
    }

    @Override
    public int hashCode() {

        return this.username.hashCode();
    }
}