import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.print(valueOfOneEURinHUF());

	}

	public static double valueOfOneEURinHUF() throws MalformedURLException, IOException {
		URL oracle = new URL("http://www.mnb.hu/");
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

		String inputLine;
		String requiredLine = "";
		int temp = 1;
		while ((inputLine = in.readLine()) != null) {
			if (temp == 263) {
				requiredLine = inputLine;
			}
			temp++;
		}
		in.close();
		requiredLine = requiredLine.replace("			<big>", "");
		requiredLine = requiredLine.replace("</big><br>", "");
		requiredLine = requiredLine.replace(",", ".");
		double valueOfOneEURinHUF = Double.parseDouble(requiredLine);
		return valueOfOneEURinHUF;
	}
}
