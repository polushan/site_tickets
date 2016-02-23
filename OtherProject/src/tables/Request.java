package tables;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "\"REQUEST\"")
public class Request {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "REQUEST_ID", unique = true, nullable = false)
	private Long requestId;
	@Column(name = "USER_ID", nullable = false)
	private Long userId;
	@Column(name = "FROM", nullable = false, length = 15)
	private String from;
	@Column(name = "TO", nullable = false, length = 15)
	private String to;
	@Column(name = "DATE")
	@Temporal(value = TemporalType.DATE)
	private Date date;
	@Column(name = "TRANSPORT_TYPE", length = 10)
	private String transportType;
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "USER_ID", insertable = false, updatable = false)
	private User user;
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "ID", insertable = false, updatable = false)
	private City fromStation;
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "ID", insertable = false, updatable = false)
	private City toStation;

	public Request(Long requestId, Long userId, String from, String to, Date date, String transportType) {
		this.requestId = requestId;
		this.userId = userId;
		this.from = from;
		this.to = to;
		this.date = date;
		setTransportType(transportType);
	}

	public Request() {

	}

	public City getFromStation() {
		return fromStation;
	}

	public void setFromStation(City fromStation) {
		this.fromStation = fromStation;
	}

	public City getToStation() {
		return toStation;
	}

	public void setToStation(City toStation) {
		this.toStation = toStation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		if ("plane".equals(transportType) || "train".equals(transportType) || "bus".equals(transportType)
				|| "ALL".equals(transportType)) {
			this.transportType = transportType;
		}
	}

}
