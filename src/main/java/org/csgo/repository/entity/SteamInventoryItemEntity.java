package org.csgo.repository.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Jeffrey on 5/27/2020.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class SteamInventoryItemEntity {
    @Id
    private String name;
    private String classid;
    private String icon_url;
    private String avgPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(String avgPrice) {
        this.avgPrice = avgPrice;
    }

    @Override
    public String toString() {
        return "SteamInventoryItemEntity{" +
                "name='" + name + '\'' +
                ", classid='" + classid + '\'' +
                ", icon_url='" + icon_url + '\'' +
                ", avgPrice='" + avgPrice + '\'' +
                '}';
    }
}
