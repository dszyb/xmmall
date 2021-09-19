package com.zyb.xmmall.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
@Data
@NoArgsConstructor
public class Orders {
	private String ordersId;
	private float total;
	private int status;
	private Date createTime;
	private int usersId;
	private int receiverId;
	private Receiver receiver;
	private List<Items> items;
	private String ids;

	public Orders(String ordersId, float total, int status, Date createTime, int usersId, int receiverId,
				  Receiver receiver) {
		super();
		this.ordersId = ordersId;
		this.total = total;
		this.status = status;
		this.createTime = createTime;
		this.usersId = usersId;
		this.receiverId = receiverId;
		this.receiver = receiver;
	}
}