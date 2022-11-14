package in.shambhu.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import in.shambhu.request.SearchRequest;
import in.shambhu.response.SearchResponse;

public interface ReportService {
	
	public List<String> getUniquePlanNames();
	
	public List<String> getUniquePlanStatus();
	
	public List <SearchResponse> search(SearchRequest request);
	
	public void generateExcel(HttpServletResponse response) throws Exception;
	
	public void generatePdf(HttpServletResponse response) throws Exception;

}
