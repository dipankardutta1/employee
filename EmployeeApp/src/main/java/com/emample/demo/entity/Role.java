package com.emample.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="role_name")
	private String roleName;
	
	@OneToMany(mappedBy="role")
	private List<UserRoleMap> userRoleMap;

	
	@Column(name="active_flag")
	private String activeFlag;
	
	
	@OneToMany(mappedBy="role")
	private List<MenuRoleMap> menuRoleMapList;
	
	
	@Column(name="created_by")
	private String createdBy;
	@Column(name="modified_by")
	private String modifiedBy;
	@Column(name="created_date")
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	@Column(name="modified_date")
	@Temporal(TemporalType.DATE)
	private Date modifiedDate;
	@Column(name="delete_flag")
	private String deleteFlag;
	
	
	
	public List<MenuRoleMap> getMenuRoleMapList() {
		return menuRoleMapList;
	}
	public void setMenuRoleMapList(List<MenuRoleMap> menuRoleMapList) {
		this.menuRoleMapList = menuRoleMapList;
	}
	
	public List<UserRoleMap> getUserRoleMap() {
		return userRoleMap;
	}
	public void setUserRoleMap(List<UserRoleMap> userRoleMap) {
		this.userRoleMap = userRoleMap;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	
	
	
	
	
	
}
