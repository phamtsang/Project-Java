// Product Types
export interface Product {
  id: number;
  storeId: number;
  categoryId: number | null;
  name: string;
  imageUrl: string | null;
  isActive: boolean;
  createdAt: string;
}

export interface ProductUnit {
  id: number;
  productId: number;
  unitName: string;
  price: number;
  conversionRate: number;
  isBaseUnit: boolean;
}

export interface ProductWithUnits extends Product {
  units: ProductUnit[];
  category?: Category;
}

// Category Types
export interface Category {
  id: number;
  storeId: number;
  name: string;
  description: string | null;
}

// Inventory Types
export interface Inventory {
  productId: number;
  storeId: number;
  quantityOnHand: number;
  lastUpdated: string;
}

export interface InventoryWithProduct extends Inventory {
  product: Product;
}
