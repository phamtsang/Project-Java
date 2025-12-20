// Dashboard Stats Types
export interface DashboardStats {
  totalRevenue: number;
  totalOrders: number;
  totalCustomers: number;
  totalDebt: number;
  revenueChange: number;
  ordersChange: number;
}

// Sales Report Types
export interface SalesReport {
  date: string;
  revenue: number;
  orders: number;
}

// Top Product Types
export interface TopProduct {
  productId: number;
  productName: string;
  totalSold: number;
  revenue: number;
}

// Low Stock Alert Types
export interface LowStockAlert {
  productId: number;
  productName: string;
  quantityOnHand: number;
  unit: string;
}

// Debt Report Types
export interface DebtReport {
  customerId: number;
  customerName: string;
  totalDebt: number;
  lastTransaction: string;
}
