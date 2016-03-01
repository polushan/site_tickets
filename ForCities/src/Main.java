import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static final String inputFile = "D:\\test3.txt";

	public static void main(String[] args) {
		CityDAO cityD = new CityDAO();
		Scanner sc = null;
		try  {
			sc = new Scanner(new File(inputFile), "UTF-8");
			while (sc.hasNextLine()) {
				String currentLine = sc.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(currentLine, ",");
				String id = tokenizer.nextToken();
				String name = tokenizer.nextToken();
				cityD.addCity(new City(id, name));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sc != null)
				sc.close();
		}

	}
}
