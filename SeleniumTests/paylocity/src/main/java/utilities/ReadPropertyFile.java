package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("C:\\Users\\luis_\\.eclipse\\eclipseWokspace\\mavenProject\\src\\main\\java\\utilities");
		Properties pro = new Properties();
		pro.load(fr);
	}

}
