package lk.ijse.hybernate.embaded;

public class MobilNumber {
    private  String type;
    private  String mobileNo;

    public MobilNumber() {
    }

    public MobilNumber(String type, String mobileNo) {
        this.setType(type);
        this.setMobileNo(mobileNo);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
