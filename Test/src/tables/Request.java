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
	private Long UserId;
	private String from;
	private String to;
	private Date date;
	private String transportType;
	private User user;
	private Station fromStation;
	private Station toStation;

	public Request(Long requestId, Long userId, String from, String to, Date date, String transportType) {
		this.requestId = requestId;
		UserId = userId;
		this.from = from;
		this.to = to;
		this.date = date;
		setTransportType(transportType);
	}

	public Request() {

	}
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "ID", insertable = false, updatable = false)
	public Station getFromStation() {
		return fromStation;
	}

	public void setFromStation(Station fromStation) {
		this.fromStation = fromStation;
	}

	@ManyToOne(cascade= {CascadeType.REFRESH}, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "ID", insertable = false, updatable = false)
	public Station getToStation() {
		return toStation;
	}

	public void setToStation(Station toStation) {
		this.toStation = toStation;
	}

	@ManyToOne(cascade= {CascadeType.REFRESH}, fetch = FetchType.LAZY, optional = true)
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
		return UserId;
	}

	public void setUserId(Long userId) {
		UserId = userId;
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
		if ("plane".equals(transportType) || "train".equals(transportType)) {
			this.transportType = transportType;
		} else {
			this.transportType = "ALL";
		}
	}

}
