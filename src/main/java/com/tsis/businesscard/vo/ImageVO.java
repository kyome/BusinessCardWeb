package com.tsis.businesscard.vo;

public class ImageVO {
	private int seq;
	private int empSeq;
	private String path;
	private String fileName;
	private String originalName;
	private String fileCd;
	private String regDate;
	
	public ImageVO() {
		super();
	}

	public ImageVO(int seq, int empSeq, String path, String fileName, String originalName, String fileCd,
			String regDate) {
		super();
		this.seq = seq;
		this.empSeq = empSeq;
		this.path = path;
		this.fileName = fileName;
		this.originalName = originalName;
		this.fileCd = fileCd;
		this.regDate = regDate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getEmpSeq() {
		return empSeq;
	}

	public void setEmpSeq(int empSeq) {
		this.empSeq = empSeq;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public String getFileCd() {
		return fileCd;
	}

	public void setFileCd(String fileCd) {
		this.fileCd = fileCd;
	}

	@Override
	public String toString() {
		return "ImageVO [seq=" + seq + ", empSeq=" + empSeq + ", path=" + path + ", fileName=" + fileName
				+ ", originalName=" + originalName + ", fileCd=" + fileCd + ", regDate=" + regDate + "]";
	}
	
}
