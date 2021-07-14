package electr.electr;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class parser1 {
	public static void getSsylka (String url ) throws IOException {
		Document page = Jsoup.parse(new URL(url), 7000);
		int count = 1;
		
		Element tableTrain = page.select("tbody").first();
		Elements rows = tableTrain.select("td");
		for(Element row : rows ) {
			if (count == 1) { // 1 ячейка
				System.out.println("Станция:" + row.text()); // вывод
				}
			if (count == 2) { // 2 ячейка
				if (row.text().equals("")) {
					System.out.println("Прибытие: -");
				}
				else {
				System.out.println("Прибытие: " + row.text()); // вывод
					}
				}
			if (count == 3) { // 3 ячейка
				if (row.text().equals("")) {
					System.out.println("Стоянка: -");
				}
				else {
				System.out.println("Стоянка: " + row.text()); // вывод
					}
				}
			if (count == 4) { // 4 ячейка
				if (row.text().equals("")) {
					System.out.println("Отправление: -");
				}
				else {
				System.out.println("Отправление: " + row.text()); // вывод
					}
				}
			if (count == 5) { // 5 ячейка
				if (row.text().equals("")) {
					System.out.println("В пути: -");
				}
				else {
				System.out.println("В пути: " + row.text()); // вывести в пути
					}
				System.out.println("***********************************");
				}
			
			
				count++; // счетчик +1
				
			if (count == 6) { // 6 ячейка
				count=1; // 
				}	
		}
	}
}

