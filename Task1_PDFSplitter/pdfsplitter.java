import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
  
import java.io.File;
import java.io.IOException;
import java.util.*;
public class pdfsplitter {
    public static void main(String[] args)throws IOException { 
	{
		StringBuffer sb = new StringBuffer("");   
        System.out.print("enter your pdf address: ");  
        Scanner sc = new Scanner(System.in);  
        sb.append(sc.nextLine());  
		//sb = D:\just_for_checking\CDesktopJavasample.pdf

		int length = sb.length();
		sb.delete((length-4), length);
		//System.out.println(sb);
		//sb = D:\just_for_checking\CDesktopJavasample

		//Loading PDF
		File pdffile = new File( sb + ".pdf" );

		//sb = D:\just_for_checking\CDesktopJavasample.pdf
		
		PDDocument document = PDDocument.load(pdffile);
		Splitter splitting = new Splitter();
		List<PDDocument> Page = splitting.split(document);
		//System.out.println(Page);
		Iterator<PDDocument> iteration = Page.listIterator();

		int j = 1;
        while (iteration.hasNext()) {
            PDDocument pd = iteration.next();
            pd.save(sb + "" + j++ + ".pdf");
        }
        //Closing the document  
        document.close();
		sc.close();
    }
  }
}