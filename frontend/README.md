# BizFlow Frontend

Nền tảng hỗ trợ chuyển đổi số cho doanh nghiệp hộ gia đình - Web Application

## Tech Stack

- **Framework:** Next.js 14 (App Router)
- **Language:** TypeScript
- **Styling:** TailwindCSS + Shadcn UI
- **State Management:** Zustand + Tanstack Query
- **HTTP Client:** Axios
- **Authentication:** NextAuth.js

## Getting Started

### Prerequisites

- Node.js 18+ 
- npm hoặc yarn

### Installation

```bash
# Install dependencies
npm install

# Run development server
npm run dev

# Build for production
npm run build

# Start production server
npm start
```

### Environment Variables

Tạo file `.env.local`:

```env
NEXT_PUBLIC_API_URL=http://localhost:8080/api
NEXT_PUBLIC_WS_URL=ws://localhost:8080/ws
NEXTAUTH_URL=http://localhost:3000
NEXTAUTH_SECRET=your-secret-key-here
```

## Project Structure

```
src/
├── app/                    # Next.js App Router pages
│   ├── (dashboard)/       # Protected dashboard routes
│   ├── login/             # Auth pages
│   └── layout.tsx         # Root layout
├── components/            # React components
│   ├── ui/               # Shadcn UI components
│   ├── auth/             # Authentication components
│   ├── layout/           # Layout components
│   ├── dashboard/        # Dashboard components
│   ├── orders/           # Order management
│   ├── products/         # Product management
│   ├── customers/        # Customer management
│   └── providers.tsx     # App providers
├── lib/                  # Utility functions
├── services/             # API services
├── hooks/                # Custom React hooks
├── stores/               # Zustand stores
└── types/                # TypeScript types
```

## Features

### Worker/Employee
- Tạo đơn hàng tại quầy
- Ghi nhận công nợ khách hàng
- In hóa đơn
- Nhận thông báo real-time
- Xác nhận đơn hàng AI

### Owner
- Tất cả chức năng của Worker
- Quản lý sản phẩm và đơn vị đo
- Quản lý hàng tồn kho
- Quản lý khách hàng
- Xem báo cáo và phân tích
- Quản lý tài khoản nhân viên

### Admin
- Quản lý tài khoản chủ cửa hàng
- Quản lý giá subscription
- Xem báo cáo toàn nền tảng
- Cấu hình hệ thống

## Development

```bash
# Type checking
npm run type-check

# Linting
npm run lint
```

## License

Private Project
