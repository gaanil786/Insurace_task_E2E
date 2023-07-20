package pojo;

import lombok.Data;

@Data
public class Payment {
	public String cardNumber;
	public String date;
	public String cvv;
}