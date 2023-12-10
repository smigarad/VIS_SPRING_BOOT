package java1_2023_smi0132.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class OrderProductKey implements Serializable {

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "product_id")
    private int productId;

    public OrderProductKey() {
    }

    public OrderProductKey(int orderId, int productId) {
        this.orderId = orderId;
        this.productId = productId;
    }
}
