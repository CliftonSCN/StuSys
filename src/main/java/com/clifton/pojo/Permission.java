package com.clifton.pojo;

public class Permission {
    private Integer id;

    private String permName;

    private String permDecription;

    @Override
	public String toString() {
		return "Permission [id=" + id + ", permName=" + permName + ", permDecription=" + permDecription + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName == null ? null : permName.trim();
    }

    public String getPermDecription() {
        return permDecription;
    }

    public void setPermDecription(String permDecription) {
        this.permDecription = permDecription == null ? null : permDecription.trim();
    }
}