// 该包也类似于entity包
package org.nt.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 产品对象
 */
public class Product implements Serializable{
    private static final long serialVersionUID = -934619938981561049L;
    private String name;
    private String description;
    private BigDecimal price;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
