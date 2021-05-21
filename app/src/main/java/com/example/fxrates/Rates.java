
package com.example.fxrates;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rates {

    @SerializedName("GBP")
    @Expose
    private Double gbp;

    @SerializedName("HKD")
    @Expose
    private Double hkd;

    @SerializedName("DKK")
    @Expose
    private Double dkk;
    @SerializedName("INR")
    @Expose
    private Double inr;

    @SerializedName("MXN")
    @Expose
    private Double mxn;

    @SerializedName("NZD")
    @Expose
    private Double nzd;

    @SerializedName("JPY")
    @Expose
    private Double jpy;
    @SerializedName("RUB")
    @Expose
    private Double rub;

    @SerializedName("USD")
    @Expose
    private Double usd;

    @SerializedName("AUD")
    @Expose
    private Double aud;

    public Double getGbp() {
        return gbp;
    }

    public void setGbp(Double gbp) {
        this.gbp = gbp;
    }

    public Double getHkd() {
        return hkd;
    }

    public void setHkd(Double hkd) {
        this.hkd = hkd;
    }

    public Double getDkk() {
        return dkk;
    }

    public void setDkk(Double dkk) {
        this.dkk = dkk;
    }

    public Double getInr() {
        return inr;
    }

    public void setInr(Double inr) {
        this.inr = inr;
    }

    public Double getMxn() {
        return mxn;
    }

    public void setMxn(Double mxn) {
        this.mxn = mxn;
    }

    public Double getNzd() {
        return nzd;
    }

    public void setNzd(Double nzd) {
        this.nzd = nzd;
    }

    public Double getJpy() {
        return jpy;
    }

    public void setJpy(Double jpy) {
        this.jpy = jpy;
    }

    public Double getRub() {
        return rub;
    }

    public void setRub(Double rub) {
        this.rub = rub;
    }

    public Double getUsd() {
        return usd;
    }

    public void setUsd(Double usd) {
        this.usd = usd;
    }

    public Double getAud() {
        return aud;
    }

    public void setAud(Double aud) {
        this.aud = aud;
    }
}
