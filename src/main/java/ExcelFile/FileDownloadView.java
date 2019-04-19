package ExcelFile;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import entity.Emp;

@ManagedBean
@SessionScoped
public class FileDownloadView {
	private StreamedContent file;
    
    public StreamedContent dowload(List<Emp> list) throws IOException, ParseException {        
    	
		HSSFWorkbook workbook = Excel.makeHSSFWorkbook(list);

		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
				.getResponse();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		workbook.write(out);
		InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(out.toByteArray()));
    	
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/index.xhtml");
        file = new DefaultStreamedContent(inputStream, "application/vnd.ms-excel", "downloaded_boromir.xls");
        return file;
    }
 
    public StreamedContent getFile() {
        return file;
    }
}
