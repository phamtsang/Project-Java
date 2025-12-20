// Notification Types
export enum NotificationType {
  AI_ORDER_DRAFT = 'AI_ORDER_DRAFT',
  ORDER_CONFIRMED = 'ORDER_CONFIRMED',
  LOW_STOCK = 'LOW_STOCK',
  PAYMENT_RECEIVED = 'PAYMENT_RECEIVED',
}

export interface Notification {
  id: string;
  type: NotificationType;
  title: string;
  message: string;
  data?: any;
  isRead: boolean;
  createdAt: string;
}

// AI Order Draft Types
export interface AIOrderDraft {
  id: string;
  rawInput: string;
  parsedData: {
    customerName?: string;
    items: {
      productName: string;
      quantity: number;
      unit?: string;
    }[];
    note?: string;
  };
  confidence: number;
  status: 'PENDING' | 'CONFIRMED' | 'REJECTED';
  createdAt: string;
}
