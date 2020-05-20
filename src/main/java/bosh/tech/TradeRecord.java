package bosh.tech;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TradeRecord {
    private String crabId;//螃蟹id
    private double weight;//重量
    private boolean doa;//死活情况

    private Date time;//交易时间

    private String location;//交易地点
    private String sender;//交易发出者
    private String senderCompany;
    private String receiverCompany;//交易接收者
    private String remark;//交易备注

    public TradeRecord() {
        crabId=null;
        weight=-1.0;
        doa=false;
        time=null;
        location=null;
        sender=null;
        receiverCompany=null;
        remark=null;
    }

    public TradeRecord(String tcrabId,
                       double tweight,
                       boolean tdoa,
                       Date ttime,
                       String tlocation,
                       String tsender,
                       String tsenderCompany,
                       String treceiver,
                       String tremark
    ) {
        crabId=tcrabId;
        weight=tweight;
        doa=tdoa;
        time=ttime;
        location=tlocation;
        sender=tsender;
        senderCompany=tsenderCompany;
        receiverCompany=treceiver;
        remark=tremark;
    }

    public TradeRecord(TradeRecord a) {
        crabId=a.getCrabId();
        weight=a.getWeight();
        doa=a.getDoa();
        time=a.getTime();
        location=a.getLocation();
        sender=a.getSender();
        senderCompany=a.getSenderCompany();
        receiverCompany=a.getReceiver();
        remark=a.getRemark();
    }

    public String getCrabId() {
        return crabId;
    }
    public void setCrabId(String crabId) {
        this.crabId = crabId;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public boolean getDoa() {
        return doa;
    }
    public void setDoa(boolean doa) {
        this.doa = doa;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getReceiver() {
        return receiverCompany;
    }
    public void setReceiver(String receiver) {
        this.receiverCompany = receiver;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSenderCompany() {
        return senderCompany;
    }

    public void setSenderCompany(String senderCompany) {
        this.senderCompany = senderCompany;
    }

    public String getReceiverCompany() {
        return receiverCompany;
    }

    public void setReceiverCompany(String receiverCompany) {
        this.receiverCompany = receiverCompany;
    }

    public void setTime(String tstring) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.time=sdf.parse(tstring);
    }

    public String getTimeString() {
        return time.toString();
    }
}
