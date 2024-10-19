package task5;

import java.util.Objects;

public class Product {
    private Long id;
    private String nameProduct;
    private Category category;
    private Double price;

    public Product(Long id, String nameProduct, Category category, Double price) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(nameProduct, product.nameProduct) && category == product.category && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameProduct, category, price);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(" Продукт: ");
        sb.append("название продукта = ").append(nameProduct).append(", категория = ").append(category).append(", стоимость = ").append(price);
        return sb.toString();
    }
}
