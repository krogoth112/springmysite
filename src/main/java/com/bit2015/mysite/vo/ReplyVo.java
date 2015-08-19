package com.bit2015.mysite.vo;

public class ReplyVo {

	private Long no;
	private Long articleNo;
	private String content;
	private Long memberNo;
	private String memberName;
	private String regDate;
	private Long groupNo;
	private Long orderNo;
	private Long depth;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(Long articleNo) {
		this.articleNo = articleNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Long getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(Long groupNo) {
		this.groupNo = groupNo;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	@Override
	public String toString() {
		return "ReplyVo [no=" + no + ", articleNo=" + articleNo + ", content="
				+ content + ", memberNo=" + memberNo + ", memberName="
				+ memberName + ", regDate=" + regDate + ", groupNo=" + groupNo
				+ ", orderNo=" + orderNo + ", depth=" + depth + "]";
	}

	

}