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

@Entity
@Table(name = "\"REQUEST\"")
public class Request {

	@Id
	@GeneratedValue//(generator = "increment")
	//@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "REQUEST_ID")
	private Long requestId;
	@Column(name = "USER_ID", nullable = false)
	private Long userId;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "FROM", nullable = false)
	private City from;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "TO", nullable = false)
	private City to;
	@Column(name = "DATE")
	@Temporal(value = TemporalType.DATE)
	private Date date;
	@Column(name = "TRANSPORT_TYPE", length = 10)
	private String transportType;

	public Request() {
		transportType = "ALL";
		date = null;
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
	
	public City getFrom() {
		return from;
	}

	public void setFrom(City from) {
		this.from = from;
	}

	public City getTo() {
		return to;
	}

	public void setTo(City to) {
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
