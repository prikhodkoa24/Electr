package electr.electr;


import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

	public class parser {
		private static Document getPage() throws IOException {
			String url = "https://poezdato.net/raspisanie-po-stancyi/samara/elektrichki/";
			Document page = Jsoup.parse(new URL(url), 7000);
			return page;
		}
		
		public static void main(String[] args) throws Exception {
			Document page = getPage();
			int count = 1;
			Element tableTrain = page.select("tbody").first();
			Elements rows = tableTrain.select("td");
			for(Element row : rows ) {
				if (count == 2) { // если вторая ячейка
					System.out.println("***********************************");
					System.out.println("Поезд: ");
					System.out.println("Номер: " + row.text()); // вывод
					parser1.getSsylka("https://poezdato.net" + row.select("a").first().attr("href")); // ссылка
					
					}
				if (count == 3) { // 3 ячейка
					System.out.println("Маршрут: " + row.text()); // вывод
					
					}
				if (count == 4) { // 4 ячейка
					if (row.text().equals("")) {
						System.out.println("Прибытие: -");
					}
					else {
					System.out.println("Прибытие: " + row.text()); // вывод
						}
					}
				if (count == 5) { // 5 ячейка
					if (row.text().equals("")) {
						System.out.println("Стоянка: -");
					}
					else {
					System.out.println("Стоянка:" + row.text()); // вывод
						}
					}
				if (count == 6) { //6 ячейка
					if (row.text().equals("")) {
						System.out.println("Отправление: -");
					}
					else {
					System.out.println("Отправление: " + row.text()); // вывод
						}
					}
				
					count++; //счетчик +1
					
				if (count == 9) { // 9 ячейка
					count=1; // 
					}	
					
				}

		}
}