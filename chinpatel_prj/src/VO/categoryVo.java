package VO;
import java.io.*;
public class categoryVo implements Serializable {
	
	private long catId;
	private String catName;


	
	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public long getCatId() {
		return catId;
	}

	public void setCatId(long catId) {
		this.catId = catId;
	}
	

}
