import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/groceryItems")
    public GroceryItem addGroceryItem(@RequestBody GroceryItem groceryItem) {
        return adminService.addGroceryItem(groceryItem);
    }

    @GetMapping("/groceryItems")
    public List<GroceryItem> getAllGroceryItems() {
        return adminService.getAllGroceryItems();
    }

    @DeleteMapping("/groceryItems/{itemId}")
    public void removeGroceryItem(@PathVariable Long itemId) {
        adminService.removeGroceryItem(itemId);
    }

    @PutMapping("/groceryItems/{itemId}")
    public GroceryItem updateGroceryItem(@PathVariable Long itemId, @RequestBody GroceryItem updatedItem) {
        return adminService.updateGroceryItem(itemId, updatedItem);
    }

    @PostMapping("/groceryItems/{itemId}/inventory")
    public void manageInventory(@PathVariable Long itemId, @RequestParam int quantity) {
        adminService.manageInventory(itemId, quantity);
    }
}
