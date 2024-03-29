package is.ru.honn.ruber.domain;

public class Product
{
  protected int id;
  protected String description;
  protected String displayName;
  protected int capacity;
  protected String image;

    public Product(int id, String description, String displayName, int capacity, String image) {
        this.id = id;
        this.description = description;
        this.displayName = displayName;
        this.capacity = capacity;
        this.image = image;
    }

    public Product(String description, String displayName, int capacity, String image) {
        this.description = description;
        this.displayName = displayName;
        this.capacity = capacity;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                ", capacity=" + capacity +
                ", image='" + image + '\'' +
                '}';
    }
}
