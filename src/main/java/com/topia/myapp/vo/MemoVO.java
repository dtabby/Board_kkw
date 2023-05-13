package com.topia.myapp.vo;

public class MemoVO {
	private int memoNum;			// 메모순번
	private String userId;			// 아이디
	private String userName;		// 이름
	private String title;			// 제목
	private String content;			// 내용
	private String contentReply;	// 내용답글
	private String noticeYN;		// 공지여부
	private String writeDate;		// 작성일자
	private String registDate;		// 등록일자
	private String updateDate;		// 수정일자
	private String registId;		// 등록자아이디
	private String updateId;		// 수정자아이디
	private String registIp;		// 등록자아이피
	private String updateIp;		// 수정자이이피
	
	public int getMemoNum() {
		return memoNum;
	}
	public void setMemoNum(int memoNum) {
		this.memoNum = memoNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentReply() {
		return contentReply;
	}
	public void setContentReply(String contentReply) {
		this.contentReply = contentReply;
	}
	public String getNoticeYN() {
		return noticeYN;
	}
	public void setNoticeYN(String noticeYN) {
		this.noticeYN = noticeYN;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getRegistId() {
		return registId;
	}
	public void setRegistId(String registId) {
		this.registId = registId;
	}
	public String getUpdateId() {
		return updateId;
	}
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	public String getRegistIp() {
		return registIp;
	}
	public void setRegistIp(String registIp) {
		this.registIp = registIp;
	}
	public String getUpdateIp() {
		return updateIp;
	}
	public void setUpdateIp(String updateIp) {
		this.updateIp = updateIp;
	}
	
	@Override
	public String toString() {
		return "MemoVO [userId=" + userId + ", userName=" + userName + ", title=" + title + ", content=" + content
				+ ", contentReply=" + contentReply + ", noticeYN=" + noticeYN + ", writeDate=" + writeDate
				+ ", registDate=" + registDate + ", updateDate=" + updateDate + ", registId=" + registId + ", updateId="
				+ updateId + ", registIp=" + registIp + ", updateIp=" + updateIp + "]";
	}
}
