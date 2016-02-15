package util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import tables.Request;

public class RequestSender {

	private static final String apiKey = "b13b8a87-53d2-4b5a-832b-7d6d7e1cf59a";
	private static final String yandex = "https://api.rasp.yandex.net/v1.0/search/?";
	private static final String tail = "&system=iata";

	public static Document sendRequest(Request userRequest, String date) throws SomethingWrongException, IOException{

		String from = userRequest.getFrom();
		String to = userRequest.getTo();
		String transportType = userRequest.getTransportType();

		if (!"".equals(date)) {
			date = "&date=" + date;
		}
		if ("ALL".equals(transportType)) {
			transportType = "";
		} else if ("train".equals(transportType)) {
			transportType = "&transport_type=train";
		} else if ("plane".equals(transportType)) {
			transportType = "&transport_type=plane";
		} else {
			transportType = "&transport_type=bus";
		}
		URL url = null;
		URLConnection urlConnection = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		DocumentBuilder builder;
		Document doc = null;
		try {
			builder = factory.newDocumentBuilder();
			url = new URL(yandex + "apikey=" + apiKey + "&format=xml" + "&from=" + from + "&to=" + to + date
					+ transportType + tail);
			urlConnection = url.openConnection();
			doc = builder.parse(urlConnection.getInputStream());
		} catch (SAXException e) {
			e.printStackTrace();
			throw new SomethingWrongException();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new SomethingWrongException("Что-то с url" + e.toString());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			throw new SomethingWrongException();
		} 
		return doc;

	}
}