package learn.springcloud.configclient.model;
import javax.persistence.Entity; 

import javax.persistence.Id;
@Entity
public class Category {
    @Id
    private Long id;
    private String categoryName;

    
    public Category(){}
    public Category(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
