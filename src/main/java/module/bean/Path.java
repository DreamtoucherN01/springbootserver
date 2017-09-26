package module.bean;


public class Path {
	
	String path;

	public Path(String images) {
		if(images.startsWith("http")) 
			this.path = images;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		if(!path.startsWith("http")) return;
		this.path = path;
	}

	@Override
	public String toString() {
		return "Path [path=" + path + "]";
	}
}
