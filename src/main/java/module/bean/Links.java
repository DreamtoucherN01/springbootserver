package module.bean;

import org.springframework.data.annotation.Id;

public class Links {

	@Id
	public String objectId;
	
	public String tag;
	
	public String url;
	
	public String contentUrl;

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	@Override
	public String toString() {
		return "Links [objectId=" + objectId + ", tag=" + tag + ", url=" + url
				+ ", contentUrl=" + contentUrl + "]";
	}

}
