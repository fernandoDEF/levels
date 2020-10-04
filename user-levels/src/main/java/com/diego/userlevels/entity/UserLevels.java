package com.diego.userlevels.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userlevels")
public class UserLevels implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable=false, unique=true)
	private String name;
	
	@Column(name="level", nullable=false, length = 20)
	private String level;
	
	@Column(name="progress", nullable=false)
	private float progress;
	
	private Boolean enable;


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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Boolean getEnable() {
		return enable;
	}
	
	public float getProgress() {
		return progress;
	}

	public void setProgress(float progress) {
		this.progress = progress;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	
}
