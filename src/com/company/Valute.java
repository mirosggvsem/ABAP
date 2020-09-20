package com.company;

public class Valute {
    private String NumCode;
    private String CharCode;
    private String Nominal;
    private  String Name;
    private String Value;


    public Valute(String numCode, String charCode, String nominal, String name, String value) {
        this.NumCode = numCode;
        this.CharCode = charCode;
        this.Nominal = nominal;
        this.Name = name;
        this.Value = value;
    }

    public Valute() {

    }


    public String  getNumCode() {
        return NumCode;
    }

    public String getCharCode() {
        return CharCode;
    }

    public String getNominal() {
        return Nominal;
    }

    public String getName() {
        return Name;
    }

    public String getValue() {
        return Value;
    }

    public void setNumCode(String numCode) {
        NumCode = numCode;
    }

    public void setCharCode(String charCode) {
        CharCode = charCode;
    }

    public void setNominal(String nominal) {
        Nominal = nominal;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setValue(String value) {
        Value = value;
    }
}