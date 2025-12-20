import { OrderList } from '@/components/orders/order-list';
import { Button } from '@/components/ui/button';
import { Plus } from 'lucide-react';
import Link from 'next/link';

export default function OrdersPage() {
  return (
    <div className="space-y-6">
      <div className="flex items-center justify-between">
        <div>
          <h1 className="text-3xl font-bold">Đơn hàng</h1>
          <p className="text-muted-foreground">
            Quản lý tất cả đơn hàng của cửa hàng
          </p>
        </div>
        <Link href="/orders/create">
          <Button>
            <Plus className="mr-2 h-4 w-4" />
            Tạo đơn hàng
          </Button>
        </Link>
      </div>
      <OrderList />
    </div>
  );
}
