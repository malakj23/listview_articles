package com.example.user.test.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class article {

    @SerializedName("ref")
    @Expose
    private String ref;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("type_dress")
    @Expose
    private String typeDress;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("descrp")
    @Expose
    private String descrp;
    @SerializedName("imageURL")
    @Expose
    private String imageURL;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTypeDress() {
        return typeDress;
    }

    public void setTypeDress(String typeDress) {
        this.typeDress = typeDress;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

}