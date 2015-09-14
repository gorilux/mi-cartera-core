package org.mada.es.mibolsa.service.impl;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.mada.es.mibolsa.dto.QuoteWeb;
import org.mada.es.mibolsa.dto.QuoteWeb.FieldCotizacion;
import org.mada.es.mibolsa.service.IInfoBolsaService;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Service
public class InfoBolsaServiceImpl implements IInfoBolsaService {

	private static final String URL_INFOBOLSA_MERCADO_CONTINUO = "http://www.infobolsa.es/mercado-nacional/mercado-continuo";

	@Override
	public List<QuoteWeb> extractQuoteWebInfoBolsa() {

		List<QuoteWeb> listQuote = new ArrayList<QuoteWeb>();

		try {

			String str = readCotizacionInfobolsa();

			InputStream fxmlFile = new ByteArrayInputStream(str.getBytes());

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fxmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("tr");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				QuoteWeb coti = new QuoteWeb();

				/* recorriendo los tr */
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					/* td dentro de tr */
					NodeList tdElement = eElement.getElementsByTagName("td");

					for (int j = 0; j < tdElement.getLength(); j++) {
						Node node = tdElement.item(j);

						Element elemento = (Element) node;

						String campo = elemento.getAttribute("class");
						campo = campo.split(" ")[0];

						switch (FieldCotizacion.getEnum(campo)) {
						case cash:
						case changeP:
						case date:
						case max:
						case min:
						case name:
						case price:
						case ticker:
						case hour:
						case volume:

							String value = elemento.getTextContent().trim();
							set(coti, campo, value);

							break;

						default:

							break;
						}

					}
				}

				listQuote.add(coti);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listQuote;
	}

	private String readCotizacionInfobolsa() throws IOException {

		URL url = new URL(URL_INFOBOLSA_MERCADO_CONTINUO);

		URLConnection uc = url.openConnection();
		uc.connect();
		// Creamos el objeto con el que vamos a leer
		BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String inputLine;

		String fileOut = "";

		boolean blwrite = false;
		while ((inputLine = in.readLine()) != null) {
			inputLine += "\n";

			if (inputLine.trim().startsWith("<tbody>")) {
				blwrite = true;
			}

			if (inputLine.trim().startsWith("</tbody>")) {
				// fileOut.write(inputLine);
				fileOut += inputLine;
				blwrite = false;
				break;
			}

			if (blwrite) {
				if (!"".equals(inputLine.trim())) {
					fileOut += inputLine;
				}
			}

		}
		in.close();

		return fileOut;

	}

	private boolean set(Object object, String fieldName, Object fieldValue) {
		Class<?> clazz = object.getClass();
		while (clazz != null) {
			try {
				Field field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);
				field.set(object, fieldValue);
				return true;
			} catch (NoSuchFieldException e) {
				clazz = clazz.getSuperclass();
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}

}
