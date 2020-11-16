package com.tsis.businesscard.vo;

public class SendHistoryVO {
	private int seq;
	private int sender;
	private String receiver;
	private String sendType;
	private String content;
	private int fileSeq;
	private String regDate;
	
	public SendHistoryVO() {
		super();
	}
	
	public SendHistoryVO(int seq, int sender, String receiver, String sendType, String content, int fileSeq,
			String regDate) {
		super();
		this.seq = seq;
		this.sender = sender;
		this.receiver = receiver;
		this.sendType = sendType;
		this.content = content;
		this.fileSeq = fileSeq;
		this.regDate = regDate;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getFileSeq() {
		return fileSeq;
	}
	public void setFileSeq(int fileSeq) {
		this.fileSeq = fileSeq;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "SendHistoryVO [seq=" + seq + ", sender=" + sender + ", receiver=" + receiver + ", sendType=" + sendType
				+ ", content=" + content + ", fileSeq=" + fileSeq + ", regDate=" + regDate + "]";
	}
}
