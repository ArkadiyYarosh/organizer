package by.bsuir.yarosh.settings.domain;

public class Page {
    private long pageNo;
    private long amount;
    private long skip;

    public Page(long pageNo, long amount, long skip) {
        this.pageNo = pageNo;
        this.amount = amount;
        this.skip = skip;
    }

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getSkip() {
        return skip;
    }

    public void setSkip(long skip) {
        this.skip = skip;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Page{");
        sb.append("pageNo=").append(pageNo);
        sb.append(", amount=").append(amount);
        sb.append(", skip=").append(skip);
        sb.append('}');
        return sb.toString();
    }
}
