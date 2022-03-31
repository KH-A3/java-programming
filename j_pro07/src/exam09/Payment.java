package exam09;

public interface Payment {
	public String pay(String productCode, int count);
	public void cancel(String produtCode);
	public void confirm(String payCode);
	public void refund(String productName);
}
