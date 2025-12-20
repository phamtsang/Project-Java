// User Roles
export enum UserRole {
  WORKER = 'WORKER',
  OWNER = 'OWNER',
  ADMIN = 'ADMIN',
}

// User Status
export enum UserStatus {
  ACTIVE = 'ACTIVE',
  INACTIVE = 'INACTIVE',
}

// User Type
export interface User {
  id: number;
  storeId: number | null;
  username: string;
  fullName: string;
  role: UserRole;
  status: UserStatus;
  createdAt: string;
}

// Auth Types
export interface LoginCredentials {
  username: string;
  password: string;
}

export interface AuthResponse {
  user: User;
  token: string;
}

export interface AuthState {
  user: User | null;
  token: string | null;
  isAuthenticated: boolean;
}
