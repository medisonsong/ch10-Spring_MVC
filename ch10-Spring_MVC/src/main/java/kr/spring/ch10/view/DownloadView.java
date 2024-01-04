package kr.spring.ch10.view;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView{

	public DownloadView() {
		setContentType("application/download;charset=utf-8");
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		File file = (File)model.get("downloadFile");
		//컨텐트 타입 지정
		response.setContentType(getContentType());
		//전송하는 데이터의 용량
		response.setContentLength((int)file.length());
		
		//전송할 파일명 구하기
		String fileName = new String(file.getName().getBytes("utf-8"),"iso-8859-1");
		
		response.setHeader("Content-Disposition", "attachment; filename=\"file.txt\";");
		
		
	}

}
