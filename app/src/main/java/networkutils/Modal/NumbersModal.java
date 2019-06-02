package networkutils.Modal;

import com.google.gson.annotations.SerializedName;

public class NumbersModal {


    private String number;
    private String found;
    private String year;

    @SerializedName("text")
    private String text;

    private String type;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFound() {
        return found;
    }

    public void setFound(String found) {
        this.found = found;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ClassPojo [number = " + number + ", found = " + found + ", year = " + year + ", text = " + text + ", type = " + type + "]";
    }
}

