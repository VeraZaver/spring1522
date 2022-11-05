package com.example.spring152.models;

import com.example.spring152.models.enams.ItemEnum;

import javax.persistence.*;

@Entity
@Table(name = "shop_item")
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "discription")
    private String disc;

    @Column(name = "price")
    private String price;

    @Column(name = "url")
    private String url;

    @Enumerated
    @Column(name = "item_type")
    ItemEnum itemEnum;

    public ItemModel() {
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDisc() {
        return this.disc;
    }

    public String getPrice() {
        return this.price;
    }

    public String getUrl() {
        return this.url;
    }

    public ItemEnum getItemEnum() {
        return this.itemEnum;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setItemEnum(ItemEnum itemEnum) {
        this.itemEnum = itemEnum;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ItemModel)) return false;
        final ItemModel other = (ItemModel) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$disc = this.getDisc();
        final Object other$disc = other.getDisc();
        if (this$disc == null ? other$disc != null : !this$disc.equals(other$disc)) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$url = this.getUrl();
        final Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) return false;
        final Object this$itemEnum = this.getItemEnum();
        final Object other$itemEnum = other.getItemEnum();
        if (this$itemEnum == null ? other$itemEnum != null : !this$itemEnum.equals(other$itemEnum)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ItemModel;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $disc = this.getDisc();
        result = result * PRIME + ($disc == null ? 43 : $disc.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        final Object $itemEnum = this.getItemEnum();
        result = result * PRIME + ($itemEnum == null ? 43 : $itemEnum.hashCode());
        return result;
    }

    public String toString() {
        return "ItemModel(id=" + this.getId() + ", name=" + this.getName() + ", disc=" + this.getDisc() + ", price=" + this.getPrice() + ", url=" + this.getUrl() + ", itemEnum=" + this.getItemEnum() + ")";
    }
}
