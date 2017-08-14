package module.bean;

import org.bson.types.ObjectId;

public class Themes {

	String id;
	
	ObjectId types;
	
	String name;
	
	String subname;
	
	String content;
	
	String pic1;
	
	String pic2;
	
	String pic3;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public String getPic2() {
		return pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}

	public String getPic3() {
		return pic3;
	}

	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}

	@Override
	public String toString() {
		return "Themes [id=" + id + ", types=" + types + ", name=" + name
				+ ", subname=" + subname + ", content=" + content + ", pic1="
				+ pic1 + ", pic2=" + pic2 + ", pic3=" + pic3 + "]";
	}
	
}
