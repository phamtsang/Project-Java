// Customer Types
export interface Customer {
  id: number;
  storeId: number;
  name: string;
  phone: string | null;
  address: string | null;
  currentDebt: number;
  createdAt: string;
}

// Debt Transaction Types
export enum DebtTransactionType {
  INCREASE = 'INCREASE',
  DECREASE = 'DECREASE',
}

export interface DebtTransaction {
  id: number;
  customerId: number;
  orderId: number | null;
  amount: number;
  transactionType: DebtTransactionType;
  note: string | null;
  createdAt: string;
}

export interface CustomerWithDebt extends Customer {
  debtTransactions: DebtTransaction[];
}
