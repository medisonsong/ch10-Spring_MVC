package kr.spring.ch11.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import kr.spring.ch11.vo.PageRank;

public class PageRanksView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//sheet 생성
		HSSFSheet sheet = createFirstSheet((HSSFWorkbook)workbook);
		//label 생성
		createColumnLabel(sheet);
		//각 행의 셀에 데이터 표시 (rownum 필요/ 엑셀에서의 1행=여기서 0번 / 0번=label, 1번부터 데이터 기재)
		int rowNum = 1;
		List<PageRank> pageRanks = (List<PageRank>)model.get("pageRanks");
		//루프 돌면서 데이터 넣기
		for(PageRank rank : pageRanks) {
			createPageRankRow(sheet, rank, rowNum++); // 1이 먼저 전달돼고 행이 증가 되어야 하기 때문에 ++
		}
		
		//파일을 다운로드할 수 있도록 다운로드 파일명 지정
		String fileName = "pageRanks2024.xls";
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
	}
	
	//sheet 생성
	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "페이지 순위"); //sheet index, 시트이름
		//특정 컬럼에 넓이 지정
		sheet.setColumnWidth(1, 256*20); //컬럼인덱스, width
		
		return sheet;
	}
	
	//컬럼 레이블 생성
	private void createColumnLabel(HSSFSheet sheet) {
		HSSFRow firstRow = sheet.createRow(0); //첫번째 행 만들기 (1행)
		HSSFCell cell = firstRow.createCell(0); //A열 1행 만들기
		cell.setCellValue("순위"); //A열 1행에 순위라고 값 넣기
		
		cell = firstRow.createCell(1);
		cell.setCellValue("페이지");
	}
	
	//하나의 행이 가지고 있는 셀들에 내용 표시
	private void createPageRankRow(HSSFSheet sheet, PageRank rank, int rowNum) { //로우 번호 받아야 안겹치고 쫙 루프돌릴 수 있음
		HSSFRow row = sheet.createRow(rowNum);
		HSSFCell cell = row.createCell(0); //첫번째 방 만들기 (rank 데이터 넣을 공간)
		cell.setCellValue(rank.getRank()); //순위 저장
	
		cell = row.createCell(1); //두번째 방 만들기 (page 데이터 넣을 공간)
		cell.setCellValue(rank.getPage()); //페이지 저장
	}
	
}
