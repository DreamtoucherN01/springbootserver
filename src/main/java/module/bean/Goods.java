package module.bean;

import java.util.Arrays;
import java.util.Date;

import org.bson.types.ObjectId;

public class Goods {

	String id;
	
	ObjectId types;
	
	String name;
	
	double price;
	
	String remark;
	
	Path[] images;
	
	String video;
	
	long create_at;
	
	long update_at;


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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Path[] getImages() {
		return images;
	}

	public void setImages(Path images[]) {
		this.images = images;
	}
	
	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", types=" + types + ", name=" + name
				+ ", price=" + price + ", remark=" + remark + ", images="
				+ Arrays.toString(images) + ", video=" + video
				+ ", create_at=" + create_at + ", update_at=" + update_at + "]";
	}

}
