package module.bean;

import org.springframework.data.annotation.Id;

public class Classifies {

	@Id
	public String objectId;
	
	public String name;
	
	public String remark;
	
	public long create_at;
	
	public long update_at;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getCreate_at() {
		return create_at;
	}

	public void setCreate_at(long create_at) {
		this.create_at = create_at;
	}

	public long getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(long update_at) {
		this.update_at = update_at;
	}
	
	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	@Override
	public String toString() {
		return "Classifies [objectId=" + objectId + ", name=" + name + ", remark=" + remark
				+ ", create_at=" + create_at + ", update_at=" + update_at + "]";
	}

}
