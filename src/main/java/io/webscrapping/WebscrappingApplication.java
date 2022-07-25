package io.webscrapping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import tonaton.Product;

import java.util.ArrayList;
import java.util.List;
@RestController
@SpringBootApplication
public class WebscrappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebscrappingApplication.class, args);
	}

	@GetMapping(value = "/products/{category}")
	public List<Product> getProductsByCategory(@PathVariable String category){
		List<Product> products = new ArrayList<>();
		String url = "https://tonaton.com/c_" + category;
		try{
			Document document  = Jsoup.connect(url).get();
			int count = 1;
			for (Element row: document.select("div.product__content")){
				Double price = Double.parseDouble(row.select("span.product__title").text().substring(4).replace(",", ""));
				String name = row.select("p.product__description").text();
				String brand = row.select("div.product__tags.flex.wrap span").text();
				String location = row.select("p.product__location").text();

				Product product = new Product();
				product.setName(name);
				product.setBrand(brand);
				product.setLocation(location);
				product.setPrice(price);
				product.setId(count++);
				products.add(product);
				System.out.println(product);
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return products;
	}

}
