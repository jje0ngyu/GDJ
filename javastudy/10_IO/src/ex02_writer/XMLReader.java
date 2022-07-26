package ex02_writer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ex03_reader.Product;

public class XMLReader {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File file = new File("C:\\storage", "product.xml");
			Document document = builder.parse(file);	// rpoduct.xml 파싱(분석)
			
			// 최상위 요소 (root)
			Element root = document.getDocumentElement();
			System.out.println("최상위 요소 : " + root.getNodeName());
			
			List<Product> products = new ArrayList<Product>();
			// 최상위 요소의 자식 노드들
			NodeList nodeList = root.getChildNodes(); //* 자식 노드들 가져오기
			for(int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);  //* nodeList[i] 값을 의미함.
//				System.out.println(node.getNodeName()); // 줄 바꿈(#text)과 <product> 태그로 구성
				
				if (node.getNodeType() == Node.ELEMENT_NODE) { // 노드가 Element인가? (*element_node 는 <태그>를 의미)
															   // (줄 바꿈 #text 제외되고 <product> 태그만 남음)
					NodeList nodeList2 = node.getChildNodes(); // <product> 태그의 자식노드 (줄 바꿈 #text, <number>, <name>, <price>)
					Product product = new Product();
					for (int j = 0; j < nodeList2.getLength(); j++) {
						Node node2 = nodeList2.item(j);
						if (node2.getNodeType() == Node.ELEMENT_NODE) {
							switch(node2.getNodeName()) {
							case "number" : product.setNumber(node2.getTextContent()); break;
							case "name" : product.setName(node2.getTextContent()); break;
							case "price" : product.setPrice(Integer.parseInt(node2.getTextContent())); break;
							}
						}
					}
					// ArrayList에 product 추가
					products.add(product);
				}
			}
			// ArrayList 확인
			for (Product product : products) {
				System.out.println(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
