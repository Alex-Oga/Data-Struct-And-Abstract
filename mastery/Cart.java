public class Cart {
    Store store;
    Store copy = new Store();
    String[] items = new String[1];
    int size = 0;

    public Cart(Store store) {
        this.store = store;
    }

    public void addItem(String barcode) {
        if (size == items.length) {
            String[] expandedItems = new String[size*2];
            System.arraycopy(items, 0, expandedItems, 0, size);
            items = expandedItems;
        }
        try {
            if (store.findSellableByBarcode(barcode) != new ItemNotExistException(barcode)) {
                items[size] = barcode;
                size++;
            }
        }
        catch (ItemNotExistException e) {

        }
    }

    public double getTotal() {
        double total = 0;
        for (int i=0; i<size; i++) {
            total += store.findSellableByBarcode(items[i]).getAfterTaxPrice();
        }
        return total;
    }

    public int getItemCount() {
        return size;
    }

    public int getUniqueItemCount() {
        int counter = 0;
        for (int i=0; i<size; i++) {
            counter -= 1;
            for (int j=0; j<size; j++) {
                if (items[i].equals(items[j]))
                    counter++;
            }
        }
        return size-counter;
    }

}
