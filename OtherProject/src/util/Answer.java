package util;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Answer {
	private ArrayList<String> to;
	private ArrayList<String> from;
	private ArrayList<String> title;
	private ArrayList<String> transportType;
	private ArrayList<String> arrival;
	private ArrayList<String> departure;

	public Answer(Document doc) {
		NodeList threads = doc.getElementsByTagName("threads");
		to = new ArrayList<String>();
		from = new ArrayList<String>();
		title = new ArrayList<String>();
		transportType = new ArrayList<String>();
		arrival = new ArrayList<String>();
		departure = new ArrayList<String>();
		Element element;
		for (int i = 0; i < threads.getLength(); i++) {
			element = (Element) threads.item(i);
			to.add(element.getElementsByTagName("to").item(0).getChildNodes().item(5).getTextContent());
			from.add(element.getElementsByTagName("from").item(0).getChildNodes().item(5).getTextContent());
			title.add(element.getElementsByTagName("thread").item(0).getChildNodes().item(3).getTextContent());
			transportType
					.add(element.getElementsByTagName("thread").item(0).getChildNodes().item(15).getTextContent());
			arrival.add(element.getElementsByTagName("arrival").item(0).getTextContent());
			departure.add(element.getElementsByTagName("departure").item(0).getTextContent());
		}
	}

	public ArrayList<String> getTo() {
		return to;
	}

	public void setTo(ArrayList<String> to) {
		this.to = to;
	}

	public ArrayList<String> getFrom() {
		return from;
	}

	public void setFrom(ArrayList<String> from) {
		this.from = from;
	}

	public ArrayList<String> getTitle() {
		return title;
	}

	public void setTitle(ArrayList<String> title) {
		this.title = title;
	}

	public ArrayList<String> gettransportType() {
		return transportType;
	}

	public void transportType(ArrayList<String> transportType) {
		this.transportType = transportType;
	}

	public ArrayList<String> getArrival() {
		return arrival;
	}

	public void setArrival(ArrayList<String> arrival) {
		this.arrival = arrival;
	}

	public ArrayList<String> getDeparture() {
		return departure;
	}

	public void setDeparture(ArrayList<String> departure) {
		this.departure = departure;
	}

}
