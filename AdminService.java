// AdminService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminController {
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public GroceryItem addGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public void removeGroceryItem(Long itemId) {
        groceryItemRepository.deleteById(itemId);
    }

    public GroceryItem updateGroceryItem(Long itemId, GroceryItem updatedItem) {
        updatedItem.setId(itemId);
        return groceryItemRepository.save(updatedItem);
    }

    public void manageInventory(Long itemId, int quantity) {
        GroceryItem groceryItem = groceryItemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Grocery item not found"));
        groceryItem.setQuantity(groceryItem.getQuantity() + quantity);
        groceryItemRepository.save(groceryItem);
    }
}
