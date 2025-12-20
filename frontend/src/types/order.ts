import { Customer } from './customer';
import { User } from './auth';
import { Product } from './product';

// Order Status
export enum OrderStatus {
  PENDING = 'PENDING',
  CONFIRMED = 'CONFIRMED',
  COMPLETED = 'COMPLETED',
  CANCELLED = 'CANCELLED',
}

// Payment Status
export enum PaymentStatus {
  UNPAID = 'UNPAID',
  PARTIAL = 'PARTIAL',
  PAID = 'PAID',
}

// Order Type
export interface Order {
  id: number;
  storeId: number;
  customerId: number | null;
  userId: number;
  code: string;
  totalAmount: number;
  discount: number;
  finalAmount: number;
  status: OrderStatus;
  paymentStatus: PaymentStatus;
  isAiGenerated: boolean;
  aiNote: string | null;
  createdAt: string;
  updatedAt: string;
}

// Order Item Type
export interface OrderItem {
  id: number;
  orderId: number;
  productId: number;
  productUnitId: number;
  quantity: number;
  unitPrice: number;
  subtotal: number;
}

// Order with relations
export interface OrderWithDetails extends Order {
  customer: Customer | null;
  user: User;
  items: OrderItemWithProduct[];
}

export interface OrderItemWithProduct extends OrderItem {
  product: Product;
  productUnit: {
    id: number;
    unitName: string;
  };
}

// Create Order DTO
export interface CreateOrderDTO {
  customerId?: number;
  items: {
    productId: number;
    productUnitId: number;
    quantity: number;
    unitPrice: number;
  }[];
  discount?: number;
  paymentStatus: PaymentStatus;
}
