
package com.example.fxrates;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PostList extends Throwable {

    @SerializedName("base_code")
    @Expose
    private String base_code;
    @SerializedName("conversion_rates")
    @Expose
    private Rates conversion_rates;
    @SerializedName("time_last_update_utc")
    @Expose
    private String time_last_update_utc;

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public Rates getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(Rates conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    public void setTime_last_update_utc(String time_last_update_utc) {
        this.time_last_update_utc = time_last_update_utc;
    }
}
