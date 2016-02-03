package tables;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "REQUESTS")
public class Requests {
	@Id
	@Column(name = "REQUEST_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long requestId;
	@Column(name = "USER_ID", nullable = false)
	private Long UserId;
	@Column(name = "FROM", nullable = false, length = 15)
	private String from;
	@Column(name = "TO", nullable = false, length = 15)
	private String to;
	@Column(name = "DATE")
	@Temporal(value = TemporalType.DATE)
	private Date date;
	@Column(name = "TRANSPORT_TYPE", length = 10)
	private String transportType;

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Long getUserId() {
		return UserId;
	}

	public void setUserId(Long userId) {
		UserId = userId;
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
		if ("plane".equals(transportType) || "train".equals(transportType)) {
			this.transportType = transportType;
		} else {
			this.transportType = "ALL";
		}
	}

	public Requests(Long requestId, Long userId, String from, String to, Date date,
			String transportType) {
		this.requestId = requestId;
		UserId = userId;
		this.from = from;
		this.to = to;
		this.date = date;
		setTransportType(transportType);
	}

	public Requests() {

	}

}
