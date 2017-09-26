package module.bean;

import java.util.Arrays;

import org.bson.types.ObjectId;

public class GoodOfItem {

	String id;
	
	ObjectId types;
	
	String name;
	
	double price;
	
	String remark;
	
	String[] images;
	
	String video;
	
	public ObjectId getTypes() {
		return types;
	}

	public void setTypes(ObjectId types) {
		this.types = types;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String images[]) {
		this.images = images;
	}
	
	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

}
