package ethniconnect_backend.Order;


import ethniconnect_backend.ChefCreateMenu.ChefMenu;
import ethniconnect_backend.Cuisines.CuisineCategory;
import ethniconnect_backend.CustomerDetails.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue
    private int order_id;
    private long chef_loginid;
    private int cust_loginid;
    private int menu_id;
    private LocalDate order_date;

    private double order_amount;

   /* @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "orders")
    private Customer customer;*/
   @ManyToOne
   @JoinColumn(name="loginid", insertable = false, updatable = false)
   private Customer customer;
    @ManyToMany
    @JoinTable(
            name = "order_menu",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    Set<ChefMenu> menu_items;
}
