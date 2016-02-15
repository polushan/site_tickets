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

	private Long requestId;
	private Long userId;
	private String from;
	private String to;
	private Date date;
	private String transportType;
	private User user;
	private City fromStation;
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
	
	
	@ManyToOne(cascade= {CascadeType.ALL}, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "ID", insertable = false, updatable = false)
	public City getFromStation() {
		return fromStation;
	}

	public void setFromStation(City fromStation) {
		this.fromStation = fromStation;
	}

	@ManyToOne(cascade= {CascadeType.ALL}, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "ID", insertable = false, updatable = false)
	public City getToStation() {
		return toStation;
	}

	public void setToStation(City toStation) {
		this.toStation = toStation;
	}

	@ManyToOne(cascade= {CascadeType.ALL}, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "USER_ID", insertable = false, updatable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "REQUEST_ID", unique = true, nullable = false)
	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	@Column(name = "USER_ID", nullable = false)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "FROM", nullable = false, length = 15)
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Column(name = "TO", nullable = false, length = 15)
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Column(name = "DATE")
	@Temporal(value = TemporalType.DATE)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "TRANSPORT_TYPE", length = 10)
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
