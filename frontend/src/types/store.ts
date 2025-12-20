// Store Types
export enum StoreStatus {
  ACTIVE = 'ACTIVE',
  INACTIVE = 'INACTIVE',
  SUSPENDED = 'SUSPENDED',
}

export interface Store {
  id: number;
  name: string;
  subscriptionEndDate: string | null;
  status: StoreStatus;
  createdAt: string;
  subscriptionPlanId: number | null;
}

// Subscription Plan Types
export interface SubscriptionPlan {
  id: number;
  name: string;
  price: number;
  description: string | null;
  maxOrdersPerMonth: number;
}

export interface StoreWithPlan extends Store {
  subscriptionPlan: SubscriptionPlan | null;
}
