package pl.edu.wat.wcy.model.node;

import pl.edu.wat.wcy.model.CSVRow;
import pl.edu.wat.wcy.model.InsertQuery;

public class Address implements CSVRow, InsertQuery {

    private int id;

    private String province;

    private String city;

    private String street;

    private int buildingNumber;

    private Integer flatNumber;

    private String zipCode;

    public Address(int id, String province, String city, String street, int buildingNumber, Integer flatNumber, String zipCode) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.flatNumber = flatNumber;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber=" + buildingNumber +
                ", flatNumber=" + flatNumber +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    @Override
    public String getHeader() {
        return "id,province,city,street,buildingNumber,flatNumber,zipCode\n";
    }

    @Override
    public String toCSVRow() {
        return id + "," + province + "," + city + "," + street + "," + buildingNumber + "," + flatNumber + "," + zipCode + "\n";
    }

    @Override
    public String toInsertQuery() {
        return "INSERT INTO Address(id,province,city,street,buildingNumber,flatNumber,zipCode) " +
                "VALUES (" + id + ",'" + province + "','" + city + "','" + street + "'," + buildingNumber + "," + flatNumber + ",'" + zipCode + "');";
    }
}
