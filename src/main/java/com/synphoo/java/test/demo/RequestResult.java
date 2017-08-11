package com.synphoo.java.test.demo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestResult", propOrder = {
    "status",
    "result",
    "content"
})
public class RequestResult {

    @XmlElement(name = "Status")
    protected int status;
    @XmlElement(name = "Result")
    protected Object result;
    @XmlElement(name = "Content")
    protected String content;

    public int getStatus() {
        return status;
    }

    public void setStatus(int value) {
        this.status = value;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object value) {
        this.result = value;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String value) {
        this.content = value;
    }

}
