package com.nongxin.terminal.entity.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.file.FileInfo;
import com.nongxin.terminal.util.enumUtil.system.ThemeEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ThemeManage {

    private Integer id;

    private Integer projectId;

    @NotEmpty(message = "名称不能为空")
    private String themeName;

    private String content;

    @NotEmpty(message = "处理人不能为空")
    private String handlePerson;

    @NotNull(message = "预计开始时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date expectStartTime;

    @NotNull(message = "预计结束时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date expectEndTime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date handleStartTime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date handleEndTime;

    private Integer totalDays;

    private String remark;

    private ThemeEnum status;

    private Integer parentId;

    private List<ThemeManage> children;

    private List<FileInfo> fileInfos;

    public List<FileInfo> getFileInfos() {
        return fileInfos;
    }

    public void setFileInfos(List<FileInfo> fileInfos) {
        this.fileInfos = fileInfos;
    }

    public List<ThemeManage> getChildren() {
        return children;
    }

    public void setChildren(List<ThemeManage> children) {
        this.children = children;
    }

    private Map<String,Object> project;

    public Map<String, Object> getProject() {
        return project;
    }

    public void setProject(Map<String, Object> project) {
        this.project = project;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName == null ? null : themeName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getHandlePerson() {
        return handlePerson;
    }

    public void setHandlePerson(String handlePerson) {
        this.handlePerson = handlePerson == null ? null : handlePerson.trim();
    }

    public Date getExpectStartTime() {
        return expectStartTime;
    }

    public void setExpectStartTime(Date expectStartTime) {
        this.expectStartTime = expectStartTime;
    }

    public Date getExpectEndTime() {
        return expectEndTime;
    }

    public void setExpectEndTime(Date expectEndTime) {
        this.expectEndTime = expectEndTime;
    }

    public Date getHandleStartTime() {
        return handleStartTime;
    }

    public void setHandleStartTime(Date handleStartTime) {
        this.handleStartTime = handleStartTime;
    }

    public Date getHandleEndTime() {
        return handleEndTime;
    }

    public void setHandleEndTime(Date handleEndTime) {
        this.handleEndTime = handleEndTime;
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public ThemeEnum getStatus() {
        return status;
    }

    public void setStatus(ThemeEnum status) {
        this.status = status;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}