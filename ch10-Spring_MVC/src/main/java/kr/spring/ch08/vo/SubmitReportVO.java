package kr.spring.ch08.vo;

import org.springframework.web.multipart.MultipartFile;

public class SubmitReportVO {
	private String subject; //제목
	private MultipartFile reportFile; //파일 (multipartFile 타입으로 처리해야함)
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public MultipartFile getReportFile() {
		return reportFile;
	}
	public void setReportFile(MultipartFile reportFile) {
		this.reportFile = reportFile;
	}
	
	@Override
	public String toString() {
		return "SubmitReportVO [subject=" + subject + ", reportFile=" + reportFile + "]";
	}
}
