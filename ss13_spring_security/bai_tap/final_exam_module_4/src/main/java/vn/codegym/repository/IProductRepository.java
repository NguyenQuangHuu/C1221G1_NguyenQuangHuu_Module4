package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.IOrdersDetail;
import vn.codegym.model.Product;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select orders.id orderId,product.name productName, product.price productPrice,\n" +
            "type_product.name typeProduct,\n" +
            "orders.buy_date buyDate,\n" +
            "orders.`quantity` orderQuantity,(orders.quantity * product.price) orderTotal from product inner join type_product on product.type_product = \n" +
            "type_product.id inner join orders on product.id = orders.product",
            countQuery ="select orders.id orderId,product.name productName, product.price productPrice,\n" +
                    "type_product.name typeProduct,\n" +
                    "orders.buy_date buyDate,\n" +
                    "orders.`quantity` orderQuantity,(orders.quantity * product.price) orderTotal from product inner join type_product on product.type_product = \n" +
                    "type_product.id inner join orders on product.id = orders.product",nativeQuery=true)
    Page<IOrdersDetail> listOrder(Pageable pageable);

    @Query(value="select orders.id orderId,product.name productName, product.price productPrice,\n" +
            "type_product.name typeProduct,\n" +
            "orders.buy_date buyDate,\n" +
            "orders.quantity orderQuantity,(orders.quantity * product.price) orderTotal from product inner join type_product on product.type_product = \n" +
            "type_product.id inner join orders on product.id = orders.product where orders.buy_date between :startDate and :endDate",
            countQuery="select orders.id orderId,product.name productName, product.price productPrice,\n" +
                    "type_product.name typeProduct,\n" +
                    "orders.buy_date buyDate,\n" +
                    "orders.quantity orderQuantity,(orders.quantity * product.price) orderTotal from product inner join type_product on product.type_product = \n" +
                    "type_product.id inner join orders on product.id = orders.product where orders.buy_date between :startDate and :endDate;"
            ,
            nativeQuery=true)
   Page<IOrdersDetail> searchOrder(@Param("startDate") String startDate,@Param("endDate") String endDate, Pageable pageable);

    @Query(value="select orders.id orderId,product.name productName, product.price productPrice,\n" +
            "type_product.name typeProduct,\n" +
            "orders.buy_date buyDate,\n" +
            "orders.quantity orderQuantity,(orders.quantity * product.price) orderTotal from product inner join type_product on product.type_product = \n" +
            "type_product.id inner join orders on product.id = orders.product order by (orders.quantity * product.price) desc",
            countQuery="select orders.id orderId,product.name productName, product.price productPrice,\n" +
            "type_product.name typeProduct,\n" +
            "orders.buy_date buyDate,\n" +
            "orders.quantity orderQuantity,(orders.quantity * product.price) orderTotal from product inner join type_product on product.type_product = \n" +
            "type_product.id inner join orders on product.id = orders.product order by (orders.quantity * product.price) desc",nativeQuery=true)
    Page<IOrdersDetail> topOrder(Pageable pageable);

}
