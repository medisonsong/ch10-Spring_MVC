package kr.spring.ch06.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.spring.ch06.vo.MemberInfo;

//유효성 체크하는 클래스
public class MemberInfoValidator implements Validator{

	//Validator가 검증할 수 있는 타입인지를 검사
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberInfo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberInfo memberInfo = (MemberInfo)target;
		if(memberInfo.getId() == null || memberInfo.getId().isEmpty()) {
			//항목이 비어있다면 errors에 기록
							// 필드	에러코드	(default message)
			errors.rejectValue("id", "required"); 
		}
		if(memberInfo.getName() == null || memberInfo.getName().isEmpty()) {
			errors.rejectValue("name", "required");
		}
		if(memberInfo.getZipcode() == null || memberInfo.getZipcode().isEmpty()) {
			errors.rejectValue("zipcode", "required");
		}
		if(memberInfo.getAddress1() == null || memberInfo.getAddress1().isEmpty()) {
			errors.rejectValue("address1", "required");
		}
		if(memberInfo.getAddress2() == null || memberInfo.getAddress2().isEmpty()) {
			errors.rejectValue("address2", "required");
		}
	}
	
}
