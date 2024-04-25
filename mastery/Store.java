public class Store {
    Sellable[] items = new Sellable[1];
    int size = 0;

    public void addSellable(Sellable a) {
        for (int i=0; i<size; i++) {
            if (items[i].getBarcode().equals(a.getBarcode()))
                throw new DuplicateBarcodeException(a.getBarcode());
        }
        if (size == items.length) {
            Sellable[] expandedItems = new Sellable[size*2];
            System.arraycopy(items, 0, expandedItems, 0, size);
            items = expandedItems;
        }
        items[size] = a;
        size++;
    }

    public Sellable findSellableByBarcode(String barcode) {
        for (int i = 0; i < size; i++) {
            if (items[i].getBarcode().equals(barcode))
                return items[i];
        }
        throw new ItemNotExistException(barcode);
    }

    public int getSize() {
        return size;
    }

}
