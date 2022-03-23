package exam02;

public class Page {
	private int pageNumber;			// 페이지 번호
	private int limitPageNumber;	// 최대 페이지 번호
	
	public Page(int limitPageNumber) {
		this.limitPageNumber = limitPageNumber;
	}
	
	public Page(int pageNumber, int limitPageNumber) {
		this.pageNumber = pageNumber;
		this.limitPageNumber = limitPageNumber;
	}
	
	public int getPageNumber() {
		return this.pageNumber;
	}
	
	public int getLimitPageNumber() {
		return this.limitPageNumber;
	}
	
	public void movePage(int pageNumber) {
		if(pageNumber <= limitPageNumber && pageNumber >= 1) {
			this.pageNumber = pageNumber;
		} else {
			System.out.println("더 이상 책의 페이지를 넘길 수 없습니다.");
		}
	}
	
	public void nextPage() {
		if(!existsNextPage()) {
			System.out.println("더 이상 책의 페이지를 넘길 수 없습니다.");
		} else {
			this.pageNumber++;
		}
	}
	
	public void nextPage(int count) {
		if(!existsNextPage(count)) {
			System.out.println("더 이상 책의 페이지를 넘길 수 없습니다.");
		} else {
			this.pageNumber += count;
		}
	}
	
	public void prevPage() {
		if(!existsPrevPage()) {
			System.out.println("더 이상 책의 페이지를 넘길 수 없습니다.");
		} else {
			this.pageNumber--;
		}
	}
	
	public void prevPage(int count) {
		if(!existsPrevPage(count)) {
			System.out.println("더 이상 책의 페이지를 넘길 수 없습니다.");
		} else {
			this.pageNumber -= count;
		}
	}
	
	public boolean existsNextPage() {
		if(pageNumber + 1 <= limitPageNumber) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean existsNextPage(int count) {
		if(pageNumber + count <= limitPageNumber) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean existsPrevPage() {
		if(pageNumber - 1 >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean existsPrevPage(int count) {
		if(pageNumber - count >= 1) {
			return true;
		} else {
			return false;
		}
	}
}
