package VO;

public class keywordVo {
	
	private categoryVo cat_id;
	private long keywordId;
	private String keywordName;
	public categoryVo getCat_id() {
		return cat_id;
	}
	public void setCat_id(categoryVo cat_id) {
		this.cat_id = cat_id;
	}
	
	public String getKeywordName() {
		return keywordName;
	}
	public void setKeywordName(String keywordName) {
		this.keywordName = keywordName;
	}
	public long getKeywordId() {
		return keywordId;
	}
	public void setKeywordId(long keywordId) {
		this.keywordId = keywordId;
	}

}
