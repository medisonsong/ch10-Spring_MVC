package kr.spring.ch08.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.spring.ch08.vo.SubmitReportVO;

public class SubmitReportValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return SubmitReportVO.class.isAssignableFrom(clazz); //사용하는 객체가 자바빈 구조인지 확인
	}

	@Override
	public void validate(Object target, Errors errors) {
		SubmitReportVO report = (SubmitReportVO)target;
		if(report.getSubject()==null || report.getSubject().isEmpty()) {
			errors.rejectValue("subject", "required");
		}
		if(report.getReportFile()==null || report.getReportFile().isEmpty()) {
			errors.rejectValue("reportFile", "required");
		}
	}
}
