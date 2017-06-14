package customlistviewcustomlistview.cheng.com.baithuchanhso3;

/**
 * Created by chien on 10/25/16.
 */

public class Contact {
    private String isdate;
    private String mName;
    private String mNumber;
    private String memail;
    private boolean m = true;

    public Contact(String isMale, String mName, String mNumber, String memail) {
        this.isdate = isMale;
        this.mName = mName;
        this.mNumber = mNumber;
        this.memail = memail;
    }

    public boolean isM() {
        return m;
    }

    public void setM(boolean m) {
        this.m = m;
    }

    public String getIsdate() {
        return isdate;
    }

    public void setIsdate(String isdate) {
        this.isdate = isdate;
    }

    public String getMemail() {
        return memail;
    }

    public void setMemail(String memail) {
        this.memail = memail;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String isdate() {
        return isdate;
    }

    public void setMale(String isdate) {
        isdate = isdate;
    }
}
