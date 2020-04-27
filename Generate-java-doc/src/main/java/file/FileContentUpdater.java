package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

public class FileContentUpdater {

	public static void main(String[] args) {
		changeContainFileTxt();
	}

	
	public static void changeContainFileTxt() {
		File jsonFile;
		try {
			jsonFile = new File(FileContentUpdater.class.getClassLoader().getResource("").toURI().getPath() + "../.." + "/src/main/java/file/test.txt");
			String content = FileUtils.readFileToString(jsonFile, "UTF-8");
			content = content.replaceAll("\\<.*?>","");
			jsonFile.delete();
			FileUtils.writeStringToFile(jsonFile, content, "UTF-8");
		} catch (IOException e) {
			//Simple exception handling, replace with what's necessary for your use case!
			throw new RuntimeException("Generating file failed", e);
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
