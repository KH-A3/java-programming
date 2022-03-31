package exam09;

public interface Basket {
	public void add(String productName);
	public void add(String productName, int count);
	public void modify(String productName, int count);
	public void remove(String productName);
	public String[] listUp();
	public String[] listUp(int count);
}
